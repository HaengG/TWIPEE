package com.NSLB.TWIPEE.ItemModel;

public class Model_SNS_Post_Like {
    private  String user_id;

    public Model_SNS_Post_Like(String user_id){
        this.user_id = user_id;
    }
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
