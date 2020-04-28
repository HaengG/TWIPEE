package com.NSLB.TWIPEE.ItemModel;

import java.util.List;

public class DataModelUserSetting {
    private String profile_photo;
    private String user_name;
    private String mail;
    private String user_id;
    private List<String> category;
    private List<DataModelUserSetting> followers;
    private List<DataModelUserSetting> following;

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }


    public List<DataModelUserSetting> getFollowers() {
        return followers;
    }
    public void setFollowers(List<DataModelUserSetting> followers) {
        this.followers = followers;
    }

    public List<DataModelUserSetting> getFollowing() {
        return following;
    }

    public void setFollowing(List<DataModelUserSetting> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "DataModelUserSetting{" +
                "profile_photo='" + profile_photo + '\'' +
                ", user_name='" + user_name + '\'' +
                ", mail='" + mail + '\'' +
                ", user_id='" + user_id + '\'' +
                ", category=" + category +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }
}
