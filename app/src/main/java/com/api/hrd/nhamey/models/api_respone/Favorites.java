package com.api.hrd.nhamey.models.api_respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KeeporderGO on 1/30/2017.
 */

public class Favorites {

    @SerializedName("MESSAGE")
    private String MESSAGE;
    @SerializedName("CODE")
    private String CODE;
    @SerializedName("STATUS")
    private boolean STATUS;
    @SerializedName("DATA")
    private List<DATA> DATA;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public boolean getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public List<DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<DATA> DATA) {
        this.DATA = DATA;
    }

    public static class USER_ROLES {
        @SerializedName("ROLE_ID")
        private int ROLE_ID;
        @SerializedName("ROLE_NAME")
        private String ROLE_NAME;
        @SerializedName("USER_ID")
        private int USER_ID;

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

    public static class USER {
        @SerializedName("USER_ID")
        private int USER_ID;
        @SerializedName("USER_FIRST_NAME")
        private String USER_FIRST_NAME;
        @SerializedName("USER_LAST_NAME")
        private String USER_LAST_NAME;
        @SerializedName("USER_NAME")
        private String USER_NAME;
        @SerializedName("USER_EMAIL")
        private String USER_EMAIL;
        @SerializedName("USER_PASSWORD")
        private String USER_PASSWORD;
        @SerializedName("USER_DOB")
        private String USER_DOB;
        @SerializedName("USER_IMAGE_PROFILE")
        private String USER_IMAGE_PROFILE;
        @SerializedName("USER_IMAGE_NAME")
        private String USER_IMAGE_NAME;
        @SerializedName("USER_GENDER")
        private String USER_GENDER;
        @SerializedName("USER_ROLES")
        private List<USER_ROLES> USER_ROLES;
        @SerializedName("USER_PHONE_NUMBER")
        private String USER_PHONE_NUMBER;
        @SerializedName("USER_REGISTER_DATE")
        private String USER_REGISTER_DATE;
        @SerializedName("USER_SIGNUP_WITH")
        private String USER_SIGNUP_WITH;
        @SerializedName("USER_SOCIAL_ID")
        private String USER_SOCIAL_ID;

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

        public String getUSER_PASSWORD() {
            return USER_PASSWORD;
        }

        public void setUSER_PASSWORD(String USER_PASSWORD) {
            this.USER_PASSWORD = USER_PASSWORD;
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

        public List<USER_ROLES> getUSER_ROLES() {
            return USER_ROLES;
        }

        public void setUSER_ROLES(List<USER_ROLES> USER_ROLES) {
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
    }

    public static class ADDRESS {
        @SerializedName("ADDRESS_ID")
        private int ADDRESS_ID;
        @SerializedName("ADDRESS_STREET")
        private String ADDRESS_STREET;
        @SerializedName("ADDRESS_DISTRICT")
        private String ADDRESS_DISTRICT;
        @SerializedName("ADDRESS_COMMUNCE")
        private String ADDRESS_COMMUNCE;
        @SerializedName("ADDRESS_PROVINCE")
        private String ADDRESS_PROVINCE;
        @SerializedName("ADDRESS_VILLAGE")
        private String ADDRESS_VILLAGE;

        public int getADDRESS_ID() {
            return ADDRESS_ID;
        }

        public void setADDRESS_ID(int ADDRESS_ID) {
            this.ADDRESS_ID = ADDRESS_ID;
        }

        public String getADDRESS_STREET() {
            return ADDRESS_STREET;
        }

        public void setADDRESS_STREET(String ADDRESS_STREET) {
            this.ADDRESS_STREET = ADDRESS_STREET;
        }

        public String getADDRESS_DISTRICT() {
            return ADDRESS_DISTRICT;
        }

        public void setADDRESS_DISTRICT(String ADDRESS_DISTRICT) {
            this.ADDRESS_DISTRICT = ADDRESS_DISTRICT;
        }

        public String getADDRESS_COMMUNCE() {
            return ADDRESS_COMMUNCE;
        }

        public void setADDRESS_COMMUNCE(String ADDRESS_COMMUNCE) {
            this.ADDRESS_COMMUNCE = ADDRESS_COMMUNCE;
        }

        public String getADDRESS_PROVINCE() {
            return ADDRESS_PROVINCE;
        }

        public void setADDRESS_PROVINCE(String ADDRESS_PROVINCE) {
            this.ADDRESS_PROVINCE = ADDRESS_PROVINCE;
        }

        public String getADDRESS_VILLAGE() {
            return ADDRESS_VILLAGE;
        }

        public void setADDRESS_VILLAGE(String ADDRESS_VILLAGE) {
            this.ADDRESS_VILLAGE = ADDRESS_VILLAGE;
        }
    }

    public static class RESTYPE {
        @SerializedName("RESTYPE_ID")
        private int RESTYPE_ID;
        @SerializedName("RESTYPE_NAME")
        private String RESTYPE_NAME;
        @SerializedName("RESTYPE_KHMER_NAME")
        private String RESTYPE_KHMER_NAME;
        @SerializedName("RESTYPE_IAMGE")
        private String RESTYPE_IAMGE;
        @SerializedName("RESTYPE_DATE_CREATE")
        private String RESTYPE_DATE_CREATE;
        @SerializedName("RESTYPE_DATE_MODIFY")
        private String RESTYPE_DATE_MODIFY;
        @SerializedName("RESTYPE_DESC")
        private String RESTYPE_DESC;

        public int getRESTYPE_ID() {
            return RESTYPE_ID;
        }

        public void setRESTYPE_ID(int RESTYPE_ID) {
            this.RESTYPE_ID = RESTYPE_ID;
        }

        public String getRESTYPE_NAME() {
            return RESTYPE_NAME;
        }

        public void setRESTYPE_NAME(String RESTYPE_NAME) {
            this.RESTYPE_NAME = RESTYPE_NAME;
        }

        public String getRESTYPE_KHMER_NAME() {
            return RESTYPE_KHMER_NAME;
        }

        public void setRESTYPE_KHMER_NAME(String RESTYPE_KHMER_NAME) {
            this.RESTYPE_KHMER_NAME = RESTYPE_KHMER_NAME;
        }

        public String getRESTYPE_IAMGE() {
            return RESTYPE_IAMGE;
        }

        public void setRESTYPE_IAMGE(String RESTYPE_IAMGE) {
            this.RESTYPE_IAMGE = RESTYPE_IAMGE;
        }

        public String getRESTYPE_DATE_CREATE() {
            return RESTYPE_DATE_CREATE;
        }

        public void setRESTYPE_DATE_CREATE(String RESTYPE_DATE_CREATE) {
            this.RESTYPE_DATE_CREATE = RESTYPE_DATE_CREATE;
        }

        public String getRESTYPE_DATE_MODIFY() {
            return RESTYPE_DATE_MODIFY;
        }

        public void setRESTYPE_DATE_MODIFY(String RESTYPE_DATE_MODIFY) {
            this.RESTYPE_DATE_MODIFY = RESTYPE_DATE_MODIFY;
        }

        public String getRESTYPE_DESC() {
            return RESTYPE_DESC;
        }

        public void setRESTYPE_DESC(String RESTYPE_DESC) {
            this.RESTYPE_DESC = RESTYPE_DESC;
        }
    }

    public static class RESTAURANT_IMAGES {
        @SerializedName("IMAGE_ID")
        private int IMAGE_ID;
        @SerializedName("RESTAURANT_ID")
        private int RESTAURANT_ID;
        @SerializedName("IMAGE_PATH")
        private String IMAGE_PATH;
        @SerializedName("IMAGE_DATE_CREATE")
        private String IMAGE_DATE_CREATE;
        @SerializedName("IMAGE_DATE_MODIFY")
        private String IMAGE_DATE_MODIFY;

        public int getIMAGE_ID() {
            return IMAGE_ID;
        }

        public void setIMAGE_ID(int IMAGE_ID) {
            this.IMAGE_ID = IMAGE_ID;
        }

        public int getRESTAURANT_ID() {
            return RESTAURANT_ID;
        }

        public void setRESTAURANT_ID(int RESTAURANT_ID) {
            this.RESTAURANT_ID = RESTAURANT_ID;
        }

        public String getIMAGE_PATH() {
            return IMAGE_PATH;
        }

        public void setIMAGE_PATH(String IMAGE_PATH) {
            this.IMAGE_PATH = IMAGE_PATH;
        }

        public String getIMAGE_DATE_CREATE() {
            return IMAGE_DATE_CREATE;
        }

        public void setIMAGE_DATE_CREATE(String IMAGE_DATE_CREATE) {
            this.IMAGE_DATE_CREATE = IMAGE_DATE_CREATE;
        }

        public String getIMAGE_DATE_MODIFY() {
            return IMAGE_DATE_MODIFY;
        }

        public void setIMAGE_DATE_MODIFY(String IMAGE_DATE_MODIFY) {
            this.IMAGE_DATE_MODIFY = IMAGE_DATE_MODIFY;
        }
    }

    public static class RESTAURANT {
        @SerializedName("RESTAURANT_ID")
        private int RESTAURANT_ID;
        @SerializedName("RESTAURANT_NAME")
        private String RESTAURANT_NAME;
        @SerializedName("RESTAURANT_CONTACT")
        private String RESTAURANT_CONTACT;
        @SerializedName("RESTAURANT_ABOUT")
        private String RESTAURANT_ABOUT;
        @SerializedName("RESTAURANT_OPEN_CLOSE")
        private String RESTAURANT_OPEN_CLOSE;
        @SerializedName("RESTAURANT_LATITUDE")
        private String RESTAURANT_LATITUDE;
        @SerializedName("RESTAURANT_LONGITUDE")
        private String RESTAURANT_LONGITUDE;
        @SerializedName("RESTAURANT_KHMER_NAME")
        private String RESTAURANT_KHMER_NAME;
        @SerializedName("RESTAURANT_ADDRESS")
        private String RESTAURANT_ADDRESS;
        @SerializedName("ADDRESS")
        private ADDRESS ADDRESS;
        @SerializedName("RESTYPE")
        private List<RESTYPE> RESTYPE;
        @SerializedName("RESTAURANT_IMAGES")
        private List<RESTAURANT_IMAGES> RESTAURANT_IMAGES;

        public int getRESTAURANT_ID() {
            return RESTAURANT_ID;
        }

        public void setRESTAURANT_ID(int RESTAURANT_ID) {
            this.RESTAURANT_ID = RESTAURANT_ID;
        }

        public String getRESTAURANT_NAME() {
            return RESTAURANT_NAME;
        }

        public void setRESTAURANT_NAME(String RESTAURANT_NAME) {
            this.RESTAURANT_NAME = RESTAURANT_NAME;
        }

        public String getRESTAURANT_CONTACT() {
            return RESTAURANT_CONTACT;
        }

        public void setRESTAURANT_CONTACT(String RESTAURANT_CONTACT) {
            this.RESTAURANT_CONTACT = RESTAURANT_CONTACT;
        }

        public String getRESTAURANT_ABOUT() {
            return RESTAURANT_ABOUT;
        }

        public void setRESTAURANT_ABOUT(String RESTAURANT_ABOUT) {
            this.RESTAURANT_ABOUT = RESTAURANT_ABOUT;
        }

        public String getRESTAURANT_OPEN_CLOSE() {
            return RESTAURANT_OPEN_CLOSE;
        }

        public void setRESTAURANT_OPEN_CLOSE(String RESTAURANT_OPEN_CLOSE) {
            this.RESTAURANT_OPEN_CLOSE = RESTAURANT_OPEN_CLOSE;
        }

        public String getRESTAURANT_LATITUDE() {
            return RESTAURANT_LATITUDE;
        }

        public void setRESTAURANT_LATITUDE(String RESTAURANT_LATITUDE) {
            this.RESTAURANT_LATITUDE = RESTAURANT_LATITUDE;
        }

        public String getRESTAURANT_LONGITUDE() {
            return RESTAURANT_LONGITUDE;
        }

        public void setRESTAURANT_LONGITUDE(String RESTAURANT_LONGITUDE) {
            this.RESTAURANT_LONGITUDE = RESTAURANT_LONGITUDE;
        }

        public String getRESTAURANT_KHMER_NAME() {
            return RESTAURANT_KHMER_NAME;
        }

        public void setRESTAURANT_KHMER_NAME(String RESTAURANT_KHMER_NAME) {
            this.RESTAURANT_KHMER_NAME = RESTAURANT_KHMER_NAME;
        }

        public String getRESTAURANT_ADDRESS() {
            return RESTAURANT_ADDRESS;
        }

        public void setRESTAURANT_ADDRESS(String RESTAURANT_ADDRESS) {
            this.RESTAURANT_ADDRESS = RESTAURANT_ADDRESS;
        }

        public ADDRESS getADDRESS() {
            return ADDRESS;
        }

        public void setADDRESS(ADDRESS ADDRESS) {
            this.ADDRESS = ADDRESS;
        }

        public List<RESTYPE> getRESTYPE() {
            return RESTYPE;
        }

        public void setRESTYPE(List<RESTYPE> RESTYPE) {
            this.RESTYPE = RESTYPE;
        }

        public List<RESTAURANT_IMAGES> getRESTAURANT_IMAGES() {
            return RESTAURANT_IMAGES;
        }

        public void setRESTAURANT_IMAGES(List<RESTAURANT_IMAGES> RESTAURANT_IMAGES) {
            this.RESTAURANT_IMAGES = RESTAURANT_IMAGES;
        }
    }

    public static class DATA {
        @SerializedName("FAVORITE_RESTAURANT_ID")
        private int FAVORITE_RESTAURANT_ID;
        @SerializedName("FAVORITE_USER_ID")
        private int FAVORITE_USER_ID;
        @SerializedName("FAVORITE_COUNT")
        private int FAVORITE_COUNT;
        @SerializedName("USER")
        private USER USER;
        @SerializedName("RESTAURANT")
        private RESTAURANT RESTAURANT;

        public int getFAVORITE_RESTAURANT_ID() {
            return FAVORITE_RESTAURANT_ID;
        }

        public void setFAVORITE_RESTAURANT_ID(int FAVORITE_RESTAURANT_ID) {
            this.FAVORITE_RESTAURANT_ID = FAVORITE_RESTAURANT_ID;
        }

        public int getFAVORITE_USER_ID() {
            return FAVORITE_USER_ID;
        }

        public void setFAVORITE_USER_ID(int FAVORITE_USER_ID) {
            this.FAVORITE_USER_ID = FAVORITE_USER_ID;
        }

        public int getFAVORITE_COUNT() {
            return FAVORITE_COUNT;
        }

        public void setFAVORITE_COUNT(int FAVORITE_COUNT) {
            this.FAVORITE_COUNT = FAVORITE_COUNT;
        }

        public USER getUSER() {
            return USER;
        }

        public void setUSER(USER USER) {
            this.USER = USER;
        }

        public RESTAURANT getRESTAURANT() {
            return RESTAURANT;
        }

        public void setRESTAURANT(RESTAURANT RESTAURANT) {
            this.RESTAURANT = RESTAURANT;
        }
    }
}
