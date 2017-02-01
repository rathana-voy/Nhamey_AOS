package com.api.hrd.nhamey.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.User;
import com.api.hrd.nhamey.models.api_respone.SocialUser;
import com.api.hrd.nhamey.models.api_respone.UserLogin;
import com.api.hrd.nhamey.util.ToastMessage;
import com.api.hrd.nhamey.util.layout.DataUserLoginHandler;
import com.api.hrd.nhamey.util.seccion.Session;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.UserService;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private Toolbar toolbar;
    private UserLogin userLogin;
    private UserService userService;
    private SocialUser socialUser;
    private TextView tvLoginFail;
    private FrameLayout fLoginFail;

    @InjectView(R.id.input_user) EditText userText;
    @InjectView(R.id.input_password) EditText passwordText;
    @InjectView(R.id.btn_login) Button loginButton;
    @InjectView(R.id.link_signup) TextView signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar= (Toolbar) findViewById(R.id.toolbar_layout);
        fLoginFail = (FrameLayout) findViewById(R.id.f_login_fail);
        setSupportActionBar(toolbar);
        //add back arrow to toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if(getIntent()!=null){
            setTitle(getIntent().getStringExtra("NAV_LOGIN"));
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //create service
        this.userService= ServiceGenerator.createService(UserService.class);
        this.userLogin=new UserLogin();

        ButterKnife.inject(this);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userEmail = userText.getText().toString();
                String password = passwordText.getText().toString();
                userLogin.setUSER_EMAIL(userEmail);
                userLogin.setUSER_PASSWORD(password);
                login(userLogin,false);
            }
        });

        signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void login(UserLogin login ,boolean isSignup) {
        Log.d(TAG, "Login");

        if(!isSignup) {
            if (!validate()) {
                onLoginFailed();
                return;
            }
        }
        loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        //progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        //Log.e("user ",userEmail+" pass :"+ password);
        userLogin.setUSER_EMAIL(login.getUSER_EMAIL());
        userLogin.setUSER_PASSWORD(login.getUSER_PASSWORD());

        // TODO: Implement your own authentication logic here.
        Log.e("ooooo before login ","before");
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        Log.e("ooooo user ",userLogin.getUSER_EMAIL()+" pass :"+ userLogin.getUSER_PASSWORD());
                        userLogin(userLogin);

                        Log.e("ooooo login ","login");
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                Log.e("ooooo login ","login after sign up");
                    this.userLogin.setUSER_EMAIL(data.getStringExtra("USER_EMAIL"));
                    this.userLogin.setUSER_PASSWORD(data.getStringExtra("USER_PASSWORD"));
                    login(userLogin,true);
                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                //this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        loginButton.setEnabled(true);
        Intent intent =new Intent();
        intent.putExtra("GO_BACK_HOME","GO BACK HOME SCREEN!");
        setResult(RESULT_OK,intent);
        finish();
    }

    public void onLoginFailed() {
        //Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG).show();
        tvLoginFail=new TextView(LoginActivity.this);
        tvLoginFail.setText("login failed.wrong email or password.please to login again.");
        tvLoginFail.setTextColor(Color.WHITE);
        tvLoginFail.setGravity(Gravity.CENTER);
        fLoginFail.addView(tvLoginFail);

        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String user = userText.getText().toString();
        String password = passwordText.getText().toString();

        if (user.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(user).matches()) {
            userText.setError("Enter a valid Username");
            valid = false;
        } else {
            userText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 15) {
            passwordText.setError("Between 4 and 15 Characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }

    public void userLogin(UserLogin uLogin){
        Log.e("user request ",uLogin.getUSER_EMAIL() + "pass : "+uLogin.getUSER_PASSWORD());

        Call<SocialUser> call=this.userService.mobileLogin(uLogin);
        call.enqueue(new Callback<SocialUser>() {
            @Override
            public void onResponse(Call<SocialUser> call, Response<SocialUser> response) {
                if(response.body()!=null){
                    if(response.body().getCODE()==200) {

                        SocialUser.DATA u = response.body().getDATA();
                        User user = new User();
                        user.setUserId(u.getUSER_ID());
                        user.setUserFirstName(u.getUSER_FIRST_NAME());
                        user.setUserLastName(u.getUSER_LAST_NAME());
                        user.setUserName(u.getUSER_NAME());
                        user.setUserEmail(u.getUSER_EMAIL());
                        user.setPassword(u.getUSER_PASSWROD());
                        user.setUserDob(u.getUSER_DOB());
                        user.setUserGender(u.getUSER_GENDER());
                        user.setPhoneNumber(u.getUSER_PHONE_NUMBER());
                        user.setUserImageProfile(u.getUSER_IMAGE_PROFILE());
                        user.setUserImageName(u.getUSER_IMAGE_NAME());
                        user.setUserRegisteredDate(u.getUSER_REGISTER_DATE());
                        user.setUserSignupWith(u.getUSER_SIGNUP_WITH());
                        user.setUserSocialId(u.getUSER_SOCIAL_ID());
                        user.setLogin(u.isUSER_IS_LOGIN());
                        // save user session
                        Session.saveUserSession(LoginActivity.this, user);

                        onLoginSuccess();
                    }else{
                        onLoginFailed();
                    }
                }else{
                    ToastMessage.mesageShort(LoginActivity.this,"Login invalid.Please try again!");
                }

            }

            @Override
            public void onFailure(Call<SocialUser> call, Throwable t) {
                Log.d("ooooo login failure ",t.toString());
            }
        });

    }
}