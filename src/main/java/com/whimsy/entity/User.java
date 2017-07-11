package com.whimsy.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String userNickname;

    private String userFace;

    private String userEmail;

    private String userCount;

    private String userPassword;

    private String userRealname;

    private String userSex;

    private Short userAge;

    private Long userQq;

    private String userUniversity;

    private String userJob;

    private Long userPhone;

    private String userIntroduce;

    private String userLabel;

    private Date userTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace == null ? null : userFace.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserCount() {
        return userCount;
    }

    public void setUserCount(String userCount) {
        this.userCount = userCount == null ? null : userCount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname == null ? null : userRealname.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Short getUserAge() {
        return userAge;
    }

    public void setUserAge(Short userAge) {
        this.userAge = userAge;
    }

    public Long getUserQq() {
        return userQq;
    }

    public void setUserQq(Long userQq) {
        this.userQq = userQq;
    }

    public String getUserUniversity() {
        return userUniversity;
    }

    public void setUserUniversity(String userUniversity) {
        this.userUniversity = userUniversity == null ? null : userUniversity.trim();
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob == null ? null : userJob.trim();
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce == null ? null : userIntroduce.trim();
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel == null ? null : userLabel.trim();
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }
}