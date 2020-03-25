package com.NSLB.TWIPEE.Ui.main;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.NSLB.TWIPEE.R;
import com.NSLB.TWIPEE.User.Follow;
import com.NSLB.TWIPEE.User.PostMain;
import com.NSLB.TWIPEE.User.Travel;
import com.NSLB.TWIPEE.User.UserSetup;
import com.google.android.material.tabs.TabLayout;

public class UserInfoView extends Fragment implements View.OnClickListener{

    private Button ps_write,btn_follower,btn_following;
    private ImageButton btn_setup,btn_travel;
    Intent MyStepService;
    private String tvStepDetector;
    private ToggleButton btn_toggle1;
    String serviceData;
    BroadcastReceiver receiver;

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        //MainActivity에서 step불러오기
//        tvStepDetector= getArguments().getString("Total_Step");

        View view= inflater.inflate(R.layout.fragment_user_view , container , false);
        TabLayout tabs=view.findViewById(R.id.tabs_userinfo);
        //탭 아이콘
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_apps_black_24dp));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.ic_location_on2_black_24dp));
        tabs.setTabGravity(tabs.GRAVITY_FILL);
        final ViewPager viewPager=view.findViewById(R.id.userview);
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        //버튼
        ps_write=(Button)view.findViewById(R.id.ps_write);
        ps_write.setOnClickListener(this);
        btn_setup=(ImageButton)view.findViewById(R.id.btn_setup);
        btn_setup.setOnClickListener(this);
        btn_travel=(ImageButton)view.findViewById(R.id.btn_travel);
        btn_travel.setOnClickListener(this);
        btn_follower=(Button)view.findViewById(R.id.btn_follower);
        btn_follower.setOnClickListener(this);
        btn_following=(Button)view.findViewById(R.id.btn_following);
        btn_following.setOnClickListener(this);
//    보류   tvStepDetector = (TextView) view.findViewById(R.id.tvStepDetector);
        //걸음수 서비스 불러오기
        MyStepService=new Intent(getActivity(), com.NSLB.TWIPEE.MyStepService.class);
        //step
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ps_write:
                Intent intent=new Intent(getActivity(), PostMain.class);
                startActivity(intent);
                break;
            case R.id.btn_setup:
                Intent intent1=new Intent(getActivity(), UserSetup.class);
                startActivity(intent1);
                break;
            case R.id.btn_travel:
                Intent intent2=new Intent(getActivity(), Travel.class);
                startActivity(intent2);
                break;
            case R.id.btn_follower:
                Intent intent3=new Intent(getActivity(), Follow.class);
                startActivity(intent3);
                break;
            case R.id.btn_following:
                break;
            default:
                break;
        }

    }
}
