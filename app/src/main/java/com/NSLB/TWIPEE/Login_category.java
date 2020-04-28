package com.NSLB.TWIPEE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

import com.NSLB.TWIPEE.ItemModel.DataModelUserSetting;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class Login_category extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> category;
    private TextView selected;
    private String show_category;
    private Button done;
    public DataModelUserSetting dataModelUserSetting;
    public FirebaseMethodUserSettings firebaseMethodUserSettings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_interast);
        firebaseMethodUserSettings= new FirebaseMethodUserSettings();
        dataModelUserSetting=new DataModelUserSetting();
        selected = (TextView)findViewById(R.id.selected);
        done = (Button)findViewById(R.id.done);
        done.setOnClickListener(this);

        category = new ArrayList<>();

    }

    public void onKeywordBtnClick(View view)
    {
            boolean on = ((ToggleButton)view).isChecked();

            if (on)
            {
                ToggleButton btn = (ToggleButton) findViewById(view.getId());
                category.remove(btn.getText().toString());
                show_category = category.toString();
                selected.setText(show_category);
                dataModelUserSetting.setCategory(category);
            }
            else {
                ToggleButton btn = (ToggleButton) findViewById(view.getId());
                category.add(btn.getText().toString());
                show_category = category.toString();
                selected.setText(show_category);
                dataModelUserSetting.setCategory(category);
            }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.done) {
            //databaseReference.child("category").push().setValue(show_category);
            firebaseMethodUserSettings.categorysave(show_category);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

