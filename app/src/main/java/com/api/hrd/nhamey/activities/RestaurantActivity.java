package com.api.hrd.nhamey.activities;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.Pager;
import com.api.hrd.nhamey.adapters.RestaurantAdapter;
import com.api.hrd.nhamey.dialogs.RestaurantCategoryDiaglogFragment;
import com.api.hrd.nhamey.models.MapPionter;
import com.api.hrd.nhamey.models.Restaurant;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.api.hrd.nhamey.util.MySuggestionProvider;

import com.api.hrd.nhamey.util.RestaurantSuggestionProvider;
import com.api.hrd.nhamey.util.layout.DataAdapterProvider;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.HomeApiService;
import com.api.hrd.nhamey.webservice.services.RestaurantService;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;

import java.util.ArrayList;
import java.util.Arrays;
import layout.content_listview;

import layout.content_mapview;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantActivity extends AppCompatActivity implements RestaurantAdapter.CardEventHandler {


    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
    private static String PROVIDER = "GPS";
    private static int REQUEST_CODE = 10;
    private content_mapview mapview;


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TabLayout.Tab tab;
    private ViewPager viewPager;
    private String query;
    // Location
    private LocationListener locationListener;
    private LocationManager locationManager;
    private Location location;
    private Location locationDefault;
    private ArrayList<MapPionter> mapPionters;
    //data
    private DataAdapterProvider<RestType.DATA> dataDataAdapterProvider;
    private ArrayList<RestType.DATA> restTypes;
    private RestType.DATA restType;
    ///api
    private RestaurantService restaurantService;
    private HomeApiService.RestType restTypeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        toolbar = (Toolbar) findViewById(R.id.toolbar_restaurant);
        tabLayout = (TabLayout) findViewById(R.id.mTabCategory);
        viewPager = (ViewPager) findViewById(R.id.mPagerCategory);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // Assign Default location
        initDefualLocation();

        //api create service
        this.createApiServices();

        //init data instance

        dataDataAdapterProvider=new content_listview();
        this.restType=new RestType.DATA();
        this.restTypes=new ArrayList<>();

        //get data from intent
        if (getIntent().getParcelableExtra("REST_TYPE") != null) {
            this.restType = getIntent().getParcelableExtra("REST_TYPE");
            Log.d("ooooo size", this.restType.getRestype_name() + "");
        }

        //get data from api
        this.getRestTypes();
        //Log.d("ooooo restType size",this.restTypes.size()+"");


        ///search
        this.handleIntent(getIntent());
        /*SearchManager searchManager = (SearchManager) RestaurantActivity.this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) findViewById(R.id.action_search);

        //List<String> l = (List) searchManager.getSearchableInfo(Search.this.getComponentName());
        //searchView.setSearchableInfo();

        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
*/



        //MAP initializer
        mapview = new content_mapview();
        mapview.setLocation(locationDefault);

        //set ViewPager
        mapPionters = new ArrayList<>();
        Pager adapter = new Pager(getSupportFragmentManager(), RestaurantActivity.this, tabLayout.getTabCount(), this.restType, mapview);
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


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                setLocation(location);
                Log.d("Location Provider", "-- CHANGE LOCATION -- LT " + getLocation().getLatitude() + " : " + getLocation().getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.d("Location Provider", "-- STATUS CHANGE --");
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d("Location Provider", "-- ENABLE --");

            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d("Location Provider", "-- ENABLE --");
            }
        };
        requestLocation();
    }

    private void requestLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d("Location Provider", "-- REQUEST PERMISSION --");
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, REQUEST_CODE);
        } else {
            Log.d("Location Provider", "-- REQUEST UPDATE --");
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    MIN_TIME_BW_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES,
                    locationListener);
        }
    }

    protected void createApiServices() {
        this.restaurantService = ServiceGenerator.createService(RestaurantService.class);
        this.restTypeService = ServiceGenerator.createService(HomeApiService.RestType.class);
    }

    ////api request
    public void getRestTypes() {
        Call<RestType> call = restTypeService.getRestType("", 1, 100);
        call.enqueue(new Callback<RestType>() {
            @Override
            public void onResponse(Call<RestType> call, Response<RestType> response) {
                if (response.body() != null) {
                    restTypes = (ArrayList<RestType.DATA>) response.body().getDATA();

                } else {
                    Log.d("ooooo data is empty", "data is empty");
                }
                Log.d("oooooo restTypes Size", restTypes.size() + "");
            }

            @Override
            public void onFailure(Call<RestType> call, Throwable t) {
                Log.e("ooooorest Error", t.toString());
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    ///search

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, query, Toast.LENGTH_SHORT).show();

            dataDataAdapterProvider.setString(query);

            Log.d("STEP", "--- SEARCH C --- " + query);
            SearchRecentSuggestions mSearchRecentSuggestions = new SearchRecentSuggestions(this, RestaurantSuggestionProvider.AUTHORITY, RestaurantSuggestionProvider.MODE);
            mSearchRecentSuggestions.saveRecentQuery(query, null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.restaurant_option_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search_rest);

        SearchManager searchManager = (SearchManager) RestaurantActivity.this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(RestaurantActivity.this.getComponentName()));

            searchView.setIconifiedByDefault(true); // Do not iconify the widget; expand it by default
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_location: {
                Intent intent = new Intent(RestaurantActivity.this, LocationSearchActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.action_rest_category: {
                FragmentManager fm = getFragmentManager();
                RestaurantCategoryDiaglogFragment dialog = RestaurantCategoryDiaglogFragment
                        .newInstance("choose categories", this.restTypes);
                dialog.show(fm, "CATEGORY");
                break;
            }
        }
        return true;
    }

    @Override
    public void OnItemClickAdapter(Restaurant restaurant, int position) {
        Intent i = new Intent(RestaurantActivity.this, Detail_Resturant.class);
        Log.e("ooo id :", restaurant.getRest_id() + " Name" + restaurant.getRest_name());
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESTAURANT", restaurant);
        i.putExtras(bundle);
        startActivity(i);
    }

    public Location getLocation() {
        if(location == null){
            Log.d("PAGER", "--- LOCATION NULL --- " );
            location = locationDefault;

        }else {
            Log.d("PAGER", "--- LOCATION DATA --- " );
        }
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private void initDefualLocation(){
        locationDefault = new Location("HRD Center");//11.5757943,104.8869615
        locationDefault.setLatitude(11.5757943);
        locationDefault.setLongitude(104.8869615);
    }
}
