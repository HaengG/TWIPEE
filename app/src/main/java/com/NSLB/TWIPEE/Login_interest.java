package com.NSLB.TWIPEE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Login_interest extends AppCompatActivity {

    private ArrayList<String> mKeywordStrArray;
    private String [] mUserInfos;
    private ToggleButton btn;
    private TextView selected;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_interast);

        selected = (TextView)findViewById(R.id.selected);

        mKeywordStrArray = new ArrayList<>();

    }

    public void onKeywordBtnClick(View view)
    {
        if (view.getId() == R.id.done) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {

            boolean on = ((ToggleButton)view).isChecked();

            if (on)
            {
                ToggleButton btn = (ToggleButton) findViewById(view.getId());
                mKeywordStrArray.remove(btn.getText().toString());
                String s = mKeywordStrArray.toString();
                selected.setText(s);
            }
            else {
                ToggleButton btn = (ToggleButton) findViewById(view.getId());
                mKeywordStrArray.add(btn.getText().toString());
                String d = mKeywordStrArray.toString();
                selected.setText(d);
            }
        }
    }
}
