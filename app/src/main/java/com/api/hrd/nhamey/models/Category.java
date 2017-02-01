package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by RATHANA on 04-Jan-17.
 */

public class Category {
    @SerializedName("category_id")
    public int category_id;
    @SerializedName("category_name")
    public String category_name;
    @SerializedName("category_date_added")
    public String category_date_added;
    @SerializedName("category_date_modify")
    public String category_date_modify;
    @SerializedName("category_name_kh")
    public String category_name_kh;
    @SerializedName("description")
    public String description;
    @SerializedName("subcategory")
    public String subcategory;

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

    public String getCategory_date_added() {
        return category_date_added;
    }

    public void setCategory_date_added(String category_date_added) {
        this.category_date_added = category_date_added;
    }

    public String getCategory_date_modify() {
        return category_date_modify;
    }

    public void setCategory_date_modify(String category_date_modify) {
        this.category_date_modify = category_date_modify;
    }

    public String getCategory_name_kh() {
        return category_name_kh;
    }

    public void setCategory_name_kh(String category_name_kh) {
        this.category_name_kh = category_name_kh;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
