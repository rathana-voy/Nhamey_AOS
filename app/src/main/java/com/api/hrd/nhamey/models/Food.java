package com.api.hrd.nhamey.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by RATHANA on 04-Jan-17.
 */

public class Food {

    @SerializedName("food_id")
    public int food_id;
    @SerializedName("food_name")
    public String food_name;
    @SerializedName("price")
    public float price;
    @SerializedName("description")
    public String description;
    @SerializedName("date_added")
    public String date_added;
    @SerializedName("date_modify")
    public String date_modify;
    @SerializedName("restaurant_id")
    public int restaurant_id;
    @SerializedName("category")
    public Category category;
    @SerializedName("foodImage")
    public String foodImage;

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }
}
