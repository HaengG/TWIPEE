package com.NSLB.TWIPEE.User;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.NSLB.TWIPEE.R;

public class Travel extends AppCompatActivity {

    private Button step;
    String serviceData;
    BroadcastReceiver receiver;
    Intent MyStepService;
    //미완성,,,
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        step=(Button)findViewById(R.id.step);
        MyStepService=new Intent(getApplicationContext(), com.NSLB.TWIPEE.MyStepService.class);

    }
}
