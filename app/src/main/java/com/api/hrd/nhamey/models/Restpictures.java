package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

public class Restpictures {
    @SerializedName("picture_id")
    private int picture_id;
    @SerializedName("path_name")
    private String path_name;
    @SerializedName("date_added")
    private String date_added;
    @SerializedName("date_modify")
    private String date_modify;

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
}
