package com.example.twipee_triptalk.TripTalkView.Board;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.twipee_triptalk.FirebaseMethod.TripTalkFirebaseMethod;
import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.TripTalkView.Board.Board_Model.DataModelBoard;
import com.example.twipee_triptalk.TripTalkView.TripTalkBoard;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Board_BabyCar extends  Fragment {

    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mLayoutManager;
    public FloatingActionButton Writfab;
    public TripTalkFirebaseMethod Firebase = TripTalkFirebaseMethod.getInstance();

    private String Board = "BabyCar";

    public Board_BabyCar() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_board__baby_car, container, false);

        setComp(v);
        Adapter(Board);

        return  v;
    }

    public void setComp(View view)
    {
        View v = view;
        Writfab = v.findViewById(R.id.fabPost);
        mRecyclerView =v.findViewById(R.id.recycler1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        Writfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Board_NewWriteActivity.class);
                intent.putExtra("BoardType","BabyCar");
                startActivity(intent);
            }
        });
    }


    public void Adapter(String BoardType){

        mAdapter = new Board_Adapter(Firebase.BoardData, getActivity(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Object obj = v.getTag();
                    if (obj != null) {
                        int position = (int) obj;
                       ((Board_Adapter) mAdapter).getBoard(position);
                        Intent intent = new Intent(getActivity(), Board_DetailView.class);
                        intent.putExtra("board", ((Board_Adapter) mAdapter).getBoard(position));
                        startActivity(intent);
                    }

            }
        }, BoardType);
        mRecyclerView.setAdapter(mAdapter);

    }




}
