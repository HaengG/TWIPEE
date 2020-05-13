package com.NSLB.TWIPEE.TripTalkView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.NSLB.TWIPEE.FirebaseMethod.TripTalkFirebaseMethod;
import com.NSLB.TWIPEE.R;
import com.google.android.material.tabs.TabLayout;

public class TripTalkBoard extends AppCompatActivity {

    private static final String TAG = "TripTalkBoard";

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private TripTalkFirebaseMethod Firebase = TripTalkFirebaseMethod.getInstance();
    Board_SectionPageAdapter sectionPageAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        sectionPageAdapter = new Board_SectionPageAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionPageAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


//        // Create the adapter that will return a fragment for each section
//        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager(),
//                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
//            private final Fragment[] mFragments = new Fragment[] {
//                    new RecentPostsFragment(),
//                    new MyPostsFragment(),
//                    new MyTopPostsFragment(),
//            };
//            private final String[] mFragmentNames = new String[] {
//                    getString(R.string.heading_recent),
//                    getString(R.string.heading_my_posts),
//                    getString(R.string.heading_my_top_posts)
//            };
//            @Override
//            public Fragment getItem(int position) {
//                return mFragments[position];
//            }
//            @Override
//            public int getCount() {
//                return mFragments.length;
//            }
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return mFragmentNames[position];
//            }
//        };
//        // Set up the ViewPager with the sections adapter.
//        mViewPager = findViewById(R.id.container);
//        mViewPager.setAdapter(mPagerAdapter);
//        TabLayout tabLayout = findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mViewPager);
//
//        // Button launches NewPostActivity
//        findViewById(R.id.fabNewPost).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(TripTalkBoard.this, NewPostActivity.class));
//            }
//        });
    }


}
