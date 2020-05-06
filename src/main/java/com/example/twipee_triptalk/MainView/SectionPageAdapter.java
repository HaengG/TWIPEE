package com.example.twipee_triptalk.MainView;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.TripTalkView.TripTalkView;

public class SectionPageAdapter extends FragmentPagerAdapter {

    private static final int[] TAP_TITLE = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3,R.string.tab_text_4};
    private final Context mContext;

    public SNSView mSNSView = null;
    public NearInfoView mNearInfoView = null;
    public UserInfoView mUserInfoView= null;
    public TripTalkView mTripTalkView = null;


    public SectionPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    public CharSequence getPageTitle(int position)
    {
        return mContext.getResources().getString(TAP_TITLE[position]);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return mSNSView = new SNSView();
            case 1:
                return  mTripTalkView = new TripTalkView();
            case 2:
                return mNearInfoView = new NearInfoView();
            case 3:
                return mUserInfoView = new UserInfoView();
            default:
            return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
