package com.NSLB.TWIPEE.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.NSLB.TWIPEE.R;

public class PostPlan extends AppCompatActivity implements View.OnClickListener {
    private Button btn_cost_plan;
    private ImageButton btn_course_add_plan;
    Spinner spin_travelType, spin_itinerary, spin_travelMember, spin_transport;
    ArrayAdapter<String> arrAdap_trevelType, arrAdap_itinerary, arrAdap_travelMember, arrAdap_transport;
    String[] travelTypeList = {"자유여행","패키지","여행타입"};
    String[] itineraryList = {"당일치기","1박2일","2박3일","3박4일","4박5일","5박이상","장기여행","여행일정"};
    String[] travelMemberList = {"1인","2인","3인","4인","5~10인","단체","여행인원"};
    String[] transportList = {"자동차","대중교통","자전거","버스대절","항공","선박","이동수단"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_plan);
        btn_cost_plan=(Button)findViewById(R.id.btn_cost_plan);
        btn_cost_plan.setOnClickListener(this);

        initView();

    }
    private void initView(){
        btn_cost_plan=findViewById(R.id.btn_cost_plan);
        btn_course_add_plan=findViewById(R.id.btn_course_add_plan);

        //여행 스타일
        spin_travelType = findViewById(R.id.spin_travelType);
        spin_itinerary = findViewById(R.id.spin_itinerary);
        spin_travelMember = findViewById(R.id.spin_travelMember);
        spin_transport = findViewById(R.id.spin_transport);

        //스피너
        arrAdap_trevelType = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,travelTypeList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View v = super.getView(position,convertView,parent);

                return v;
            }

            @Override
            public int getCount(){
                return super.getCount()-1;
            }
        };
        arrAdap_itinerary = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itineraryList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View v = super.getView(position,convertView,parent);

                return v;
            }

            @Override
            public int getCount(){
                return super.getCount()-1;
            }
        };
        arrAdap_travelMember = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,travelMemberList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View v = super.getView(position,convertView,parent);

                return v;
            }

            @Override
            public int getCount(){
                return super.getCount()-1;
            }
        };
        arrAdap_transport = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,transportList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View v = super.getView(position,convertView,parent);

                return v;
            }

            @Override
            public int getCount(){
                return super.getCount()-1;
            }
        };
        //스피너 어뎁터 연결
        spin_travelType.setAdapter(arrAdap_trevelType);
        spin_travelType.setSelection(arrAdap_trevelType.getCount());
        spin_itinerary.setAdapter(arrAdap_itinerary);
        spin_itinerary.setSelection(arrAdap_itinerary.getCount());
        spin_travelMember.setAdapter(arrAdap_travelMember);
        spin_travelMember.setSelection(arrAdap_travelMember.getCount());
        spin_transport.setAdapter(arrAdap_transport);
        spin_transport.setSelection(arrAdap_transport.getCount());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cost_plan:
                Intent intent=new Intent(getApplication(),Cost.class);
                startActivity(intent);
                break;
            case R.id.btn_course_add_plan:
                break;
            default:
                break;
        }
    }
}
