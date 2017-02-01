package com.api.hrd.nhamey.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.api_respone.SocialUser;
import com.api.hrd.nhamey.util.ToastMessage;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.UserService;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    private Toolbar toolbar;
    private UserService userService;
    @InjectView(R.id.input_name) EditText nameText;
    @InjectView(R.id.input_email) EditText emailText;
    @InjectView(R.id.input_password) EditText passwordText;
    @InjectView(R.id.btn_signup) Button signupButton;
    @InjectView(R.id.link_login) TextView loginLink;

    private RadioGroup radioGroupGender;
    private RadioButton radGnder;
    private String userGender;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        toolbar= (Toolbar) findViewById(R.id.toolbar_layout);
        radioGroupGender = (RadioGroup) findViewById(R.id.group_rad_gender);

        setSupportActionBar(toolbar);
        //add back arrow to toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if(getIntent()!=null){
            setTitle(getIntent().getStringExtra("NAV_TITLE"));
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ButterKnife.inject(this);

        ///create service generator
        this.userService= ServiceGenerator.createService(UserService.class);

        radGnder= (RadioButton) findViewById(this.radioGroupGender.getCheckedRadioButtonId());
        this.userGender=radGnder.getText().toString();
        this.radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radGnder= (RadioButton) findViewById(group.getCheckedRadioButtonId());
                userGender=radGnder.getText().toString();
                Log.e("ooooo gender",userGender+"");
            }
        });
        //this.radGnder= (RadioButton) findViewById(genderId);
        //this.userGender=this.radGnder.getText().toString();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            private static final int  REQUEST_LOGIN = 0;

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                intent.putExtra("NAV_LOGIN","Login");
                startActivityForResult(intent, REQUEST_LOGIN);
                finish();
            }
        });
    }

    public void saveUser(final SocialUser.DATA user){

        Call<SocialUser> call =userService.mobileSingUp(
                    user.getUSER_FIRST_NAME(),
                    user.getUSER_LAST_NAME(),
                    user.getUSER_NAME(),
                    user.getUSER_GENDER(),
                    user.getUSER_EMAIL(),
                    user.getUSER_PASSWORD(),
                    user.getUSER_DOB(),
                    user.getUSER_IMAGE_NAME(),
                    user.getUSER_PHONE_NUMBER(),
                    user.getUSER_SIGNUP_WITH(),
                    user.getUSER_SOCIAL_ID());
        call.enqueue(new Callback<SocialUser>() {
            @Override
            public void onResponse(Call<SocialUser> call, Response<SocialUser> response) {
                if(response.body()!=null){
                    Log.d("oooo sign up " ,response.body().getMESSAGE()+"");
                    Log.d("oooo pass " ,user.getUSER_PASSWORD());
                    if(response.body().getCODE()==200){
                        if(response.body().isSTATUS_SIGNUP()){
                            onSignupSuccess(user.getUSER_EMAIL(),user.getUSER_PASSWORD());
                        }else{
                            ToastMessage.mesageShort(SignupActivity.this,"this email already registered.Do you want to login");
                        }

                    }else{
                        ToastMessage.mesageShort(SignupActivity.this,"registered invalid! try again.");
                        onSignupFailed();
                    }

                }else{
                    onSignupFailed();
                }
            }

            @Override
            public void onFailure(Call<SocialUser> call, Throwable t) {
                Log.d("SignUp : " ,t.toString());
            }
        });
    }
    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        final SocialUser.DATA user=new SocialUser.DATA();
        user.setUSER_NAME(name);
        user.setUSER_EMAIL(email);
        user.setUSER_PASSWORD(password);
        user.setUSER_SIGNUP_WITH("NHAMEY");
        user.setUSER_GENDER(this.userGender);
        // Implement Signup Login Here

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        saveUser(user);
                        //onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess(String email,String password) {
        signupButton.setEnabled(true);
        Intent i=new Intent();
        i.putExtra("USER_EMAIL",email);
        i.putExtra("USER_PASSWORD",password);
        setResult(RESULT_OK, i);
        finish();
    }

    public void onSignupFailed() {

        //Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            nameText.setError("At least 3 characters");
            valid = false;
        } else {
            nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("Enter a Valid Email Address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 15) {
            passwordText.setError("Between 4 and 15 Characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }
}
