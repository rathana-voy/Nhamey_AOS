package com.api.hrd.nhamey.webservice.services;

import com.api.hrd.nhamey.models.api_respone.Restaurant;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by RATHANA on 04-Jan-17.
 */

public interface RestaurantService {

    @GET("api/restaurant/get-restaurant-with-category?page=1&limit=15")
    Call<JsonObject> getRestaurants();

    @GET("/api/restaurant/search-rest")
    Call<Restaurant> getRestaurantsByRestType(@Query("keyword") String keyword,
                                    @Query("category_id") int category_id,
                                    @Query("page") int page,
                                    @Query("limit") int limit);

    @GET("/api/favourite-restaurant/get-fav-rest-by-user-id/{id}")
    Call<JsonObject> getFavoriteRestaurant(@Path("id") int id);

    @GET("/api/restaurant/search-rest")
    Call<JsonObject> getRestaurantsByKeywork(@Query("keyword") String keyword,
                                              @Query("category_id") int category_id,
                                              @Query("page") int page,
                                              @Query("limit") int limit);


    @GET("/api/restaurant/search-rest")
    Call<JsonObject> getRestaurantsByKeywork(@Query("keyword") String keyword,
                                             @Query("page") int page,
                                             @Query("limit") int limit);


}
