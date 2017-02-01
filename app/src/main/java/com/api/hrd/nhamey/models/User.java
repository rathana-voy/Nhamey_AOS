package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class User {
    public int userId;
    public String userFirstName;
    public String userLastName;
    public String userName;
    public String userGender;
    public String userDob;
    public String userEmail;
    public String password;
    public String phoneNumber;
    public String userImageProfile;
    public String userImageName;
    public String userRegisteredDate;
    public String userSignupWith;
    public String userSocialId;
    public boolean isLogin;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserImageProfile() {
        return userImageProfile;
    }

    public void setUserImageProfile(String userImageProfile) {
        this.userImageProfile = userImageProfile;
    }

    public String  getUserRegisteredDate() {
        return userRegisteredDate;
    }

    public void setUserRegisteredDate(String  userRegisteredDate) {
        this.userRegisteredDate = userRegisteredDate;
    }

    public String getUserSignupWith() {
        return userSignupWith;
    }

    public void setUserSignupWith(String userSignupWith) {
        this.userSignupWith = userSignupWith;
    }

    public String getUserSocialId() {
        return userSocialId;
    }

    public void setUserSocialId(String userSocialId) {
        this.userSocialId = userSocialId;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getUserImageName() {
        return userImageName;
    }

    public void setUserImageName(String userImageName) {
        this.userImageName = userImageName;
    }
}
