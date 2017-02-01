package com.api.hrd.nhamey.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.activities.Category;
import com.api.hrd.nhamey.activities.HomeActivity;
import com.api.hrd.nhamey.activities.LocationSearchActivity;
import com.api.hrd.nhamey.activities.SignupActivity;
import com.api.hrd.nhamey.adapters.Pager;
import com.api.hrd.nhamey.adapters.RestaurantAdapter;
import com.api.hrd.nhamey.models.Restaurants;
import com.api.hrd.nhamey.models.Restype;
import com.api.hrd.nhamey.dialogs.RestaurantCategoryDiaglogFragment;

import com.api.hrd.nhamey.models.api_respone.RestType;
import com.api.hrd.nhamey.models.api_respone.Restaurant;
import com.api.hrd.nhamey.util.DataOptionClick;
import com.api.hrd.nhamey.util.ToastMessage;
import com.api.hrd.nhamey.util.layout.DataAdapterProvider;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.RestaurantService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import layout.CommunicatorFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rathana on 18/1/17.
 */

public class RestaurantFragment extends Fragment{

    ArrayList<Restaurants> restaurants_full;
    ArrayAdapter<String> arrayAdapter;

    private Toolbar toolbar;
    private RestaurantFragmentHandler restaurantFragmentHandler;

    private RestType.DATA restType;
    private Spinner sChooseLocation,sChooseRestType;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RestaurantAdapter restaurantAdapter;
    private TabLayout.Tab tab;
    private RestaurantService restaurantService;
    private CommunicatorFragment communicatorFragment;
    private RecyclerView restRecycler;
    private View rootView;
    private ArrayList<com.api.hrd.nhamey.models.Restaurant> restaurants;

    public void setRestType(RestType.DATA restType){
        this.restType=restType;
    }
    public RestType.DATA getRestType(){
        return this.restType;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        this.restaurantService= ServiceGenerator.createService(RestaurantService.class);
        this.restaurants=new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.from(getActivity()).inflate(R.layout.restaurant_fragment_layout,container,false);
        rootView=view;
        toolbar= (Toolbar) view.findViewById(R.id.toolbar_restaurant);
        tabLayout = (TabLayout) view.findViewById(R.id.mTabCategory);
        viewPager= (ViewPager) view.findViewById(R.id.mPagerCategory);
        //restRecycler = (RecyclerView) view.findViewById(R.id.mRecycler_view);

        restaurantFragmentHandler= (RestaurantFragmentHandler) getActivity();
        //restaurantAdapterCallBack = (RestaurantAdapterCallBack) getActivity();
        communicatorFragment= (CommunicatorFragment) getActivity();

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).setTitle("Restaurant");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        restaurantFragmentHandler.getViews(toolbar,tabLayout,viewPager);
        restaurantFragmentHandler.DrawerToggleButtonHandle();
        //ViewPager

        Pager adapter=new Pager(((AppCompatActivity) getActivity()).getSupportFragmentManager(),getActivity(),
                tabLayout.getTabCount(),this.restType);
        viewPager.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    //category optionMenu selected handling

    public interface RestaurantFragmentHandler extends SetToolbar{
        void getRestTypeIDHandler(int id);

    }

    public interface RestaurantAdapterCallBack{
        void categoryDataChange(int categoryId);
    }

    public void getRestaurant(int restTypeId){
        //final ArrayList<com.api.hrd.nhamey.models.Restaurant> restaurants =new ArrayList<>();
        Call<Restaurant> call=this.restaurantService.getRestaurantsByRestType("",restTypeId,1,200);
        call.enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {

                String image_url = null;
                if(response.body().getDATA()!=null) {
                    for (Restaurant.DATA rest : response.body().getDATA()) {

                        if (rest.getRestpictures().get(0) != null ) {
                            image_url = rest.getRestpictures().get(0).getPath_name();
                        } else {
                            image_url = "http://120.136.24.174:1304/resources/upload/resttype/38becb2c-68b3-4293-a524-c9f740a0d44c.png";
                        }

                        Log.d("oooooooooo", rest.getAddress() + "");

                        restaurants.add(new com.api.hrd.nhamey.models.Restaurant(
                                rest.getRest_id(),
                                image_url,
                                rest.getRest_name()  != null  ? rest.getRest_name() + "" : "",
                                rest.getRestype()  != null  ? rest.getRestype() + "" : "",
                                rest.getAddress()  != null  ? rest.getAddress() + "" : "",
                                "1.2K"));

                    }


                    // Set data into recycler view in fragment
                    Log.d("ARR_PASS", " SET RECYCLER ");
                    restRecycler = (RecyclerView) rootView.findViewById(R.id.mRecycler_view);
                    restaurantAdapter = new RestaurantAdapter(restaurants, getActivity());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    restRecycler.setLayoutManager(linearLayoutManager);
                    restRecycler.setAdapter(restaurantAdapter);

                }
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {

            }
        });
    }
    public String restType(List<Restype> type) {
        int size = type.size();
        String restType = "";
        for (int i = 0; i < size; i++) {
            restType += type.get(i).getRestype_name() + (i == size - 1 ? "" : " ,");
        }
        return restType;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.restaurant_option_menu,menu);
    }

    public void restaurantCategoryDataChange(int categoryId){


    }

}
