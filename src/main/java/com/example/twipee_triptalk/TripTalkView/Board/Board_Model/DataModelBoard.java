package com.example.twipee_triptalk.TripTalkView.Board.Board_Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataModelBoard implements Serializable {

    public String Title;
    public String Location;
    public String BoardType;
    public String CreatedDate;
    public String Body;
    public String Photo1;
    public String Photo2;
    public String PublisherID;
    public int LikeCount;
    public int CommentCount;
    public Map<String, Boolean> stars = new HashMap<>();

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Title", Title);
        result.put("Location", Location);
        result.put("BoardType", BoardType);
        result.put("CreatedDate", CreatedDate);
        result.put("Body", Body);
        result.put("Photo1", Photo1);
        result.put("Photo2", Photo2);
        result.put("PublisherID", PublisherID);
        result.put("LikeCount", LikeCount);
        result.put("CommentCount", CommentCount);
        result.put("stars", stars);

        return result;
    }


}
