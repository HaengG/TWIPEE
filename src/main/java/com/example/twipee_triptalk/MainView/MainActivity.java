package com.example.twipee_triptalk.MainView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.TripTalkView.Board.Board_Model.DataModelBoard;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    SectionPageAdapter sectionPageAdapter = null;
    public static List<DataModelBoard> mBoard = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        DataModelBoard datamodel = new DataModelBoard();
//        datamodel.setBoard_type("asdasd");
//        datamodel.setData_created("123123");
//        datamodel.setBoard_type("Camera");
//        datamodel.setLocation("구미");
//        datamodel.setUser_id("qwdq");
//        mBoard.add(datamodel);

        sectionPageAdapter = new SectionPageAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionPageAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



    }

}

