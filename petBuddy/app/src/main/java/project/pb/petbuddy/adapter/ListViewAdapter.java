package project.pb.petbuddy.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import project.pb.petbuddy.R;
import project.pb.petbuddy.data.SitterData;
import project.pb.petbuddy.fragment.SlidingTabsBasicFragment;
import project.pb.petbuddy.views.SlidingTabLayout;

/**
 * Created by meme on 15. 5. 28..
 */
public class ListViewAdapter extends BaseAdapter {
    private Context mContext = null;
    private ArrayList<SitterData> mListData;


    public ListViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
        mListData = new ArrayList<SitterData>();
        mListData.add(new SitterData("Jane", "Seoul", mContext.getResources().getDrawable(R.drawable.member1)));
        mListData.add(new SitterData("Cindy", "Seoul", mContext.getResources().getDrawable(R.drawable.member2)));

    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_list_row, null);

            holder.imgProfile = (ImageView)convertView.findViewById(R.id.imgProfile);
            holder.tvNick = (TextView) convertView.findViewById(R.id.tvNickName);
            holder.tvAddress = (TextView) convertView.findViewById(R.id.tvAddress);
            holder.tvAvgRate = (TextView) convertView.findViewById(R.id.tvRateVal);
            holder.tvHostingCnt = (TextView) convertView.findViewById(R.id.tvHostingCnt);
            holder.tvMaxReHostingCnt = (TextView) convertView.findViewById(R.id.tvMaxReHostingCnt);
            holder.tvReviewCnt = (TextView) convertView.findViewById(R.id.tvReviewCnt);
            holder.tvPriceDay =(TextView)convertView.findViewById(R.id.tvPriceDay);
            holder.tvPriceHour =(TextView)convertView.findViewById(R.id.tvPriceHour);
            holder.tvMiniResume = (TextView) convertView.findViewById(R.id.tvMiniResume);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        SitterData mData = mListData.get(position);


        if (mData.profileImg != null) {
            holder.imgProfile.setImageDrawable(mData.profileImg);
        }else{
            holder.imgProfile.setImageDrawable(mContext.getResources().getDrawable(R.drawable.facebook_default_profile_pic));
        }

        if(mData != null) {
            holder.tvNick.setText(mData.nickName);
            holder.tvAddress.setText(mData.addRess);
            holder.tvAvgRate.setText(mData.avgRate + "");
            holder.tvHostingCnt.setText(mData.hostingCnt + "");
            holder.tvMaxReHostingCnt.setText(mData.maxReHostingCnt + "");
            holder.tvReviewCnt.setText(mData.reviewCnt + "");
            holder.tvPriceDay.setText(mData.priceDay + "");
            holder.tvPriceHour.setText(mData.priceHour + "");
            holder.tvMiniResume.setText(mData.miniResume);
        }

        return convertView;
    }

    private class ViewHolder{
        public ImageView imgProfile;
        public TextView tvNick, tvAddress, tvAvgRate, tvReviewCnt, tvHostingCnt, tvMaxReHostingCnt, tvMiniResume, tvPriceDay, tvPriceHour;

    }
}
