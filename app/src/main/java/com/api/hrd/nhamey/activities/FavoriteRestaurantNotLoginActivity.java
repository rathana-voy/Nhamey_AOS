package com.api.hrd.nhamey.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.api.hrd.nhamey.R;

public class FavoriteRestaurantNotLoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_restaurant_not_login);

        toolbar= (Toolbar) findViewById(R.id.toolbar_not_login);
        btnLogin= (Button) findViewById(R.id.btn_not_login);

        setSupportActionBar(toolbar);
        setTitle("Login");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("FAVORITE_NOT_LOGIN","NOT_LOGIN");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
