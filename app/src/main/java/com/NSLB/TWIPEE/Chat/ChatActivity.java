package com.NSLB.TWIPEE.Chat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.NSLB.TWIPEE.R;

import java.util.ArrayList;
import java.util.List;

//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public  RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ChatData> chatlist;
    private String nick="nick2";

    private EditText EditText_chat;
    private Button Button_send;
   // private  DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Button_send = findViewById(R.id.Button_send);
        EditText_chat = findViewById(R.id.EditText_chat);

        Button_send.setOnClickListener(new View.OnClickListener() { //send 버튼 클릭
            @Override
            public void onClick(View v) {
            String msg =  EditText_chat.getText().toString(); // msl

                if(msg != null){
                    ChatData chat = new ChatData();
                    chat.setNickname(nick);
                    chat.setMsg(msg);

                    

   //                 myRef.push().setValue(chat);
                }
            }
        });


        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        chatlist = new ArrayList<>();
        mAdapter = new ChatAdapter(chatlist, ChatActivity. this, nick);

        mRecyclerView.setAdapter(mAdapter);



         //Write a message to the database

       // FirebaseDatabase database = FirebaseDatabase.getInstance();
       // myRef = database.getReference();

        ChatData chat = new ChatData();
        chat.setNickname(nick);
        chat.setMsg("hi");
       // myRef.setValue(chat);


//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                ChatData chat = dataSnapshot.getValue(ChatData.class);
//                ((ChatAdapter) mAdapter).addChat(chat); // 왜 그런지 다시
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//


    }

    public void writeTest()
    {
    }


}
