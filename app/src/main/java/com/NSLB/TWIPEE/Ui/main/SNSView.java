package com.NSLB.TWIPEE.Ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.NSLB.TWIPEE.ItemModel.DataModelComment;
import com.NSLB.TWIPEE.ItemModel.DataModelLike;
import com.NSLB.TWIPEE.ItemModel.DataModelSNS;
import com.NSLB.TWIPEE.ItemModel.DataModelUserSetting;
import com.NSLB.TWIPEE.R;

import java.util.ArrayList;

public class SNSView extends Fragment implements View.OnClickListener{


    private ArrayList<DataModelSNS> list = new ArrayList<>();
    private ArrayList<DataModelSNS> list_real = new ArrayList<>();
    private ArrayList<String> category1 = new ArrayList<>();
    private ArrayList<String> category2 = new ArrayList<>();
    private ArrayList<String> category3 = new ArrayList<>();
    private ArrayList<String> category4 = new ArrayList<>();
    private ArrayList<String> category5 = new ArrayList<>();
    private ArrayList<DataModelLike> likes = new ArrayList<>();
    private ArrayList<DataModelComment> comments = new ArrayList<>();


    private DataModelSNS dataModelSNS1;
    private DataModelSNS dataModelSNS2;
    private DataModelSNS dataModelSNS3;
    private DataModelSNS dataModelSNS4;
    private DataModelSNS dataModelSNS5;

    //widget
    private EditText et_feedSearchBox;
    private Button btn_feedSearch;
    private TextView tv_favorite;
    private RecyclerView recyclerView;

    private SNSRecyclerAdapter adapter;
    private Intent intent;
    private int resultsCount = 0;
    private ArrayList<DataModelUserSetting> DMUserSetting;

    public SNSView() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_snsview, container, false);
        btn_feedSearch = (Button) view.findViewById(R.id.btn_feedSearch);
        tv_favorite = (TextView) view.findViewById(R.id.tv_favorite);
        btn_feedSearch.setOnClickListener(this);
        tv_favorite.setOnClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.SNSListView);

        initRecyclerViewRefresh("B");




        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //마지막 체크
                if (!recyclerView.canScrollVertically(-1)) {
                    Toast myToast = Toast.makeText(getContext(),"제일 위", Toast.LENGTH_SHORT);
                    myToast.show();
                } else if (!recyclerView.canScrollVertically(1)) {
                    Toast myToast = Toast.makeText(getContext(),"제일 아래", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });





        return view;
    }

    private void initRecyclerViewRefresh(String category) {
        testcategory();
        dataModelSNS1 = new DataModelSNS("type1","data_created1", "user_id1", 11, "content1", "image_path1", "photo_id1", "step1", "cost1", "period1", "traffic1", category1, likes, comments);
        dataModelSNS2 = new DataModelSNS("type2","data_created2", "user_id2", 12, "content2", "image_path2", "photo_id2", "step2", "cost2", "period2", "traffic2", category2, likes, comments);
        dataModelSNS3 = new DataModelSNS("type3","data_created3", "user_id3", 13, "content3", "image_path3", "photo_id3", "step3", "cost3", "period3", "traffic3", category3, likes, comments);
        dataModelSNS4 = new DataModelSNS("type4","data_created4", "user_id4", 14, "content4", "image_path4", "photo_id4", "step4", "cost4", "period4", "traffic4", category4, likes, comments);
        dataModelSNS5 = new DataModelSNS("type5","data_created5", "user_id5", 15, "content5", "image_path5", "photo_id5", "step5", "cost5", "period5", "traffic5", category5, likes, comments);


        list.add(dataModelSNS1);
        list.add(dataModelSNS2);
        list.add(dataModelSNS3);
        list.add(dataModelSNS4);
        list.add(dataModelSNS5);

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(i).getCategory().size(); j++){
                if(category == list.get(i).getCategory().get(j)) {
                    list_real.add(list.get(i));
                }
            }
        }

        recyclerView.setHasFixedSize(true);
        adapter = new SNSRecyclerAdapter(getActivity(), list_real);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_feedSearch:
                //intent = new Intent(getActivity(), SNSSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_favorite:
                //intent = new Intent(getActivity(), FavoriteActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }



    private void testcategory(){
        category1.add("A");
        category1.add("C");
        category1.add("E");
        category2.add("A");
        category2.add("D");
        category3.add("B");
        category3.add("C");
        category3.add("D");
        category4.add("B");
        category4.add("E");
        category5.add("C");
    }

}