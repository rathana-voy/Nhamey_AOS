package com.api.hrd.nhamey.webservice.services;

import com.api.hrd.nhamey.models.api_respone.Comment_Respone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Thyreach on 1/24/2017.
 */

public interface CommendService {
    @GET("/api/comment/get-comment/{rest_id}")
    public Call<Comment_Respone> getCommentByRestaurant(@Path("rest_id") int rest_id);
}
