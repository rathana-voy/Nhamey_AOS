package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

public class Restype {
    @SerializedName("restype_id")
    private int restype_id;
    @SerializedName("restype_name")
    private String restype_name;
    @SerializedName("restype_name_kh")
    private String restype_name_kh;
    @SerializedName("restype_picture")
    private String restype_picture;
    @SerializedName("date_added")
    private String date_added;
    @SerializedName("date_modify")
    private String date_modify;
    @SerializedName("parentid_restypeid")
    private int parentid_restypeid;
    @SerializedName("description")
    private String description;
    @SerializedName("restpictures")
    private String restpictures;
    @SerializedName("restype_files")
    private String restype_files;
    @SerializedName("menus")
    private String menus;
    @SerializedName("restaurants")
    private String restaurants;

    public int getRestype_id() {
        return restype_id;
    }

    public void setRestype_id(int restype_id) {
        this.restype_id = restype_id;
    }

    public String getRestype_name() {
        return restype_name;
    }

    public void setRestype_name(String restype_name) {
        this.restype_name = restype_name;
    }

    public String getRestype_name_kh() {
        return restype_name_kh;
    }

    public void setRestype_name_kh(String restype_name_kh) {
        this.restype_name_kh = restype_name_kh;
    }

    public String getRestype_picture() {
        return restype_picture;
    }

    public void setRestype_picture(String restype_picture) {
        this.restype_picture = restype_picture;
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

    public int getParentid_restypeid() {
        return parentid_restypeid;
    }

    public void setParentid_restypeid(int parentid_restypeid) {
        this.parentid_restypeid = parentid_restypeid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRestpictures() {
        return restpictures;
    }

    public void setRestpictures(String restpictures) {
        this.restpictures = restpictures;
    }

    public String getRestype_files() {
        return restype_files;
    }

    public void setRestype_files(String restype_files) {
        this.restype_files = restype_files;
    }

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public String getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(String restaurants) {
        this.restaurants = restaurants;
    }
}
