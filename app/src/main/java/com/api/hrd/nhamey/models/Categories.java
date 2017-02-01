package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

public class Categories {
    @SerializedName("category_id")
    private int category_id;
    @SerializedName("category_name")
    private String category_name;
    @SerializedName("other")
    private String other;
    @SerializedName("date_added")
    private String date_added;
    @SerializedName("date_modify")
    private String date_modify;
    @SerializedName("picture")
    private String picture;
    @SerializedName("category_name_kh")
    private String category_name_kh;
    @SerializedName("url")
    private String url;
    @SerializedName("rest")
    private String rest;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getDate_modify() {
        return date_modify;
    }

    public void setDate_modify(String date_modify) {
        this.date_modify = date_modify;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCategory_name_kh() {
        return category_name_kh;
    }

    public void setCategory_name_kh(String category_name_kh) {
        this.category_name_kh = category_name_kh;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }
}
