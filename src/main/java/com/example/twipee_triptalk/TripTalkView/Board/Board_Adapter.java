package com.example.twipee_triptalk.TripTalkView.Board;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.twipee_triptalk.FirebaseMethod.TripTalkFirebaseMethod;
import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.TripTalkView.Board.Board_Model.DataModelBoard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Board_Adapter extends RecyclerView.Adapter<Board_Adapter.ViewHolder>{

    private ArrayList<DataModelBoard> mdata ;
    private static View.OnClickListener onClickListener;
    private Context mContext;
    private TripTalkFirebaseMethod Firebase = TripTalkFirebaseMethod.getInstance();
    private ArrayList<DataModelBoard> BoardData= new ArrayList<DataModelBoard>();
    private ArrayList<DataModelBoard> BoardData2= new ArrayList<DataModelBoard>();
    private String BoardTypeAdapter;



    public  static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleView;
        private TextView contentsView;
        private TextView userView;

        public ImageView ImageView_title;
        public View rootView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.posts_title);
            contentsView = itemView.findViewById(R.id.posts_contents);
            userView = itemView.findViewById(R.id.posts_userid);
            ImageView_title =itemView.findViewById(R.id.ImageView_title);
            ImageView_title.setImageResource(R.drawable.siru);
            rootView = itemView;


            itemView.setClickable(true); //누를 수있다없다
            itemView.setEnabled(true); // 활성화 상태
            itemView.setOnClickListener(onClickListener);

        }
    }


    public Board_Adapter(ArrayList<DataModelBoard> myData, Context context, View.OnClickListener onClick, String Board)
    {

        BoardTypeAdapter = Board;
        mdata = myData;
        mContext = context;

        onClickListener = onClick;

        BoardData.clear();
        for(int index =0; index<mdata.size(); index++)
        {
           DataModelBoard Devide = mdata.get(index);
           if(Devide.BoardType.equals(BoardTypeAdapter))
           {
               BoardData.add(Devide);
           }
        }
    }

    @Override
    public Board_Adapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.board_item, parent,false);
        Board_Adapter.ViewHolder vh = new Board_Adapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DataModelBoard BoardModel;
        BoardModel = BoardData.get(position);


            holder.titleView.setText(BoardModel.Title);
            holder.userView.setText(BoardModel.PublisherID);
            holder.contentsView.setText(BoardModel.Body);

            holder.rootView.setTag(position);

    }


    @Override
    public int getItemCount() {
        return BoardData.size();
    }


    public DataModelBoard getBoard(int position)
    {
        return mdata != null ? mdata.get(position) : null;
    }


}