package com.api.hrd.nhamey.webservice.services;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by KeeporderGO on 1/30/2017.
 */

public interface FavoritesService {
    @GET("/api/favourite-restaurant/find-by-user-id/{user_id}")
    Call<JsonObject> getFavoriteRestaurantsByKeywork(@Path("user_id") int id,
                                             @Query("page") int page,
                                             @Query("limit") int limit);
}
