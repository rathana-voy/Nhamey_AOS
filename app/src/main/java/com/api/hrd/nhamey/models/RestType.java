package com.api.hrd.nhamey.models;

import java.sql.Date;

/**
 * Created by rathana on 17/1/17.
 */

public class RestType {

    private  int restype_id;
    private  String restype_name;
    private  String restype_name_kh;
    private  String restype_picture;
    private Date date_added;
    private Date date_modify;
    private  String description;

    public RestType(String restype_name, String restype_picture) {
        this.restype_name = restype_name;
        this.restype_picture = restype_picture;
    }
    public RestType(String restype_name, String restype_picture, String restype_name_kh) {
        this.restype_name = restype_name;
        this.restype_picture = restype_picture;
        this.restype_name_kh = restype_name_kh;
    }

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

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public Date getDate_modify() {
        return date_modify;
    }

    public void setDate_modify(Date date_modify) {
        this.date_modify = date_modify;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
