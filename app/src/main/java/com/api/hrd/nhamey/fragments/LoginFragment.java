package com.api.hrd.nhamey.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.activities.HomeActivity;
import com.api.hrd.nhamey.activities.LoginActivity;
import com.api.hrd.nhamey.models.api_respone.SocialUser;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.UserService;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rathana on 10/1/17.
 */

public class LoginFragment extends Fragment{
    private LoginButton btn_facebook_login;
    private Toolbar toolbar;
    private AccessTokenTracker accessTokenTracker;
    private AccessToken accessToken;
    private Button NhameEyLogin;
    private LoginFragmentHandler loginFragmentHandler;
    private ProfileTracker profileTracker;
    private CallbackManager callbackManager;

    private UserService userService;
    private FacebookCallback<LoginResult> mCallback=new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            Log.d("ooooo facebook" , loginResult.getAccessToken().getUserId());
            accessToken = loginResult.getAccessToken();
            Profile profile=Profile.getCurrentProfile();
            if(profile!=null){
                Log.d("ooooo user profile" , profile.getFirstName());
                SocialUser.DATA user =new SocialUser.DATA();
                user.setUSER_SOCIAL_ID(profile.getId());
                user.setUSER_FIRST_NAME(profile.getFirstName());
                user.setUSER_LAST_NAME(profile.getLastName());
                user.setUSER_NAME(profile.getName());
                user.setUSER_IMAGE_PROFILE(profile.getProfilePictureUri(278,328).toString());
                user.setUSER_GENDER("male");
                user.setUSER_SIGNUP_WITH("FACEBOOK");

                Call<SocialUser> call = userService.mobileSingUp(user.getUSER_FIRST_NAME(),
                                        user.getUSER_LAST_NAME(),
                                        user.getUSER_NAME(),
                                        user.getUSER_GENDER(),
                                        user.getUSER_EMAIL(),
                                        user.getUSER_PASSWORD(),
                                        user.getUSER_DOB(),
                                        user.getUSER_IMAGE_PROFILE(),
                                        user.getUSER_PHONE_NUMBER(),
                                        user.getUSER_SIGNUP_WITH(),
                                        user.getUSER_SOCIAL_ID());

                call.enqueue(new Callback<SocialUser>() {
                    @Override
                    public void onResponse(Call<SocialUser> call, Response<SocialUser> response) {

                            Log.d("ooooo sign up ", response.body().getMESSAGE());

                    }

                    @Override
                    public void onFailure(Call<SocialUser> call, Throwable t) {

                    }
                });
            }
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.login_fragment_layout,container,false);
        btn_facebook_login= (LoginButton) view.findViewById(R.id.btn_facebook_login);
        NhameEyLogin= (Button) view.findViewById(R.id.btn_login);
        toolbar= (Toolbar) view.findViewById(R.id.toolbar_login);
        // Other app specific specialization

        loginFragmentHandler= (LoginFragmentHandler) getActivity();
        return view ;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        loginFragmentHandler.getViews(toolbar,null,null);
        loginFragmentHandler.DrawerToggleButtonHandle();

        //custom button login
        btn_facebook_login.setReadPermissions("email");
        // If using in a fragment
        btn_facebook_login.setFragment(this);

        btn_facebook_login.registerCallback(callbackManager,mCallback);


        NhameEyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intent,HomeActivity.LOGIN_SUCCESS_REQUEST);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        this.userService= ServiceGenerator.createService(UserService.class);
    }



   /* @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.startTracking();
        profileTracker.startTracking();
    }*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public interface LoginFragmentHandler extends SetToolbar{

    }
}
