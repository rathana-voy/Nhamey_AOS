package layout;


import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.RestaurantAdapter;
import com.api.hrd.nhamey.adapters.RestaurantCategoryAdapter;
import com.api.hrd.nhamey.fragments.RestaurantFragment;
import com.api.hrd.nhamey.models.Restaurant;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.api.hrd.nhamey.util.AnimationCollapse;
import com.api.hrd.nhamey.util.ToastMessage;
import com.api.hrd.nhamey.util.layout.DataAdapterProvider;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.RestaurantService;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class content_listview extends Fragment implements DataAdapterProvider<RestType.DATA> {

    LinearLayout layout_location_ca;
    private static RecyclerView mRecyclerVew;
    private ArrayList<Restaurant> restaurants = new ArrayList<>();;
    private RestType.DATA restType;
    private RestaurantService restaurantService;
    private int CategoryId;
    private static boolean isChange;
    private RestaurantAdapter restaurantAdapter;
    private View rootView;
    private static Context context;
    public content_listview() {}

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_content_listview, container, false);
        mRecyclerVew= (RecyclerView) v.findViewById(R.id.mRecycler_view);
        rootView=v;

        return v;
    }


    protected void getRestaurants(int catId){
        Log.d("oooooooooo", catId + "");
        this.restaurantService = ServiceGenerator.createService(RestaurantService.class);
        Call<com.api.hrd.nhamey.models.api_respone.Restaurant> call=this.restaurantService.getRestaurantsByRestType("",catId,1,200);
        call.enqueue(new Callback<com.api.hrd.nhamey.models.api_respone.Restaurant>() {

            @Override
            public void onResponse(Call<com.api.hrd.nhamey.models.api_respone.Restaurant> call, Response<com.api.hrd.nhamey.models.api_respone.Restaurant> response) {
                String image_url = null;
                restaurants.clear();

                LatLng MY = new LatLng(11.575766,104.8869783);
                if(response.body().getDATA()!=null) {
                    for (com.api.hrd.nhamey.models.api_respone.Restaurant.DATA rest : response.body().getDATA()) {

                        for(com.api.hrd.nhamey.models.api_respone.Restaurant.Restpictures picture : rest.getRestpictures()){
                            image_url= picture.getPath_name(); continue;
                        }
                        if(image_url==null){
                            image_url="http://www.nham24.com/upload/1456482095-logo.jpg";
                        }

                        restaurants.add(new com.api.hrd.nhamey.models.Restaurant(
                                rest.getRest_id(),
                                image_url,
                                rest.getRest_name()  != null  ? rest.getRest_name() : "",
                                rest.getRestype()  != null  ? rest.getRestype()  : "",
                                rest.getAddress()  != null  ? rest.getAddress()  : "",
                                getStringDistant(MY, rest.getLatitude(), rest.getLongitude())
                                ));

                    }
                    Log.d("ooooo request", response.body().getDATA().get(0).getRest_name() + "");
                    // Set data into recycler view in fragment
                    Log.d("ARR_PASS", " SET RECYCLER ");
                    //restaurantAdapter.notifyDataSetChanged();

                    //set data
                    bindDdata();
                }else {
                    bindDdata();
                    ToastMessage.mesageShort(context,"there are not any restaurant.");
                }
            }

            @Override
            public void onFailure(Call<com.api.hrd.nhamey.models.api_respone.Restaurant> call, Throwable t) {

            }
        });
    }

    public void bindDdata(){
        restaurantAdapter =new RestaurantAdapter(restaurants,context);
        mRecyclerVew.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerVew.setAdapter(restaurantAdapter);
    }
    // Get restaurant by name and id
    public void getRestaurantListByName(String name) {
        this.restaurantService = ServiceGenerator.createService(RestaurantService.class);
        Call<JsonObject> call_by = restaurantService.getRestaurantsByKeywork(name + "", 1, 1000);
        call_by.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("REQUEST_API", "GET JSON BY NAME & ID BODY \n" + response.body().get("DATA"));
                Gson gson = new Gson();
                restaurants.clear();
                if (response.body().get("DATA") != null) {
                    ArrayList<com.api.hrd.nhamey.models.api_respone.Restaurant.DATA> restaurants_full = gson.fromJson(response.body().get("DATA"), new TypeToken<ArrayList<com.api.hrd.nhamey.models.api_respone.Restaurant.DATA>>() {
                    }.getType());

                    String image_url=null;

                    for ( com.api.hrd.nhamey.models.api_respone.Restaurant.DATA rests: restaurants_full ) {

                        for(com.api.hrd.nhamey.models.api_respone.Restaurant.Restpictures picture : rests.getRestpictures()){
                            image_url= picture.getPath_name(); continue;
                        }
                        if(image_url==null){
                            image_url="http://www.nham24.com/upload/1456482095-logo.jpg";
                        }

                        restaurants.add(new Restaurant(
                                rests.getRest_id(),
                                image_url,
                                rests.getRest_name()  != null  ? rests.getRest_name() : "",
                                rests.getRestype()  != null  ? rests.getRestype()  : "",
                                rests.getAddress()  != null  ? rests.getAddress()  : "",
                                "12 Km"
                        ));
                    }
                    // Log whne data finished bind
                    Log.d("REQUEST_API", " BIND DATA BY NAME SUCCESS ! " + restaurants.size());

                    bindDdata();
                } else {
                    bindDdata();
                    ToastMessage.mesageShort(context,"not founded any restaurant.");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("REQUEST_API", "BIND DATA BY NAME FAIL \n" + t.getMessage());
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //request api from

        if(this.restType!=null) {
            Log.e("oooooooo ViewCreated", this.restType.getRestype_id() + "");
            this.getRestaurants(this.restType.getRestype_id());
        }else {
            Log.e("oooooooo ViewCreated", "category empty");
        }

        // Interaction between NestedScroll and LinearLayout (Location Selector)
        layout_location_ca = (LinearLayout) getActivity().findViewById(R.id.mFrameLocation);

        Log.d("ARR_PASS", " FRAGMENT CREATED VIEW ! ");
    }

    @Override
    public void setData(List<RestType.DATA> data) {

    }

    //get data from restaurant fragment
    @Override
    public void setData(RestType.DATA data,Context context,boolean isChange) {
        this.isChange=isChange;
        this.context=context;
        //change category
        if(isChange){
            if(data!=null) {
                Log.d("oooooo","option category");
                this.restType = data;
                getRestaurants(data.getRestype_id());
            }
        }else {
            this.restType = data;
        }

        if(data!=null){
            Log.d("oooooooo option",data.getRestype_id()+"");
        }
    }

    @Override
    public void setString(String s) {
        if(s !=null){
            this.getRestaurantListByName(s);
        }
    }

    private String getStringDistant(String FT, String FG, String TT, String TG){
        LatLng From = new LatLng(convS2D(FT), convS2D(FG));
        LatLng To = new LatLng(convS2D(TT), convS2D(TG));
        double Distant = getDistance(From, To);
        return formatNumber(Distant);
    }

    private String getStringDistant(LatLng From, String TT, String TG){
        LatLng To = new LatLng(convS2D(TT), convS2D(TG));
        double Distant = getDistance(From, To);
        return formatNumber(Distant);
    }

    private double getDistance(LatLng From, LatLng To) {
        return SphericalUtil.computeDistanceBetween(From, To);
    }

    private String formatNumber(double distance) {
        String unit = " m";
        if (distance < 1) {
            distance *= 1000;
            unit = " mm";
        } else if (distance > 1000) {
            distance /= 1000;
            unit = " km";
        }

        return String.format("%4.3f%s", distance, unit);
    }

    private double convS2D(String s) {
        double lt;
        try {
            lt = Double.parseDouble(s);
        } catch (Exception c) {
            lt = 0.0;
        }
        return lt;
    }

}
