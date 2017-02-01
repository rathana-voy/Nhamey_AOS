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
import com.api.hrd.nhamey.constance.Constance;
import com.api.hrd.nhamey.models.FoodInfo;
import com.api.hrd.nhamey.models.api_respone.Food_Api_Respone;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.FoodService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Thyreach on 1/9/2017.
 */

public class FoodMenuFragment extends Fragment{
    RecyclerView recyclerView;
    ArrayList<FoodInfo> foodInfoArrayList = new ArrayList<>();
    ArrayList<FoodInfo> foodArrayForStateRestore = new ArrayList<>();
    FoodMenuRecyclerAdapter foodMenuRecyclerAdapter;

    //Make Obj of Constance.FoodFragment to==>
    // ===> get restuarant_id's value(have set) from Constance Class
    Constance.FoodFragment constanceFoodFragment = new Constance.FoodFragment();

    /* ======= */

    //FoodData List
    List<Food_Api_Respone.DATA> foodData;

    // Api Service
     FoodService foodService = foodService = ServiceGenerator.createService(FoodService.class);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.foodfragment_detail_resturant, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.food_recycler);
       /* for (int i=0; i<=9; i++){
            foodInfoArrayList.add(new FoodInfo("Name","Description","99","Image"));
            // Log.e(foodInfoArrayList.get(i).getFood_name()+":","array at ");
        }


        foodMenuRecyclerAdapter = new FoodMenuRecyclerAdapter(getContext(),foodInfoArrayList);
        recyclerView.setAdapter(foodMenuRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));*/



       /* foodMenuRecyclerAdapter = new FoodMenuRecyclerAdapter(getContext(), foodArrayForStateRestore);
        recyclerView.setAdapter(foodMenuRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));*/
        /*=========================*/
        return rootView;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //RESTAURANT_ID get from de
        foodResquestAPI(constanceFoodFragment.RESTAURANT_ID);
        Log.e(">>>ConstanceRestId"," "+constanceFoodFragment.RESTAURANT_ID);
        //foodArrayForStateRestore = foodInfoArrayList;
    }



    public void foodResquestAPI(int restidfromConstance){

        Call<Food_Api_Respone> call = foodService.getFood(restidfromConstance);
        call.enqueue(new Callback<Food_Api_Respone>() {
            @Override
            public void onResponse(Call<Food_Api_Respone> call, Response<Food_Api_Respone> response) {

               // Log.e(">>>>onRespone >>>>> "+response.body().getCODE(),"Code");

                if (response.body()!= null){
                /*    Log.e(">>>>onRespone >>>>> "+response.body().getCODE().toString(),"Gegegege");
*/
                    foodData = response.body().getDATA();
                    Log.e("fSizeFoodMenuFragment",""+foodData.size());
                    for (int i=0; i<foodData.size(); i++){
                        foodInfoArrayList.add(new FoodInfo(""+foodData.get(i).getFood_name(),""+foodData.get(i).getDescription(),""+foodData.get(i).getPrice(),foodData.get(i).getFoodImage()));
                       // Log.e(foodInfoArrayList.get(i).getFood_name()+":","array at ");
                    }


                    foodMenuRecyclerAdapter = new FoodMenuRecyclerAdapter(getContext(),foodInfoArrayList);
                    recyclerView.setAdapter(foodMenuRecyclerAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                }
            }

            @Override
            public void onFailure(Call<Food_Api_Respone> call, Throwable t) {
                Log.e(">>>>!!!!can't request ",t.getMessage());
            }
        });

        Log.e(""+foodInfoArrayList.size(),"size of foodInfo");

    }


/*
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
         foodMenuRecyclerAdapter = new FoodMenuRecyclerAdapter(getContext(),foodInfoArrayList);
                    recyclerView.setAdapter(foodMenuRecyclerAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }*/

}
