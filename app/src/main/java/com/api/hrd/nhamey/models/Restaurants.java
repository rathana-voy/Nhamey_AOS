package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KeeporderGO on 1/15/2017.
 */

public class Restaurants {

    @SerializedName("rest_id")
    private int rest_id;
    @SerializedName("rest_name")
    private String rest_name;
    @SerializedName("contact")
    private String contact;
    @SerializedName("about")
    private String about;
    @SerializedName("open_close")
    private String open_close;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("rest_name_kh")
    private String rest_name_kh;
    @SerializedName("total_favorite")
    private int total_favorite;
    @SerializedName("address")
    private Address address;
    @SerializedName("user")
    private User user;
    @SerializedName("restpictures")
    private List<Restpictures> restpictures;
    @SerializedName("restype")
    private List<Restype> restype;
    @SerializedName("categories")
    private String categories;
    @SerializedName("restypes")
    private String restypes;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Restpictures> getRestpictures() {
        return restpictures;
    }

    public void setRestpictures(List<Restpictures> restpictures) {
        this.restpictures = restpictures;
    }

    public List<Restype> getRestype() {
        return restype;
    }

    public void setRestype(List<Restype> restype) {
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
