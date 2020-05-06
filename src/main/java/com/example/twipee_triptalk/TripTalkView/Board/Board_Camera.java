package com.example.twipee_triptalk.TripTalkView.Board;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twipee_triptalk.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Board_Camera extends Board_BabyCar {

    private String BoardType = "Camera";

    public Board_Camera() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board__baby_car, container, false);
        setComp(view);

        Adapter(BoardType);
        return view;
    }

    @Override
    public void Adapter(String BoardType ) {
        super.Adapter(BoardType);

    }

    @Override
    public void setComp(View view) {
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
                intent.putExtra("BoardType","Camera");
                startActivity(intent);
            }
        });

    }

}
