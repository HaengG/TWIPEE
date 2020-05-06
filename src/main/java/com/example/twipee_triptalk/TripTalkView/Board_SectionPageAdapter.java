package com.example.twipee_triptalk.TripTalkView;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.twipee_triptalk.MainView.NearInfoView;
import com.example.twipee_triptalk.MainView.SNSView;
import com.example.twipee_triptalk.MainView.UserInfoView;
import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.TripTalkView.Board.Board_BabyCar;
import com.example.twipee_triptalk.TripTalkView.Board.Board_Baggage;
import com.example.twipee_triptalk.TripTalkView.Board.Board_Camera;

public class Board_SectionPageAdapter extends FragmentPagerAdapter {

    private static final int[] TAP_TITLE = new int[]{R.string.board_camera, R.string.board_babycar, R.string.board_baggage};
    private final Context mContext;

    public Board_Camera mBoard_Camera = null;
    public Board_BabyCar mBoard_BabyCar = null;
    public Board_Baggage mBoard_Baggage= null;



    public Board_SectionPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return mBoard_Camera = new Board_Camera();
            case 1:
                return  mBoard_BabyCar = new Board_BabyCar();
            case 2:
                return mBoard_Baggage = new Board_Baggage();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
