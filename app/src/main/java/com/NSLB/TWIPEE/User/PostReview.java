package com.NSLB.TWIPEE.User;

import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.NSLB.TWIPEE.R;

import java.util.ArrayList;

public class PostReview extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button btn__review_cost, travel_date, travel_date2,btn_upload;
    private ImageButton btn_course_add, btn_addTrevelPhoto;
    private DatePickerDialog.OnDateSetListener callbackMethod, callstartMethod;
    ArrayAdapter<String> arrAdap_trevelType, arrAdap_itinerary, arrAdap_travelMember, arrAdap_transport;
    private ViewPager viewPager;
    private GalleryPagerAdapter pagerAdapter;
    ArrayList<Integer> listImage;
    Spinner spin_travelType, spin_itinerary, spin_travelMember, spin_transport;
    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_CAMERA = 2;
    final int PICTURE_REQUEST_CODE = 100;

    private Uri mImageCaptureUri;

    String[] travelTypeList = {"자유여행" , "패키지" , "여행타입"};
    String[] itineraryList = {"당일치기" , "1박2일" , "2박3일" , "3박4일" , "4박5일" , "5박이상" , "장기여행" , "여행일정"};
    String[] travelMemberList = {"1인" , "2인" , "3인" , "4인" , "5~10인" , "단체" , "여행인원"};
    String[] transportList = {"자동차" , "대중교통" , "자전거" , "버스대절" , "항공" , "선박" , "이동수단"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_review);
        initView();
        InitializeListener();
        InitializeListener_2();
        //데이터 수신//
        Intent intent=getIntent();
        //int형//
//        int total_fee=intent.getExtras().getInt("total_fee");
//        btn__review_cost.setText(String.valueOf(total_fee));

    }

    private void initView() {
        btn__review_cost = (Button) findViewById(R.id.btn__review_cost);
        btn__review_cost.setOnClickListener(this);
        //btn_cost-비용받아오기
        btn_course_add = (ImageButton) findViewById(R.id.btn_course_add);
        btn_course_add.setOnClickListener(this);
        btn_addTrevelPhoto = (ImageButton) findViewById(R.id.btn_addTrevelPhoto);
        btn_addTrevelPhoto.setOnClickListener(this);
        viewPager = findViewById(R.id.vp_reviewPhoto);
        travel_date = (Button) findViewById(R.id.travel_date);
        travel_date2 = (Button) findViewById(R.id.travel_date2);
        btn_upload=(Button)findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(this);
        //갤러리 뷰페이저
        viewPager = findViewById(R.id.vp_reviewPhoto);
        pagerAdapter = new GalleryPagerAdapter(this);//오,,
        viewPager.setAdapter(pagerAdapter);


        spin_travelType = findViewById(R.id.spin_travelType);
        spin_itinerary = findViewById(R.id.spin_itinerary);
        spin_travelMember = findViewById(R.id.spin_travelMember);
        spin_transport = findViewById(R.id.spin_transport);
        arrAdap_trevelType = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item , travelTypeList) {
            @Override
            public View getView(int position , View convertView , ViewGroup parent) {
                View v = super.getView(position , convertView , parent);

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1;
            }
        };
        arrAdap_itinerary = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item , itineraryList) {
            @Override
            public View getView(int position , View convertView , ViewGroup parent) {
                View v = super.getView(position , convertView , parent);

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1;
            }
        };
        arrAdap_travelMember = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item , travelMemberList) {
            @Override
            public View getView(int position , View convertView , ViewGroup parent) {
                View v = super.getView(position , convertView , parent);

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1;
            }
        };
        arrAdap_transport = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item , transportList) {
            @Override
            public View getView(int position , View convertView , ViewGroup parent) {
                View v = super.getView(position , convertView , parent);

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1;
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
    //날짜 기간
    public void InitializeListener_2() {
        callstartMethod = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view , int year , int monthOfYear , int dayOfMonth) {
                travel_date2.setText(year + "년" + monthOfYear + "월" + dayOfMonth + "일");

            }
        };
    }
    //날짜 기간
    public void InitializeListener() {
        callbackMethod = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view , int year , int monthOfYear , int dayOfMonth) {
                travel_date.setText(year + "년" + monthOfYear + "월" + dayOfMonth + "일");

            }
        };
    }
    public void OnClickHandler(View view) {
        DatePickerDialog dialog = new DatePickerDialog(this , callbackMethod , 2020 , 3 , 6);
        DatePickerDialog dialog1 = new DatePickerDialog(this , callstartMethod , 2020 , 3 , 7);
        dialog.show();
        dialog1.show();
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn__review_cost:
                intent = new Intent(getApplication() , Cost.class);
                startActivity(intent);
                break;
            case R.id.btn_course_add:
                intent = new Intent(getApplication() , Course.class);
                startActivity(intent);
                break;
            case R.id.btn_addTrevelPhoto:
                //갤러리
                intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE , true);//중복
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(Intent.createChooser(intent , "다중 선택은 '포토'를 선택하세요.") , PICTURE_REQUEST_CODE);
                break;
            case R.id.btn_upload:
                break;
            default:
                break;
        }
    }

    //사진
    @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data) {
        super.onActivityResult(requestCode , resultCode , data);
        if (requestCode == PICTURE_REQUEST_CODE) {
            //Make sure the request was successful
            if (resultCode == RESULT_OK) {
                if (data.getClipData() == null) {
                    Toast.makeText(this , "다중 선택이 불가한 기기입니다." , Toast.LENGTH_SHORT).show();
                } else {
                    ClipData clipData = data.getClipData();
                    if (clipData.getItemCount() > 10) {
                        Toast.makeText(this , "사진은 10개까지 선택가능 합니다." , Toast.LENGTH_SHORT).show();
                    }
                    // 멀티 선택에서 하나만 선택했을 경우
                    else if (clipData.getItemCount() == 1) {
                        pagerAdapter.addItem(clipData.getItemAt(0).getUri());
                    } else if (clipData.getItemCount() > 1 && clipData.getItemCount() < 10) {
                        for (int i = 0; i < clipData.getItemCount(); i++) {
                            pagerAdapter.addItem(clipData.getItemAt(i).getUri());
                        }

                    }
                    pagerAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent , View view , int position , long id) {

    }
}