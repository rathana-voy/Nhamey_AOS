package com.api.hrd.nhamey.models.api_respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by srec05 on 1/25/2017.
 */

public class SocialUser {

    @SerializedName("MESSAGE")
    public String MESSAGE;
    @SerializedName("CODE")
    public int CODE;
    @SerializedName("DATA")
    public DATA DATA;
    @SerializedName("STATUS_SIGNUP")
    public boolean STATUS_SIGNUP;
    @SerializedName("STATUS_LOGIN")
    public boolean STATUS_LOGIN;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public int getCODE() {
        return CODE;
    }

    public void setCODE(int CODE) {
        this.CODE = CODE;
    }

    public SocialUser.DATA getDATA() {
        return DATA;
    }

    public void setDATA(SocialUser.DATA DATA) {
        this.DATA = DATA;
    }

    public boolean isSTATUS_SIGNUP() {
        return STATUS_SIGNUP;
    }

    public void setSTATUS_SIGNUP(boolean STATUS_SIGNUP) {
        this.STATUS_SIGNUP = STATUS_SIGNUP;
    }

    public boolean isSTATUS_LOGIN() {
        return STATUS_LOGIN;
    }

    public void setSTATUS_LOGIN(boolean STATUS_LOGIN) {
        this.STATUS_LOGIN = STATUS_LOGIN;
    }

    public static class USER_ROLES {
        @SerializedName("ROLE_ID")
        public int ROLE_ID;
        @SerializedName("ROLE_NAME")
        public String ROLE_NAME;
        @SerializedName("USER_ID")
        public int USER_ID;

        public int getROLE_ID() {
            return ROLE_ID;
        }

        public void setROLE_ID(int ROLE_ID) {
            this.ROLE_ID = ROLE_ID;
        }

        public String getROLE_NAME() {
            return ROLE_NAME;
        }

        public void setROLE_NAME(String ROLE_NAME) {
            this.ROLE_NAME = ROLE_NAME;
        }

        public int getUSER_ID() {
            return USER_ID;
        }

        public void setUSER_ID(int USER_ID) {
            this.USER_ID = USER_ID;
        }
    }

    public static class DATA {
        @SerializedName("USER_ID")
        public int USER_ID;
        @SerializedName("USER_FIRST_NAME")
        public String USER_FIRST_NAME;
        @SerializedName("USER_LAST_NAME")
        public String USER_LAST_NAME;
        @SerializedName("USER_NAME")
        public String USER_NAME;
        @SerializedName("USER_EMAIL")
        public String USER_EMAIL;
        @SerializedName("USER_PASSWORD")
        public String USER_PASSWORD;
        @SerializedName("USER_DOB")
        public String USER_DOB;
        @SerializedName("USER_IMAGE_PROFILE")
        public String USER_IMAGE_PROFILE;
        @SerializedName("USER_IMAGE_NAME")
        public String USER_IMAGE_NAME;
        @SerializedName("USER_GENDER")
        public String USER_GENDER;
        @SerializedName("USER_ROLES")
        public List<USER_ROLES> USER_ROLES;
        @SerializedName("USER_PHONE_NUMBER")
        public String USER_PHONE_NUMBER;
        @SerializedName("USER_REGISTER_DATE")
        public String USER_REGISTER_DATE;
        @SerializedName("USER_SIGNUP_WITH")
        public String USER_SIGNUP_WITH;
        @SerializedName("USER_SOCIAL_ID")
        public String USER_SOCIAL_ID;
        @SerializedName("USER_IS_LOGIN")
        public boolean USER_IS_LOGIN;
        public int getUSER_ID() {
            return USER_ID;
        }

        public void setUSER_ID(int USER_ID) {
            this.USER_ID = USER_ID;
        }

        public String getUSER_FIRST_NAME() {
            return USER_FIRST_NAME;
        }

        public void setUSER_FIRST_NAME(String USER_FIRST_NAME) {
            this.USER_FIRST_NAME = USER_FIRST_NAME;
        }

        public String getUSER_LAST_NAME() {
            return USER_LAST_NAME;
        }

        public void setUSER_LAST_NAME(String USER_LAST_NAME) {
            this.USER_LAST_NAME = USER_LAST_NAME;
        }

        public String getUSER_NAME() {
            return USER_NAME;
        }

        public void setUSER_NAME(String USER_NAME) {
            this.USER_NAME = USER_NAME;
        }

        public String getUSER_EMAIL() {
            return USER_EMAIL;
        }

        public void setUSER_EMAIL(String USER_EMAIL) {
            this.USER_EMAIL = USER_EMAIL;
        }

        public String getUSER_PASSWROD() {
            return USER_PASSWORD;
        }

        public void setUSER_PASSWROD(String USER_PASSWROD) {
            this.USER_PASSWORD = USER_PASSWROD;
        }

        public String getUSER_DOB() {
            return USER_DOB;
        }

        public void setUSER_DOB(String USER_DOB) {
            this.USER_DOB = USER_DOB;
        }

        public String getUSER_IMAGE_PROFILE() {
            return USER_IMAGE_PROFILE;
        }

        public void setUSER_IMAGE_PROFILE(String USER_IMAGE_PROFILE) {
            this.USER_IMAGE_PROFILE = USER_IMAGE_PROFILE;
        }

        public String getUSER_IMAGE_NAME() {
            return USER_IMAGE_NAME;
        }

        public void setUSER_IMAGE_NAME(String USER_IMAGE_NAME) {
            this.USER_IMAGE_NAME = USER_IMAGE_NAME;
        }

        public String getUSER_GENDER() {
            return USER_GENDER;
        }

        public void setUSER_GENDER(String USER_GENDER) {
            this.USER_GENDER = USER_GENDER;
        }

        public List<SocialUser.USER_ROLES> getUSER_ROLES() {
            return USER_ROLES;
        }

        public void setUSER_ROLES(List<SocialUser.USER_ROLES> USER_ROLES) {
            this.USER_ROLES = USER_ROLES;
        }

        public String getUSER_PHONE_NUMBER() {
            return USER_PHONE_NUMBER;
        }

        public void setUSER_PHONE_NUMBER(String USER_PHONE_NUMBER) {
            this.USER_PHONE_NUMBER = USER_PHONE_NUMBER;
        }

        public String getUSER_REGISTER_DATE() {
            return USER_REGISTER_DATE;
        }

        public void setUSER_REGISTER_DATE(String USER_REGISTER_DATE) {
            this.USER_REGISTER_DATE = USER_REGISTER_DATE;
        }

        public String getUSER_SIGNUP_WITH() {
            return USER_SIGNUP_WITH;
        }

        public void setUSER_SIGNUP_WITH(String USER_SIGNUP_WITH) {
            this.USER_SIGNUP_WITH = USER_SIGNUP_WITH;
        }

        public String getUSER_SOCIAL_ID() {
            return USER_SOCIAL_ID;
        }

        public void setUSER_SOCIAL_ID(String USER_SOCIAL_ID) {
            this.USER_SOCIAL_ID = USER_SOCIAL_ID;
        }

        public boolean isUSER_IS_LOGIN() {
            return USER_IS_LOGIN;
        }

        public void setUSER_IS_LOGIN(boolean USER_IS_LOGIN) {
            this.USER_IS_LOGIN = USER_IS_LOGIN;
        }

        public String getUSER_PASSWORD() {
            return USER_PASSWORD;
        }

        public void setUSER_PASSWORD(String USER_PASSWORD) {
            this.USER_PASSWORD = USER_PASSWORD;
        }
    }
}
