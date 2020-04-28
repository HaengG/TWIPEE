package com.NSLB.TWIPEE.ItemModel;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model_SNS_Post implements Serializable {
    private String PostType;
    private String CreatedDate;
    private String PublisherID;
    private String Body;
    private String MapImage;
    private String Step;
    private String Cost;
    private String Period;
    private String Traffic;
    private String MemberNumber;
    private int LikeCount = 0;
    private int CommentCount = 0;
    HashMap<String, String> Photo = new HashMap<>();
    HashMap<String, String> Category = new HashMap<>();

    public Model_SNS_Post() {
        //super();
    }

    public Model_SNS_Post(String postType, String createdDate, String publisherID, String body, String mapImage, String step, String cost, String period, String traffic, String memberNumber, int likeCount, int commentCount, HashMap<String, String> photo, HashMap<String, String> category) {
        PostType = postType;
        CreatedDate = createdDate;
        PublisherID = publisherID;
        Body = body;
        MapImage = mapImage;
        Step = step;
        Cost = cost;
        Period = period;
        Traffic = traffic;
        MemberNumber = memberNumber;
        LikeCount = likeCount;
        CommentCount = commentCount;
        Photo = photo;
        Category = category;
    }

    public String getPostType() {
        return PostType;
    }

    public void setPostType(String postType) {
        PostType = postType;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getPublisherID() {
        return PublisherID;
    }

    public void setPublisherID(String publisherID) {
        PublisherID = publisherID;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getMapImage() {
        return MapImage;
    }

    public void setMapImage(String mapImage) {
        MapImage = mapImage;
    }

    public String getStep() {
        return Step;
    }

    public void setStep(String step) {
        Step = step;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getTraffic() {
        return Traffic;
    }

    public void setTraffic(String traffic) {
        Traffic = traffic;
    }

    public String getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        MemberNumber = memberNumber;
    }

    public int getLikeCount() {
        return LikeCount;
    }

    public void setLikeCount(int likeCount) {
        LikeCount = likeCount;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int commentCount) {
        CommentCount = commentCount;
    }

    public HashMap<String, String> getPhoto() {
        return Photo;
    }

    public void setPhoto(HashMap<String, String> photo) {
        Photo = photo;
    }

    public HashMap<String, String> getCategory() {
        return Category;
    }

    public void setCategory(HashMap<String, String> category) {
        Category = category;
    }

    @Exclude
    public Map<String, Object> SNStoMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("PostType", PostType);
        result.put("CreatedDate", CreatedDate);
        result.put("PublisherID", PublisherID);
        result.put("Body", Body);
        result.put("MapImage", MapImage);
        result.put("Step", Step);
        result.put("Period", Period);
        result.put("MemberNumber", MemberNumber);
        result.put("Cost", Cost);
        result.put("Traffic", Traffic);
        result.put("LikeCount", LikeCount);
        result.put("CommentCount", CommentCount);
        result.put("Photo", Photo);
        result.put("Category", Category);
        return result;
    }
}
