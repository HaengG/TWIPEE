package com.example.twipee_triptalk.Chat;

import java.io.Serializable;

public class ChatData implements Serializable {

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    private String Nickname;
    private String Msg;




}
