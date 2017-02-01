package com.api.hrd.nhamey.util.seccion;

import android.content.Context;
import android.content.SharedPreferences;

import com.api.hrd.nhamey.models.User;
import com.api.hrd.nhamey.models.api_respone.SocialUser;
import com.google.gson.annotations.SerializedName;


import java.sql.Date;
import java.util.List;

/**
 * Created by srsc12 on 0006-06-Jan-01-2017.
 */

public class Session {

    /* KEY */

    private static String USER_ID="USER_ID";
    private static String USER_FIRST_NAME="USER_FIRST_NAME";
    private static String USER_LAST_NAME="USER_LAST_NAME";
    private static String USER_NAME="USER_NAME";
    private static String USER_EMAIL="USER_EMAIL";
    private static String USER_PASSWORD="USER_PASSWORD";
    private static String USER_DOB="USER_DOB";
    private static String USER_IMAGE_PROFILE="USER_IMAGE_PROFILE";
    private static String USER_IMAGE_NAME="USER_IMAGE_NAME";
    private static String USER_GENDER="USER_GENDER";
    private static String USER_ROLES="USER_ROLES";
    private static String USER_PHONE_NUMBER="USER_PHONE_NUMBER";
    private static String USER_REGISTER_DATE="USER_REGISTER_DATE";
    private static String USER_SIGNUP_WITH="USER_SIGNUP_WITH";
    private static String USER_SOCIAL_ID="USER_SOCIAL_ID";
    private static String USER_IS_LOGIN="USER_IS_LOGIN";
    /* Preference */
    private static String sharedPrefName = "userSession";
    private static SharedPreferences sharedPref;
    private static SharedPreferences.Editor sharedPrefEditor;
    private static Context mContext;

    public static int userId;
    public static String userFirstName;
    public static String userLastName;
    public static String userName;
    public static String userGender;
    public static String userDob;
    public static String userEmail;
    public static String userPassword;
    public static String phoneNumber;
    public static String userImageProfile;
    public static String userImageName;
    public static String userRegisteredDate;
    public static String userSignupWith;
    public static String userSocialId;
    public static boolean isLogin;

    public static void setContext(Context ctx) {
        mContext = ctx;
    }

    // Save User info to SharedPreferenceFile
    public static void saveUserSession(Context context, User user) {

        mContext = context;

        sharedPref = mContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        sharedPrefEditor = sharedPref.edit();
        sharedPrefEditor.putInt(USER_ID, user.getUserId());
        sharedPrefEditor.putString(USER_FIRST_NAME, user.getUserFirstName());
        sharedPrefEditor.putString(USER_LAST_NAME, user.getUserLastName());
        sharedPrefEditor.putString(USER_NAME, user.getUserName());
        sharedPrefEditor.putString(USER_GENDER, user.getUserGender());
        sharedPrefEditor.putString(USER_EMAIL, user.getUserEmail());
        sharedPrefEditor.putString(USER_PASSWORD, user.getPassword());
        sharedPrefEditor.putString(USER_DOB, user.getUserDob());
        sharedPrefEditor.putString(USER_IMAGE_PROFILE, user.getUserImageProfile());
        sharedPrefEditor.putString(USER_IMAGE_NAME, user.getUserImageName());
        sharedPrefEditor.putString(USER_REGISTER_DATE, user.getUserRegisteredDate());
        sharedPrefEditor.putBoolean(USER_IS_LOGIN, user.isLogin());
        sharedPrefEditor.apply();
    }

    // Read User info to SharedPreferenceFile
    public static void readUserSession(Context context) {
        mContext = context;
        sharedPref = mContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        userId = sharedPref.getInt(USER_ID, 0);
        userFirstName = sharedPref.getString(USER_FIRST_NAME, null);
        userLastName = sharedPref.getString(USER_LAST_NAME, null);
        userName = sharedPref.getString(USER_NAME, null);
        userEmail = sharedPref.getString(USER_EMAIL, null);
        userPassword = sharedPref.getString(USER_PASSWORD, null);
        userDob = sharedPref.getString(USER_DOB,null);
        userRegisteredDate = sharedPref.getString(USER_REGISTER_DATE, null);
        userGender = sharedPref.getString(USER_GENDER, null);
        userImageProfile = sharedPref.getString(USER_IMAGE_PROFILE, null);
        isLogin = sharedPref.getBoolean(USER_IS_LOGIN, false);
        userImageName=sharedPref.getString(USER_IMAGE_NAME,null);
        userSignupWith=sharedPref.getString(USER_SIGNUP_WITH,null);
        userSocialId=sharedPref.getString(USER_SOCIAL_ID,null);
    }

    // Clear Session or clean all data from SharedPreferenceFile
    public static void clearSession() {
        mContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE).edit().clear().apply();
    }

}
