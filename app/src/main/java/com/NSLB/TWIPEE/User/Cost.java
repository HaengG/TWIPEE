package com.NSLB.TWIPEE.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.NSLB.TWIPEE.R;

public class Cost extends AppCompatActivity implements View.OnClickListener {
    private EditText traffic,lodging,food,entrance,other;
    private Button btn_checking,btn_upload;
    private TextView total_fee;
    public Integer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        initView();
    }
    private void initView() {
        traffic=(EditText)findViewById(R.id.edit_traffic_expenses);
        lodging=(EditText)findViewById(R.id.edit_lodging_charge);
        food=(EditText)findViewById(R.id.edit_food_expenses);
        entrance=(EditText) findViewById(R.id.edit_entrance_fee);
        other=(EditText)findViewById(R.id.edit_other_fee);
        btn_checking=(Button)findViewById(R.id.btn_checking);
        btn_checking.setOnClickListener(this);
        total_fee=(TextView)findViewById(R.id.total_fee);
        btn_upload=(Button)findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int input1=Integer.parseInt(traffic.getText().toString());
        int input2=Integer.parseInt(lodging.getText().toString());
        int input3=Integer.parseInt(food.getText().toString());
        int input4=Integer.parseInt(entrance.getText().toString());
        int input5=Integer.parseInt(other.getText().toString());


        switch (v.getId()){
            case R.id.btn_checking:
                //확인버튼 누른 후 계산
                result=input1+input2+input3+input4+input5;
                total_fee.setText(""+result);
                break;
            case R.id.btn_upload:
                Intent intent=new Intent(getApplication(),PostReview.class);
                intent.putExtra("total_fee",result);
                startActivity(intent);
                finish();

            default:
                break;
        }

    }
}
