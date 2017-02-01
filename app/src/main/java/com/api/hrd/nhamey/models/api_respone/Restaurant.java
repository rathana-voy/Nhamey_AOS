package com.api.hrd.nhamey.models.api_respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rathana on 18/1/17.
 */

public class Restaurant {


    @SerializedName("STATUS")
    public boolean STATUS;
    @SerializedName("CODE")
    public String CODE;
    @SerializedName("MESSAGE")
    public String MESSAGE;
    @SerializedName("DATA")
    public List<DATA> DATA;
    @SerializedName("PAGINATION")
    public PAGINATION PAGINATION;

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public List<Restaurant.DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<Restaurant.DATA> DATA) {
        this.DATA = DATA;
    }

    public Restaurant.PAGINATION getPAGINATION() {
        return PAGINATION;
    }

    public void setPAGINATION(Restaurant.PAGINATION PAGINATION) {
        this.PAGINATION = PAGINATION;
    }

    public static class Restpictures {
        @SerializedName("picture_id")
        public int picture_id;
        @SerializedName("path_name")
        public String path_name;
        @SerializedName("date_added")
        public String date_added;
        @SerializedName("date_modify")
        public String date_modify;

        public int getPicture_id() {
            return picture_id;
        }

        public void setPicture_id(int picture_id) {
            this.picture_id = picture_id;
        }

        public String getPath_name() {
            return path_name;
        }

        public void setPath_name(String path_name) {
            this.path_name = path_name;
        }

        public String getDate_modify() {
            return date_modify;
        }

        public void setDate_modify(String date_modify) {
            this.date_modify = date_modify;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }
    }

    public static class DATA {
        @SerializedName("rest_id")
        public int rest_id;
        @SerializedName("rest_name")
        public String rest_name;
        @SerializedName("contact")
        public String contact;
        @SerializedName("about")
        public String about;
        @SerializedName("open_close")
        public String open_close;
        @SerializedName("latitude")
        public String latitude;
        @SerializedName("longitude")
        public String longitude;
        @SerializedName("rest_name_kh")
        public String rest_name_kh;
        @SerializedName("total_favorite")
        public int total_favorite;
        @SerializedName("address")
        public String address;
        @SerializedName("user")
        public String user;
        @SerializedName("restpictures")
        public List<Restpictures> restpictures;
        @SerializedName("restype")
        public String restype;
        @SerializedName("categories")
        public String categories;
        @SerializedName("restypes")
        public String restypes;

        public int getRest_id() {
            return rest_id;
        }

        public void setRest_id(int rest_id) {
            this.rest_id = rest_id;
        }

        public String getRest_name() {
            return rest_name;
        }

        public void setRest_name(String rest_name) {
            this.rest_name = rest_name;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public String getOpen_close() {
            return open_close;
        }

        public void setOpen_close(String open_close) {
            this.open_close = open_close;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getRest_name_kh() {
            return rest_name_kh;
        }

        public void setRest_name_kh(String rest_name_kh) {
            this.rest_name_kh = rest_name_kh;
        }

        public int getTotal_favorite() {
            return total_favorite;
        }

        public void setTotal_favorite(int total_favorite) {
            this.total_favorite = total_favorite;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public List<Restpictures> getRestpictures() {
            return restpictures;
        }

        public void setRestpictures(List<Restpictures> restpictures) {
            this.restpictures = restpictures;
        }

        public String getRestype() {
            return restype;
        }

        public void setRestype(String restype) {
            this.restype = restype;
        }

        public String getCategories() {
            return categories;
        }

        public void setCategories(String categories) {
            this.categories = categories;
        }

        public String getRestypes() {
            return restypes;
        }

        public void setRestypes(String restypes) {
            this.restypes = restypes;
        }
    }

    public static class PAGINATION {
        @SerializedName("PAGE")
        public int PAGE;
        @SerializedName("LIMIT")
        public int LIMIT;
        @SerializedName("TOTAL_COUNT")
        public int TOTAL_COUNT;
        @SerializedName("TOTAL_PAGES")
        public int TOTAL_PAGES;

        public int getPAGE() {
            return PAGE;
        }

        public void setPAGE(int PAGE) {
            this.PAGE = PAGE;
        }

        public int getLIMIT() {
            return LIMIT;
        }

        public void setLIMIT(int LIMIT) {
            this.LIMIT = LIMIT;
        }

        public int getTOTAL_COUNT() {
            return TOTAL_COUNT;
        }

        public void setTOTAL_COUNT(int TOTAL_COUNT) {
            this.TOTAL_COUNT = TOTAL_COUNT;
        }

        public int getTOTAL_PAGES() {
            return TOTAL_PAGES;
        }

        public void setTOTAL_PAGES(int TOTAL_PAGES) {
            this.TOTAL_PAGES = TOTAL_PAGES;
        }
    }
}
