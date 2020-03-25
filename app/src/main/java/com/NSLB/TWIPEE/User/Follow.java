package com.NSLB.TWIPEE.User;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.NSLB.TWIPEE.R;
import com.google.android.material.tabs.TabLayout;

public class Follow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        //탭이름
        TabLayout tabs=findViewById(R.id.tabs_follow);
        tabs.addTab(tabs.newTab().setText(R.string.follow_tab_1));
        tabs.addTab(tabs.newTab().setText(R.string.follow_tab_2));
        tabs.setTabGravity(tabs.GRAVITY_FILL);
        final ViewPager viewPager=findViewById(R.id.follow_view);
    }
}
