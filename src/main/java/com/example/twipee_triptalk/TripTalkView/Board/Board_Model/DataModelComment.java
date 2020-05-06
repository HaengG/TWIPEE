package com.example.twipee_triptalk.TripTalkView.Board.Board_Model;

import java.util.ArrayList;
import java.util.List;

public class DataModelComment {



    public String comment;
    public String user_id;
    public String data_created;
    public List<DataModelLike> like_value = new ArrayList<>();

    public DataModelComment()
    {

    }

    public DataModelComment(String Userid, String Comment)
    {
        this.user_id = Userid;
        this.comment = Comment;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getData_created() {
        return data_created;
    }

    public void setData_created(String data_created) {
        this.data_created = data_created;
    }

    public List<DataModelLike> getLike_value() {
        return like_value;
    }

    public void setLike_value(List<DataModelLike> like_value) {
        this.like_value = like_value;
    }



}
