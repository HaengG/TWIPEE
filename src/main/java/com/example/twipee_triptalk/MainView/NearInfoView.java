package com.example.twipee_triptalk.MainView;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twipee_triptalk.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NearInfoView extends Fragment {


    public NearInfoView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_near_info_view, container, false);
    }

}
