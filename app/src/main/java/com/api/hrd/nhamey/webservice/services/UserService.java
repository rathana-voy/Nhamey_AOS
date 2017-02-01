package com.api.hrd.nhamey.webservice.services;

import com.api.hrd.nhamey.models.User;
import com.api.hrd.nhamey.models.api_respone.SocialUser;
import com.api.hrd.nhamey.models.api_respone.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by srec05 on 1/25/2017.
 */

public interface UserService {

    @POST("api/user/mobile/user/login-with-socail")
    public Call<SocialUser> mobileSingUp(@Query("userFirstName") String userFirstName ,
                                         @Query("userLastName") String userLastName ,
                                         @Query("userName") String userName ,
                                         @Query("userGender") String userGender ,
                                         @Query("userEmail") String userEmail,
                                         @Query("userPassword") String userPassword ,
                                         @Query("userDob") String userDob ,
                                         @Query("userImage") String userImage ,
                                         @Query("userPhoneNumber") String userPhoneNumber ,
                                         @Query("userSigUpWith") String userSigeUpWith,
                                         @Query("userSocialId") String userSocialId);

    @POST("/api/user/mobile/login")
    public Call<SocialUser> mobileLogin(@Body UserLogin userLogin);

}
