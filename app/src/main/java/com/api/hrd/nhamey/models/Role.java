package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

public class Role {
    @SerializedName("id")
    private int id;
    @SerializedName("key")
    private String key;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
