package com.NSLB.TWIPEE.TripTalkView.Board;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.NSLB.TWIPEE.FirebaseMethod.TripTalkFirebaseMethod;
import com.NSLB.TWIPEE.R;
import com.NSLB.TWIPEE.TripTalkView.Board.Board_Model.DataModelBoard;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board_NewWriteActivity extends AppCompatActivity {
    private FloatingActionButton Writfab;
    private EditText Title;
    private EditText Body;
    private TripTalkFirebaseMethod FirebaseMethod = TripTalkFirebaseMethod.getInstance();
    private String BoardType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board__new_write);
        Title = findViewById(R.id.fieldTitle);
        Body = findViewById(R.id.fieldBody);
        Writfab = findViewById(R.id.fabSubmitPost);
        Intent GetType = getIntent();
        BoardType = GetType.getStringExtra("BoardType");
        Set();

    }

    public void Set()
    {
        Writfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataModelBoard BoardData = new DataModelBoard();
                String title = Title.getText().toString();
                String body = Body.getText().toString();
                BoardData.BoardType = BoardType;
                BoardData.CommentCount = 0;

                Date from = new Date();
                SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String Now = transFormat.format(from);

                BoardData.CreatedDate = Now;
                BoardData.LikeCount = 0;
                BoardData.Location = "구미";
                BoardData.Photo1 = "null";
                BoardData.Photo2 = "null";
                BoardData.PublisherID = "김시완";
                BoardData.Body = body;
                BoardData.Title = title;
                if(title.equals("") || body.equals("")) {
                    ShowFailedDialog();
                }
                else
                {
                    if(FirebaseMethod.DataPush(BoardData) == true) {
                        ShowSuccessDialog();
                    }

                }

            }
        });
    }

    public void ShowSuccessDialog()
    {

        AlertDialog.Builder Success = new AlertDialog.Builder(this);
        Success.setTitle("TripTalk 게시판 등록 알림");
        Success.setMessage("TripTalk 게시판이 등록되었습니다.").setCancelable(false);
        Success.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"TripTalk게시판이 등록되었습니다.",Toast.LENGTH_SHORT).show();
                finish();
            }
        }).show();

    }

    public void ShowFailedDialog()
    {
        AlertDialog.Builder Success = new AlertDialog.Builder(this);
        Success.setTitle("TripTalk 게시판 등록 알림");
        Success.setMessage("게시판의 타이틀과 내용을 입력해야만 등록이 가능합니다. 다시 시도해 주세요.").setCancelable(false)
        ;
        Success.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"타이틀과 내용을 채우고 다시 시도해 주세요.",Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
