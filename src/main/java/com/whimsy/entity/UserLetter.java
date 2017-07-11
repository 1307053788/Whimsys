package com.whimsy.entity;

import java.util.Date;

public class UserLetter {
    private Integer letterId;

    private Integer myId;

    private Integer friendId;

    private String letterContent;

    private Date letterTime;

    public Integer getLetterId() {
        return letterId;
    }

    public void setLetterId(Integer letterId) {
        this.letterId = letterId;
    }

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getLetterContent() {
        return letterContent;
    }

    public void setLetterContent(String letterContent) {
        this.letterContent = letterContent == null ? null : letterContent.trim();
    }

    public Date getLetterTime() {
        return letterTime;
    }

    public void setLetterTime(Date letterTime) {
        this.letterTime = letterTime;
    }
}