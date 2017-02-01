package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KeeporderGO on 1/21/2017.
 */

public class Favorite {

    @SerializedName("favrest_id")
    private int favrest_id;
    @SerializedName("fav_total")
    private int fav_total;
    @SerializedName("user")
    private User user;
    @SerializedName("rest")
    private Restaurants rest;
    @SerializedName("restpictures")
    private List<Restpictures> restpictures;

    public int getFavrest_id() {
        return favrest_id;
    }

    public void setFavrest_id(int favrest_id) {
        this.favrest_id = favrest_id;
    }

    public int getFav_total() {
        return fav_total;
    }

    public void setFav_total(int fav_total) {
        this.fav_total = fav_total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurants getRest() {
        return rest;
    }

    public void setRest(Restaurants rest) {
        this.rest = rest;
    }

    public List<Restpictures> getRestpictures() {
        return restpictures;
    }

    public void setRestpictures(List<Restpictures> restpictures) {
        this.restpictures = restpictures;
    }
}
