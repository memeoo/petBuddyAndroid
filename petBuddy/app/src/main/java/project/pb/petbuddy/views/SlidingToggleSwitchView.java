package project.pb.petbuddy.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.nineoldandroids.view.ViewHelper;

import project.pb.petbuddy.R;


public class SlidingToggleSwitchView extends FrameLayout implements
        OnClickListener {

    public static int LEFT_SELECTED = 0;
    private int POSITION = LEFT_SELECTED;
    public static int RIGHT_SELECTED = 1;
    private Button btnMovable;
    private Button btnLeft;
    private Button btnRight;
    private OnToggleListener listener;
    private String leftButtonText;
    private String rightButtonText;
    private int selectedTextColor;
    private int unselectedTextColor;
    private Drawable sliderBackground;
    private Drawable buttonBackground;
    private boolean ischecked;

    public SlidingToggleSwitchView(Context context) {
        this(context, null);
    }

    public SlidingToggleSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.sliding_toggle_switch, this, true);

        btnMovable = (Button) v.findViewById(R.id.movable_button);
        btnLeft = (Button) v.findViewById(R.id.button_left);
        btnRight = (Button) v.findViewById(R.id.button_right);

        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);

//        listener = (OnToggleListener) context;

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.SlidingToggleSwitch, 0, 0);

        leftButtonText = a
                .getString(R.styleable.SlidingToggleSwitch_leftButtonText);
        rightButtonText = a
                .getString(R.styleable.SlidingToggleSwitch_rightButtonText);
        selectedTextColor = a.getColor(
                R.styleable.SlidingToggleSwitch_selectedTextColor,
                android.R.color.holo_blue_dark);
        unselectedTextColor = a.getColor(
                R.styleable.SlidingToggleSwitch_unselectedTextColor,
                android.R.color.holo_blue_dark);
        sliderBackground = a
                .getDrawable(R.styleable.SlidingToggleSwitch_sliderBackground);
        buttonBackground = a
                .getDrawable(R.styleable.SlidingToggleSwitch_toggleBackground);

        ischecked = a.getBoolean(R.styleable.SlidingToggleSwitch_togglechecked, false);

        POSITION = a.getBoolean(R.styleable.SlidingToggleSwitch_togglechecked, false) == true ? RIGHT_SELECTED : LEFT_SELECTED;

        if (!TextUtils.isEmpty(leftButtonText))
            btnLeft.setText(leftButtonText);
        if (!TextUtils.isEmpty(rightButtonText))
            btnRight.setText(rightButtonText);
        btnLeft.setTextColor(selectedTextColor);
        btnRight.setTextColor(unselectedTextColor);

//        if (sliderBackground == null)
//            this.setBackgroundDrawable(getResources().getDrawable(
//                    R.drawable.toggle_frame));
//        else
        this.setBackgroundDrawable(sliderBackground);

        if (buttonBackground != null)
            btnMovable.setBackgroundDrawable(buttonBackground);

    }

    public SlidingToggleSwitchView(Context context, AttributeSet attrs,
                                   int defStyle) {
        this(context, attrs);
    }

    @Override
    public void onClick(View v) {
        if (POSITION == RIGHT_SELECTED) {
            POSITION = LEFT_SELECTED;

            float destX = ViewHelper.getX(btnLeft);
            ObjectAnimator shiftLeft = ObjectAnimator.ofFloat(btnMovable, "x",
                    destX);
            shiftLeft.setDuration(150);
            shiftLeft.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    listener.onToggle(LEFT_SELECTED);
                    btnLeft.setTextColor(selectedTextColor);
                    btnRight.setTextColor(unselectedTextColor);
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                }
            });
            shiftLeft.start();
        } else {
            POSITION = RIGHT_SELECTED;
            float destX = ViewHelper.getX(btnRight);
            ObjectAnimator shiftRight = ObjectAnimator.ofFloat(btnMovable, "x",
                    destX);
            shiftRight.setDuration(150);
            shiftRight.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    listener.onToggle(RIGHT_SELECTED);
                    btnLeft.setTextColor(unselectedTextColor);
                    btnRight.setTextColor(selectedTextColor);
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                }
            });
            shiftRight.start();
        }

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (POSITION == RIGHT_SELECTED) {
            btnMovable.setX(ViewHelper.getX(btnRight));
        } else {
            btnMovable.setX(ViewHelper.getX(btnLeft));
        }
    }

    /**
     * to set state
     * Lift state == Unchecked
     * Right state == Checked.
     *
     * @param checked  Lift state == Unchecked  , Right state == Checked.
     * @param anim     use animation or not
     * @param callback use callback or not
     */
    public void setChecked(boolean checked, boolean anim, boolean callback) {
        if (checked && (POSITION == LEFT_SELECTED)) {
            POSITION = RIGHT_SELECTED;
            btnLeft.setTextColor(unselectedTextColor);
            btnRight.setTextColor(selectedTextColor);
            if (callback)
                listener.onToggle(RIGHT_SELECTED);
            if (anim) {
                float destX = ViewHelper.getX(btnRight);
                ObjectAnimator shiftRight = ObjectAnimator.ofFloat(btnMovable, "x",
                        destX);
                shiftRight.start();
            } else {
                btnMovable.setX(ViewHelper.getX(btnRight));
            }

        } else if (!checked && (POSITION == RIGHT_SELECTED)) {
            POSITION = LEFT_SELECTED;
            btnLeft.setTextColor(selectedTextColor);
            btnRight.setTextColor(unselectedTextColor);
            if (callback)
                listener.onToggle(LEFT_SELECTED);
            if (anim) {
                float destX = ViewHelper.getX(btnLeft);
                ObjectAnimator shiftLeft = ObjectAnimator.ofFloat(btnMovable, "x",
                        destX);
                shiftLeft.start();
            } else {
                btnMovable.setX(ViewHelper.getX(btnLeft));
            }

        }
    }

    /**
     * Lift state == Unchecked
     * Right state == Checked.
     *
     * @return
     */
    public boolean isChecked() {
        if (POSITION == RIGHT_SELECTED)
            return true;
        return false;
    }

    public void onSetListener(OnToggleListener listener) {
        this.listener = listener;
    }

    public static interface OnToggleListener {
        public void onToggle(int result);
    }
}