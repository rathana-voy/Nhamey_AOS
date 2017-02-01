package com.api.hrd.nhamey.webservice.services;

import com.api.hrd.nhamey.models.api_respone.AdsBanner;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by RATHANA on 15-Jan-17.
 */

public class HomeApiService {

    public interface AdsBannerService{

        @GET("/api/ads/ads-all")
        public Call<AdsBanner> getAdsBanners(@Query("page") int page,@Query("limit") int limit);

    }

    public interface RestType{
        @GET("/api/restype/get-restype")
        public Call<com.api.hrd.nhamey.models.api_respone.RestType> getRestType(@Query("keyword") String keyword, @Query("page") int page, @Query("limit") int limit);
    }

}
