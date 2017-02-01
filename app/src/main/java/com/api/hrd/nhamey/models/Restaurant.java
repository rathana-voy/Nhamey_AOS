package com.api.hrd.nhamey.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KeeporderGO on 1/8/2017.
 */

public class Restaurant implements Parcelable {

    private int rest_id;
    private String image;
    private String rest_name;
    private String rest_type;
    private String rest_addr;
    private String rest_dist;

    public Restaurant(int rest_id, String image, String rest_name, String rest_type, String rest_addr, String rest_dist) {
        this.rest_id = rest_id;
        this.image = image;
        this.rest_name = rest_name;
        this.rest_type = rest_type;
        this.rest_addr = rest_addr;
        this.rest_dist = rest_dist;
    }
    public Restaurant(String image, String rest_name, String rest_type, String rest_addr, String rest_dist) {
        this.image = image;
        this.rest_name = rest_name;
        this.rest_type = rest_type;
        this.rest_addr = rest_addr;
        this.rest_dist = rest_dist;
    }

    public int getRest_id() {
        return rest_id;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
    }

    public Restaurant(int rest_id) {
        this.rest_id = rest_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public String getRest_type() {
        return rest_type;
    }

    public void setRest_type(String rest_type) {
        this.rest_type = rest_type;
    }

    public String getRest_addr() {
        return rest_addr;
    }

    public void setRest_addr(String rest_addr) {
        this.rest_addr = rest_addr;
    }

    public String getRest_dist() {
        return rest_dist;
    }

    public void setRest_dist(String rest_dist) {
        this.rest_dist = rest_dist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.rest_id);
        dest.writeString(this.image);
        dest.writeString(this.rest_name);
        dest.writeString(this.rest_type);
        dest.writeString(this.rest_addr);
        dest.writeString(this.rest_dist);
    }

    protected Restaurant(Parcel in) {
        this.rest_id = in.readInt();
        this.image = in.readString();
        this.rest_name = in.readString();
        this.rest_type = in.readString();
        this.rest_addr = in.readString();
        this.rest_dist = in.readString();
    }

    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel source) {
            return new Restaurant(source);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}
