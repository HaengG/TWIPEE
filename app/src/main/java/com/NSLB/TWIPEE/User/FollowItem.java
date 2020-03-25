package com.NSLB.TWIPEE.User;

import java.util.HashMap;
import java.util.Map;

public class FollowItem {
    public String uid;
    public String name;
    public int follwCount=0;
    public Map<String,Boolean> follow=new HashMap<>();

    public FollowItem(String uid,String name){
        this.uid=uid;
        this.name=name;
    }
    public Map<String ,Object>toMap(){
        HashMap<String,Object>result=new HashMap<>();
        result.put("uid",uid);
        result.put("name",name);
        result.put("follow",follow);
        return result;
    }
}
