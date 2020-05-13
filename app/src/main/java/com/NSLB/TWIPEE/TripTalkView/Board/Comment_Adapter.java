package com.NSLB.TWIPEE.TripTalkView.Board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.NSLB.TWIPEE.R;
import com.NSLB.TWIPEE.TripTalkView.Board.Board_Model.DataModelComment;

import java.util.List;

public class Comment_Adapter extends RecyclerView.Adapter<Comment_Adapter.ViewHolder>{

    private List<DataModelComment> mdata;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView useridView;
        TextView contentsView;



        public ViewHolder(View itemView) {
            super(itemView);
           useridView = itemView.findViewById(R.id.commentAuthor);
           contentsView = itemView.findViewById(R.id.commentBody);

        }
    }

    public Comment_Adapter(List<DataModelComment> myData, Context context)
    {
        mdata= myData;
    }

    @Override
    public Comment_Adapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {


        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.board_comment, parent,false);
        Comment_Adapter.ViewHolder vh = new Comment_Adapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


       // holder.useridView.setText("시발");
       // holder.contentsView.setText("asdasdsa");
        DataModelComment models = mdata.get(position);

        holder.useridView.setText(models.getUser_id());

        String Title_text = models.getComment();

        if(Title_text != "null")
        {
            holder.contentsView.setText(Title_text);
        }
        else {
            holder.contentsView.setText("정보가 없음");
        }
        holder.useridView.setText("User_id");


    }


    @Override
    public int getItemCount() {
        return mdata == null ? 0 : mdata.size();
    }

    public DataModelComment getComment(int position)
    {
        return mdata != null ? mdata.get(position) : null;
    }


}