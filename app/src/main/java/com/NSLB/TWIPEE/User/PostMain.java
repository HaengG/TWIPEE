package com.NSLB.TWIPEE.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.NSLB.TWIPEE.R;

public class PostMain extends AppCompatActivity implements View.OnClickListener {

    private Button btn_ps_review,btn_ps_plan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_main);
        btn_ps_review=(Button)findViewById(R.id.btn_ps_review);
        btn_ps_review.setOnClickListener(this);
        btn_ps_plan=(Button)findViewById(R.id.btn_ps_plan);
        btn_ps_plan.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ps_review://후기작성
                Intent intent=new Intent(getApplicationContext(),PostReview.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_ps_plan://계획작성
                Intent intent1=new Intent(getApplicationContext(),PostPlan.class);
                startActivity(intent1);
                finish();
                break;
            default:
                break;
        }
    }
}
