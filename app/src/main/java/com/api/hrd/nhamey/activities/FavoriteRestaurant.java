package com.api.hrd.nhamey.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.api.hrd.nhamey.R;

import java.util.ArrayList;

import layout.CommunicatorFragment;


public class FavoriteRestaurant extends AppCompatActivity implements CommunicatorFragment{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_restaurant);

//        fragmentTransaction.commit();

        Spinner filter = (Spinner) findViewById(R.id.spinner_filter);
        Spinner sort = (Spinner) findViewById(R.id.spinner_sort_by);
        String[] stringsFilter = getResources().getStringArray(R.array.number_array);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(FavoriteRestaurant.this, android.R.layout.simple_spinner_dropdown_item, stringsFilter);
        filter.setAdapter(arrayAdapter);
        sort.setAdapter(arrayAdapter);
    }

    @Override
    public void onListClick(int position) {

    }

    @Override
    public void checkViewCreated(Boolean created) {

    }

    @Override
    public void RespondString(String data) {

    }

    @Override
    public void RespondStringArrayList(ArrayList<String> data) {

    }

}
