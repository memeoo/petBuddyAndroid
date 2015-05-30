


/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package project.pb.petbuddy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import project.pb.petbuddy.R;
import project.pb.petbuddy.adapter.MainPagerAdapter;
import project.pb.petbuddy.data.SitterData;
import project.pb.petbuddy.views.SlidingTabLayout;

/**
 * A basic sample which shows how to use {@link com.example.android.common.view.SlidingTabLayout}
 * to display a custom {@link ViewPager} title strip which gives continuous feedback to the user
 * when scrolling.
 */
public class SlidingTabsBasicFragment extends Fragment {

    static final String LOG_TAG = "SlidingTabsBasicFragment";
    private SlidingTabLayout mSlidingTabLayout;
    private MainPagerAdapter mViewPagerAdapter;

    private ViewPager mViewPager;

    public SlidingTabsBasicFragment(){

    }

    public static SlidingTabsBasicFragment newInstance() {
        SlidingTabsBasicFragment fragment = new SlidingTabsBasicFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sample, container, false);
        mViewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        mSlidingTabLayout = (SlidingTabLayout) rootView.findViewById(R.id.sliding_tabs);
        mViewPagerAdapter = new MainPagerAdapter(getFragmentManager(), getActivity(), mSlidingTabLayout);
        mViewPager.setAdapter(mViewPagerAdapter);
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.

        mSlidingTabLayout.setViewPager(mViewPager);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Get the ViewPager and set it's PagerAdapter so that it can display items
//        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
//        mViewPagerAdapter = new MainPagerAdapter(getFragmentManager(), getActivity(), mSlidingTabLayout);
//        mViewPager.setAdapter(mViewPagerAdapter);
//
//        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
//        // it's PagerAdapter set.
//        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
//        mSlidingTabLayout.setViewPager(mViewPager);
    }




    /**
     * The {@link android.support.v4.view.PagerAdapter} used to display pages in this sample.
     * The individual pages are simple and just display two lines of text. The important section of
     * this class is the {@link #getPageTitle(int)} method which controls what is displayed in the
     * {@link SlidingTabLayout}.
     */
//    class SamplePagerAdapter extends PagerAdapter {
//
//        private ListView listPetSitter;
//        private ListViewAdapter listViewAdapter;
//        /**
//         * @return the number of pages to display
//         */
//        @Override
//        public int getCount() {
//            return 2;
//        }
//
//        /**
//         * @return true if the value returned from {@link #instantiateItem(ViewGroup, int)} is the
//         * same object as the {@link View} added to the {@link ViewPager}.
//         */
//        @Override
//        public boolean isViewFromObject(View view, Object o) {
//            return o == view;
//        }
//
//        /**
//         * Return the title of the item at {@code position}. This is important as what this method
//         * returns is what is displayed in the {@link SlidingTabLayout}.
//         * <p/>
//         * Here we construct one using the position value, but for real application the title should
//         * refer to the item's contents.
//         */
//        @Override
//        public CharSequence getPageTitle(int position) {
//            CharSequence cs;
//            if(position == 0){
//                cs = "돌봐 드릴께요";
//            }else{
//                cs = "돌봐 주세요";
//            }
//            return cs;
//        }
//
//        /**
//         * Instantiate the {@link View} which should be displayed at {@code position}. Here we
//         * inflate a layout from the apps resources and then change the text view to signify the position.
//         */
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            // Inflate a new layout from our resources
//            View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_main,
//                    container, false);
//            // Add the newly created View to the ViewPager
//            container.addView(view);
//
//            // Retrieve a TextView from the inflated View, and update it's text
////            listPetSitter = (ListView) view.findViewById(R.id.listPetSitter);
////            listViewAdapter = new ListViewAdapter(getActivity());
////            listPetSitter.setAdapter(listViewAdapter);
//
////            Log.i(LOG_TAG, "instantiateItem() [position: " + position + "]");
//
//            // Return the View
//            return view;
//        }
//
//        /**
//         * Destroy the item from the {@link ViewPager}. In our case this is simply removing the
//         * {@link View}.
//         */
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//            Log.i(LOG_TAG, "destroyItem() [position: " + position + "]");
//        }
//
//    }
}
