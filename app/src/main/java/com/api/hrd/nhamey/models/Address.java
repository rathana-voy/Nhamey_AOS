package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("address_id")
    private int address_id;
    @SerializedName("street")
    private String street;
    @SerializedName("district")
    private String district;
    @SerializedName("communce")
    private String communce;
    @SerializedName("province")
    private String province;
    @SerializedName("village")
    private String village;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommunce() {
        return communce;
    }

    public void setCommunce(String communce) {
        this.communce = communce;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }
}
