package com.NSLB.TWIPEE.User;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.NSLB.TWIPEE.FirebaseMethodUserSettings;
import com.NSLB.TWIPEE.Login_main;
import com.NSLB.TWIPEE.R;
import static com.NSLB.TWIPEE.User.BaseActivity.actList;

public class UserSetup extends AppCompatActivity {
    public Button btnLogout;
    public FirebaseMethodUserSettings firebaseMethodUserSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setup);

        firebaseMethodUserSettings= new FirebaseMethodUserSettings();

        btnLogout = (Button)findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();
            }
        });
    }

    public void showDialog(){
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);

        alertdialog.setMessage("로그아웃하시겠습니까 ?");
        alertdialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                firebaseMethodUserSettings.signOut();
                for (int i=0; i<actList.size();i++)
                    actList.get(i).finish();
                Intent intent = new Intent(getApplicationContext(), Login_main.class);
                startActivity(intent);
                finish();
            }
        });

        alertdialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "취소버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alert = alertdialog.create();
        alert.show();

    }
}
