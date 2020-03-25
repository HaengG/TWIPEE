package com.NSLB.TWIPEE.User;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.NSLB.TWIPEE.R;

public class FollowViewHolder extends RecyclerView.ViewHolder {
    public ImageView user_image;
    public TextView user_name;
    public ImageView follow;
    public FollowViewHolder(View itemView) {
        super(itemView);
        user_image=itemView.findViewById(R.id.user_image);
        user_name=itemView.findViewById(R.id.user_name);
        follow=itemView.findViewById(R.id.follow);
    }
    public void bindToFollow(FollowItem view,View.OnClickListener followClickListener){

    }
}
