package com.api.hrd.nhamey.webservice.services;

import com.api.hrd.nhamey.models.api_respone.ResturantDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Thyreach on 1/21/2017.
 */

public interface ResturantDetailService {
    @GET("/api/restaurant/{rest_id}")
    Call<ResturantDetail> getResturantDetail(@Path("rest_id") int resturantId);
}
