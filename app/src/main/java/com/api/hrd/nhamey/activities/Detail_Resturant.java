package com.api.hrd.nhamey.activities;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.FoodMenuRecyclerAdapter;
import com.api.hrd.nhamey.constance.Constance;
import com.api.hrd.nhamey.fragments.DrinkMenuFragment;
import com.api.hrd.nhamey.fragments.FoodMenuFragment;
import com.api.hrd.nhamey.fragments.MenuDetailFragment;
import com.api.hrd.nhamey.fragments.ReviewFragment;
import com.api.hrd.nhamey.models.FoodInfo;
import com.api.hrd.nhamey.models.Restaurant;
import com.api.hrd.nhamey.models.api_respone.ResturantDetail;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.FoodService;
import com.api.hrd.nhamey.webservice.services.ResturantDetailService;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail_Resturant extends AppCompatActivity implements FoodMenuRecyclerAdapter.DetailEachFood{
    public FragmentManager fm = getSupportFragmentManager();
    TabLayout tabLayoutcard;
    ViewPager viewPagerincard;

    private Activity mcontext;
    //data
    private Restaurant restaurant;

    ReviewFragment reviewFragment = new ReviewFragment();
    DrinkMenuFragment drinkMenuFragment = new DrinkMenuFragment();
    FoodMenuFragment foodMenuFragment = new FoodMenuFragment();
    MenuDetailFragment menuDetailFragment= new MenuDetailFragment();
    FragmentManager fragmentManager;
/*
*
*
* */
    TextView resturantName;
    TextView resturantType;
    TextView resturantOpenHours;
    TextView resturantAddress;
    ImageView restImg;
    com.api.hrd.nhamey.models.api_respone.ResturantDetail.DATA data;
    ResturantDetailService resturantDetailService;
    FoodService foodService = foodService = ServiceGenerator.createService(FoodService.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resturant_detail_main_activity);
        /*
        * view layout element*/
        restImg = (ImageView) findViewById(R.id.resturant_image);
        resturantName = (TextView) findViewById(R.id.resturant_name);
        resturantType = (TextView) findViewById(R.id.resturant_type);
        resturantOpenHours = (TextView) findViewById(R.id.resturant_openhours);
        resturantAddress = (TextView) findViewById(R.id.resturant_addreess);
        /*=======*/


        /*Service API */
        resturantDetailService = ServiceGenerator.createService(ResturantDetailService.class);

       /* viewPagerincard = (ViewPager) findViewById(R.id.card_detail_veiwpager);*/
        tabLayoutcard = (TabLayout) findViewById(R.id.tapincard);
        tabLayoutcard.addTab(tabLayoutcard.newTab().setIcon(R.drawable.foodicon));
        tabLayoutcard.addTab(tabLayoutcard.newTab().setIcon(R.drawable.locationicon));
        tabLayoutcard.addTab(tabLayoutcard.newTab().setIcon(R.drawable.commenticon));

        /*///catch data from restaurant screen activity*/
        if(getIntent().getParcelableExtra("RESTAURANT")!=null){
               this.restaurant=getIntent().getParcelableExtra("RESTAURANT");

            Log.e("oo restName", "rest id" +this.restaurant.getRest_name() );
        }

        // TODO: 1/19/2017   add a fragment to Activity as defult
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.frame_main,menuDetailFragment).addToBackStack("reach").commit();
        Constance.FoodFragment constanceFoodFragment = new Constance.FoodFragment();
        constanceFoodFragment.RESTAURANT_ID=restaurant.getRest_id();
        Log.e("restIdFromActivity","Detail >"+ constanceFoodFragment.RESTAURANT_ID);
        fragmentTransaction.replace(R.id.frame_main,menuDetailFragment).commit();
        // TODO: 1/19/2017  perform on clicking any Tab(TabLayout)
        tabLayoutcard.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0 :
                      // Log.e(">>>>>>>>>>> hi..... ",">>>>>>>>>>>>> hi............hi........hi...........");
                        Toast.makeText(getApplicationContext(), "Tab " + tabLayoutcard.getSelectedTabPosition(), Toast.LENGTH_LONG).show();
                        replaceFragment(menuDetailFragment);
                        break;

                    case 1 :
                        Toast.makeText(getApplicationContext(), "Tab " + tabLayoutcard.getSelectedTabPosition(), Toast.LENGTH_LONG).show();
                        replaceFragment(drinkMenuFragment);
                        break;

                    case 2 :
                       /* Toast.makeText(getApplicationContext(), "Tab " + tabLayoutcard.getSelectedTabPosition(), Toast.LENGTH_LONG).show();*/
                        replaceFragment(reviewFragment);
                        break;

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        resturantInfoResquestAPI(restaurant);

    }

    // TODO: 1/19/2017 replace any fragment ( Method )
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_main,fragment);
        fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public void resturantInfoResquestAPI(Restaurant restaurant){
        //Log.e(">>>>>> "+restaurant.getRest_id()," >>>>rest id in reqrest api");
        Call<ResturantDetail> call = resturantDetailService.getResturantDetail(restaurant.getRest_id());
        call.enqueue(new Callback<ResturantDetail>() {

            List<String> listImage = new ArrayList<String>();
            @Override
            public void onResponse(Call<ResturantDetail> call, Response<ResturantDetail> response) {
                if(response.body()!=null){
                    data = response.body().getDATA();
                    //Log.e("DATA>>>>>>", "" + data.getRest_id() !=null  ? data.getRest_id() +"" : "" );
                    //Log.e(">>>>> Data",""+response.body().getCODE());
                    //// TODO: 1/23/2017 set image to Imageview from API's resource(Url), Using Glide Library
                    String imgUrl=null;
                    for(com.api.hrd.nhamey.models.api_respone.ResturantDetail.Restpictures pics : data.getRestpictures()){
                         imgUrl = pics.getPath_name()+"";continue;
                    }
                    if(imgUrl ==null) imgUrl = "http://www.nham24.com/upload/1482396804-amazon-.jpeg";

                    Glide.with(getApplicationContext()).load(imgUrl)
                            .crossFade()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(restImg);
                    // TODO: 1/23/2017 set data to view :name,type,address,OpenHours of a Resturant 
                        resturantName.setText(data.getRest_name().toString());
                        resturantType.setText(data.getRestype().get(0).restype_name + "&"+" " + data.getRestype().get(1).restype_name + "&"+" " + data.getRestype().get(2).restype_name);
                        resturantAddress.setText(data.getAddress().street +"St"+" "+ data.getAddress().getDistrict() + " " + data.getAddress().getCommunce() + " " + data.getAddress().getVillage() + " " + data.getAddress().getProvince());
                        resturantOpenHours.setText(""+data.getOpen_close());

                }
            }

            @Override
            public void onFailure(Call<ResturantDetail> call, Throwable t) {
                if (data!=null){
                    Log.e(">>>>onF but have data :",data.getRest_name().toString());
                    resturantName.setText(data.getRest_name().toString());
                }
                Log.e(">>>>>>>>> DATA","onFailure Method......");
            }
        });
    }

    @Override
    public void showFoodDetail(FoodInfo foodInfo,int position) {
        final Dialog dialog = new Dialog(getApplicationContext());
        //dialog.setContentView();
            Toast.makeText(getApplicationContext(),""+foodInfo.getFood_name()+" "+position+">>>>>", Toast.LENGTH_LONG).show();


    }


   /* @Override
    protected void onResume() {
        super.onResume();
        if (data!=null){
            Log.e(">>>>> onResume :",data.getRest_name().toString());
            resturantName.setText(data.getRest_name().toString());
        }
    }*/

    /*@Override
    protected void onStart() {
        super.onStart();
        if (data!=null){
            Log.e(">>>>> onStart :",data.getRest_name().toString());
            resturantName.setText(data.getRest_name().toString());
        }
    }*/
}
