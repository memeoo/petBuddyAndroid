package project.pb.petbuddy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.pb.petbuddy.R;
import project.pb.petbuddy.views.SlidingTabLayout;
import project.pb.petbuddy.views.StoppableViewPager;


public class MainFragment extends Fragment {

//    private SlidingTabLayout mSlidingTabLayout;
    private StoppableViewPager mViewPager;
    private CoachPagerAdapter mViewPagerAdapter;
    private SlidingTabLayout mSlidingTabLayout;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_teacher, container, false);

        return rootView;
    }

//    public void goToTab(final int position) {
//        mSlidingTabLayout.goToTab(position);
//    }
}
