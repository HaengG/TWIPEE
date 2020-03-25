package com.NSLB.TWIPEE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.material.tabs.TabLayout;

import com.NSLB.TWIPEE.Ui.main.SectionsPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import static com.NSLB.TWIPEE.User.BaseActivity.actList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button logout;
    private Intent intent;
    public String[] mUserInfos;
    public ArrayList<String> mKeywordStrArray;
    public FirebaseMethodUserSettings firebaseMethodUserSettings;
    SectionsPagerAdapter sectionsPagerAdapter = null;
    //
    public ToggleButton toggleButton;
    private Button Go_Beacon_Service;
    private TextView Step_Text;
    private final int PERMISSION_REQUEST_COARSE_LOCATION = 100;
    private int DataFromService;
    public MyReceiver myReceiver;
    private int Total_Step;

    private int[] tabIcons={
            R.drawable.ic_web_black_24dp,
            R.drawable.ic_chat_bubble_outline_black_24dp,
            R.drawable.ic_thumb_up_black_24dp,
            R.drawable.ic_account_box_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actList.add(this);

        initview();
        firebaseMethodUserSettings= new FirebaseMethodUserSettings();
        Toast.makeText(this,"성공",Toast.LENGTH_SHORT).show();

    }

    private void initview(){
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        for (int i = 0; i < sectionsPagerAdapter.getCount(); i++)
        {
            tabs.getTabAt(i).setIcon(tabIcons[i]);
        }

        Step_Text = (TextView)findViewById(R.id.step_text);
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(this);

        //Userview->step정보 보내기
        //text저장
        Intent intent=getIntent();
        String Total_Step=intent.getStringExtra("Total_Step");
        //번들객체 생성,text값 저장
        Bundle bundle=new Bundle();
        bundle.putString("Total_Step",Total_Step);

//뭔지 잘 모르겠음
//        if(getIntent().getExtras() != null){
//            intent = getIntent();
//            mUserInfos = new String[4];
//            mUserInfos = intent.getExtras().getStringArray("LoginInfo");
//            mKeywordStrArray = intent.getExtras().getStringArrayList("KeywordStrArray");
//
//            intent = null;
//
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toggleButton:
                if(toggleButton.isChecked()){
                    Start_StepService();
                    setToast("Service 시작");
                }
                else {
                    End_BeaconService();
                    setToast("Service 끝");
                }
        }
    }
    public void setTextView(String text){Step_Text.setText(text);}
    public void  setToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    public void Start_StepService(){
        myReceiver = new MyReceiver();
        Total_Step = 0;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyStepService.MY_ACTION);
        registerReceiver(myReceiver, intentFilter);
        setTextView("여행 중");
        Intent intent = new Intent(getApplication(), MyStepService.class);
        startService(intent);
    }

    public void End_BeaconService(){
        //확인용임 필요없으면 삭제가능
//        setTextView("Hello Step");
        //꼭필요한 부분
        //Beacon_Condition = "TurnOff";
        Intent intent = new Intent(this, MyStepService.class);
        stopService(intent);
        //필요없으면 삭제가능
        setTextView("여행 중지");
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            // TODO Auto-generated method stub
            DataFromService = arg1.getIntExtra("ServiceData",0 );
            //필요없으면 삭제가능
            //UI에 표시하는 부분 여기에 입력하면 됨 _ 현재 접속된 비콘 이름 출력
            Total_Step = DataFromService;
            getIntent().putExtra("Total_Step", Total_Step);
            startActivity(getIntent());
//            set_UI();
        }
    }
}
