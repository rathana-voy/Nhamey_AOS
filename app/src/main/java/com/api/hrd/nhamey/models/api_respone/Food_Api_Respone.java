package com.api.hrd.nhamey.models.api_respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Thyreach on 1/23/2017.
 */


public class Food_Api_Respone {


    @SerializedName("MESSAGE")
    public String MESSAGE;
    @SerializedName("CODE")
    public String CODE;
    @SerializedName("STATUS")
    public boolean STATUS;
    @SerializedName("DATA")
    public List<DATA> DATA;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public List<Food_Api_Respone.DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<Food_Api_Respone.DATA> DATA) {
        this.DATA = DATA;
    }

    public static class DATA {
        @SerializedName("food_id")
        public int food_id;
        @SerializedName("food_name")
        public String food_name;
        @SerializedName("price")
        public Float price;
        @SerializedName("description")
        public String description;
        @SerializedName("date_added")
        public String date_added;
        @SerializedName("date_modify")
        public String date_modify;
        @SerializedName("restaurant_id")
        public int restaurant_id;
        @SerializedName("category")
        public String category;
        @SerializedName("foodImage")
        public String foodImage;

        public String getFoodImage() {
            return foodImage;
        }

        public void setFoodImage(String foodImage) {
            this.foodImage = foodImage;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getRestaurant_id() {
            return restaurant_id;
        }

        public void setRestaurant_id(int restaurant_id) {
            this.restaurant_id = restaurant_id;
        }

        public String getDate_modify() {
            return date_modify;
        }

        public void setDate_modify(String date_modify) {
            this.date_modify = date_modify;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public String getFood_name() {
            return food_name;
        }

        public void setFood_name(String food_name) {
            this.food_name = food_name;
        }

        public int getFood_id() {
            return food_id;
        }

        public void setFood_id(int food_id) {
            this.food_id = food_id;
        }
    }
}
