package com.api.hrd.nhamey.webservice.services;

import com.api.hrd.nhamey.models.api_respone.Food_Api_Respone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface FoodService {

    @GET("/api/food/find-food-by-restaurant-id")
    public Call<Food_Api_Respone> getFood(@Query("rest_id") int restaurant_id);
}
