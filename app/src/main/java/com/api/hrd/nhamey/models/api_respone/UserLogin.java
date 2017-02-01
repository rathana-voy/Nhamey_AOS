package com.api.hrd.nhamey.models.api_respone;

/**
 * Created by RATHANA on 29-Jan-17.
 */

public class UserLogin {

    private String  USER_PASSWORD;
    private String USER_EMAIL;

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }
}

