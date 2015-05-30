package project.pb.petbuddy.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import project.pb.petbuddy.fragment.OriginEachTabFragment;
import project.pb.petbuddy.fragment.SlidingTabsBasicFragment;
import project.pb.petbuddy.views.SlidingTabLayout;

/**
 * Created by meme on 15. 5. 28..
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private Activity mContext;
    private OriginEachTabFragment[] mStbFragmentArray;
    private SlidingTabLayout mSlidingTabLayout;



    public MainPagerAdapter(FragmentManager fm, Activity context, SlidingTabLayout slidingTabLayout) {
        super(fm);

        mContext =context;
        mStbFragmentArray = new OriginEachTabFragment[getCount()];
        mSlidingTabLayout = slidingTabLayout;
    }

    @Override
    public Fragment getItem(int position) {

        if(mStbFragmentArray[position] == null){
            mStbFragmentArray[position] = OriginEachTabFragment.getInstance(position);
            mStbFragmentArray[position].setSlidingTabLayout(mSlidingTabLayout);
        }
        return mStbFragmentArray[position];
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title = null;
        switch (position) {
            case 0:
                title = "돌봐 드려요";
                break;
            case 1:
                title = "돌봐 주세요";
                break;
        }
        return title;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        for (int i = 0; i < getCount(); i++) {
            if (mStbFragmentArray[i] == object) {
                Log.d("meme", "fragment destroyed...");
                mStbFragmentArray[i] = null;
                break;
            }
        }
    }


}
