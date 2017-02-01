package com.api.hrd.nhamey.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.FoodMenuRecyclerAdapter;
import com.api.hrd.nhamey.models.FoodInfo;

import java.util.ArrayList;

/**
 * Created by Thyreach on 1/9/2017.
 */
public class DrinkMenuFragment extends Fragment {

    private int restId;
    RecyclerView recyclerView;
    ArrayList<FoodInfo> foodInfoArrayList = new ArrayList<>();
    FoodMenuRecyclerAdapter foodMenuRecyclerAdapter;

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.drinkfragment_detail_resturant, container, false);


        recyclerView = (RecyclerView) rootView.findViewById(R.id.drink_recycler);
       /* for (int i = 0; i <= 3; i++) {
            foodInfoArrayList.add(new FoodInfo("Angkor Beer"+i, "the most delicious beer of cambodia","0.8$", R.mipmap.ic_launcher));
        }*/
        /* foodInfoArrayList = FoodInfo.createContactsList(10);
        Log.e(">>>>>>>>>",""+foodInfoArrayList.size());*/

        foodMenuRecyclerAdapter = new FoodMenuRecyclerAdapter(getContext(),foodInfoArrayList);

        recyclerView.setAdapter(foodMenuRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Log.e("+++++++++ See.......",""+foodInfoArrayList.size());

        /*=========================*/

        return rootView;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
