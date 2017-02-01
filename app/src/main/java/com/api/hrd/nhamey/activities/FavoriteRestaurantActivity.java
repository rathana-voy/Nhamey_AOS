package com.api.hrd.nhamey.activities;

import android.app.DialogFragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.RestaurantAdapter;
import com.api.hrd.nhamey.dialogs.FilterDialogFragement;
import com.api.hrd.nhamey.dialogs.SortDialogFragment;
import com.api.hrd.nhamey.models.Favorite;
import com.api.hrd.nhamey.models.Restaurant;
import com.api.hrd.nhamey.models.Restaurants;
import com.api.hrd.nhamey.models.api_respone.FavoriteSearch;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.api.hrd.nhamey.util.GPSTracker;
import com.api.hrd.nhamey.util.MySuggestionProvider;
import com.api.hrd.nhamey.util.ToastMessage;
import com.api.hrd.nhamey.util.seccion.Session;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.FavoritesService;
import com.api.hrd.nhamey.webservice.services.RestaurantService;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FavoriteRestaurantActivity extends AppCompatActivity implements
        FilterDialogFragement.FilterDialogHandler,
        SortDialogFragment.SortDialogHandler,
        RestaurantAdapter.CardEventHandler {

    private static ArrayList<Restaurant> restaurants;
    RecyclerView recyclerView;
    ArrayList<Restaurants> restaurants_full;
    ArrayList<FavoriteSearch.DATA> favorites_1;
    ArrayList<Favorite> favorites;
    ArrayAdapter<String> arrayAdapter;
    RestaurantService restService;
    FavoritesService favoritesService;
    private int PAGE_NUMBER = 1;
    private int RECORD_MUNBER = 200;
    private Boolean isAccessToAPI = false;
    private RestType.DATA restType;
    private Toolbar toolbar;
    private String query;
    private ServiceGenerator serviceGenerator;
    private LatLng defualtLatLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_restaurant);
        toolbar = (Toolbar) findViewById(R.id.toolbar_favorite);
        setSupportActionBar(toolbar);
        //add back arrow to toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Favorites");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //search module
        // Get the intent, verify the action and get the queryif
        this.handleIntent(getIntent());

        // Start request to server
        Log.d("ARR_PASS", " REQUEST DATA ");
        restaurants = new ArrayList<>();
        favorites = new ArrayList<>();
        restaurants_full = new ArrayList<>();
        restService = ServiceGenerator.createService(RestaurantService.class);
        favoritesService = ServiceGenerator.createService(FavoritesService.class);

        //LocationManager locationManager=get
        //GPSTracker gps =new GPSTracker(this);
        // Set default Lat Lng HRD Center
        //defualtLatLng = new LatLng(gps.getLocation().getLatitude(), gps.getLocation().getLongitude());
        defualtLatLng = new LatLng(11.5661763, 104.8932169);
        // Default USER ID
        Session.readUserSession(FavoriteRestaurantActivity.this);
        getFavRestaurantUserID(Session.userId);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    // Handle for Search
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, query, Toast.LENGTH_SHORT).show();
            if (restaurants.size() > 0) {
                restaurants.clear();
            } else {
                Log.d("REQUEST_STEP", "--- SEARCH B NOT CLEAN --- " + restaurants.size());
            }
            restaurants = innerSearch(favorites_1, query);
            setRecyclerView();
            Log.d("REQUEST_STEP", "--- SEARCH C --- " + query +
                    "\n-RAW : " + favorites_1.size() +
                    "\n-COPY : " + restaurants.size()
            );
            SearchRecentSuggestions mSearchRecentSuggestions = new SearchRecentSuggestions(this, MySuggestionProvider.AUTHORITY, MySuggestionProvider.MODE);
            mSearchRecentSuggestions.saveRecentQuery(query, null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.favorite_option_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) FavoriteRestaurantActivity.this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(FavoriteRestaurantActivity.this.getComponentName()));
            searchView.setIconifiedByDefault(true); // Do not iconify the widget; expand it by default
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.favorite_filter: {
//                DialogFragment alterDialog = new SortDialogFragment();
                DialogFragment alterDialog = new FilterDialogFragement();
                alterDialog.setCancelable(false);
                alterDialog.show(getFragmentManager(), "FILTER_FAVORITE");
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    // Sort alertDialog
    @Override
    public void OnOK(int position) {
        switch (position) {
            //order ascending
            case 0: {
                ToastMessage.mesageShort(FavoriteRestaurantActivity.this, "0");
                Collections.sort(restaurants, new RestComparator());
                setRecyclerView();
                break;
            }
            //order near by
            case 1: {
                ToastMessage.mesageShort(FavoriteRestaurantActivity.this, "1");
                Collections.sort(restaurants, new NearByComparator());
                setRecyclerView();
                break;
            }
        }
    }

    // Check Image before set into Card
    public String restImage(List<com.api.hrd.nhamey.models.Restpictures> img) {
        int size = img.size();
        String imgPath = "http://120.136.24.174:1304/resources/upload/resttype/38becb2c-68b3-4293-a524-c9f740a0d44c.png";
        if (size > 0) {
            imgPath = (img.get(0).getPath_name() + "" == "") ? imgPath : (img.get(0).getPath_name() + "");
        }
        return imgPath;
    }

    // Check Image before set into card (2)
    public String restImage_1(List<FavoriteSearch.RESTAURANT_IMAGES> img) {
        int size = img.size();
        Log.d("IMAGE", "IMAGE SIZE " + size);
        String imgPath = "http://120.136.24.174:1304/resources/upload/resttype/38becb2c-68b3-4293-a524-c9f740a0d44c.png";
        if (size > 0) {
            imgPath = (img.get(0).getIMAGE_PATH() + "" == "") ? imgPath : img.get(0).getIMAGE_PATH() + "";
        }
        return imgPath;
    }

    // Set source into list_for_recycler
    public void setRecyclerView() {
        // Set data into recycler view
        Log.d("ARR_PASS", " SET RECYCLER ");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mRecycler_view_fa);
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurants, FavoriteRestaurantActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FavoriteRestaurantActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        restaurantAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(restaurantAdapter);
    }

    // Get restaurant by user id
    public void getFavRestaurantUserID(int id) {
        if (isAccessToAPI) return;
        Log.d("REQUEST_API", "-- REQUEST BY USER ID -- " + id);
        setIsAccess(true);
        Call<JsonObject> call_id = favoritesService.getFavoriteRestaurantsByKeywork(id, PAGE_NUMBER, RECORD_MUNBER);
        call_id.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("REQUEST_API", "GET JSON BY USER ID BODY \n" + response.body().get("DATA"));
                Gson gson = new Gson();
                if (response.body() != null) {
                    favorites_1 = gson.fromJson(response.body().get("DATA"), new TypeToken<ArrayList<FavoriteSearch.DATA>>() {
                    }.getType());

                    for (int i = 0; i < favorites_1.size(); i++) {
                        // Log data which bind into arraylist
                        restaurants.add(new Restaurant(
                                favorites_1.get(i).getRESTAURANT().getRESTAURANT_ID(),
                                restImage_1(favorites_1.get(i).getRESTAURANT().getRESTAURANT_IMAGES()),
                                favorites_1.get(i).getRESTAURANT().getRESTAURANT_NAME(),
                                restTypeSet(favorites_1.get(i).getRESTAURANT().getRESTYPE()),
                                restAddreSet(favorites_1.get(i).getRESTAURANT().getADDRESS()),
                                getStringDistant(defualtLatLng,
                                        favorites_1.get(i).getRESTAURANT().getRESTAURANT_LATITUDE(),
                                        favorites_1.get(i).getRESTAURANT().getRESTAURANT_LONGITUDE())
                        ));
                    }
                    // Log whne data finished bind
                    Log.d("REQUEST_API", " BIND DATA BY USER ID SUCCESS ! " + "\n-RAW :" + favorites_1.size() + "\n-COPY : " + restaurants.size());
                    setIsAccess(false);
                    setRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("REQUEST_API", "BIND DATA BY USER ID FAIL \n" + t.getMessage());
                setIsAccess(false);
            }
        });
    }

    // Set Access Status
    private void setIsAccess(Boolean access) {
        this.isAccessToAPI = access;
    }

    @Override
    public void OnItemClickAdapter(Restaurant restaurant, int position) {
        Intent i = new Intent(FavoriteRestaurantActivity.this, Detail_Resturant.class);
        Log.e("ooo id :", restaurant.getRest_id() + " Name" + restaurant.getRest_name());
        Bundle bundle = new Bundle();
        bundle.putParcelable("RESTAURANT", restaurant);
        i.putExtras(bundle);
        startActivity(i);
    }

    // Search in List
    private ArrayList<Restaurant> innerSearch(ArrayList<FavoriteSearch.DATA> source, String query) {
        ArrayList<Restaurant> search = new ArrayList<>();

        for (FavoriteSearch.DATA rest : source) {
            if (rest.getRESTAURANT().getRESTAURANT_NAME().contains(query)) {
                Log.d("REQUEST_SEARCH", "- FOUND " + rest.getRESTAURANT().getRESTAURANT_NAME());
                search.add(
                        new Restaurant(
                                rest.getRESTAURANT().getRESTAURANT_ID(),
                                restImage_1(rest.getRESTAURANT().getRESTAURANT_IMAGES()),
                                rest.getRESTAURANT().getRESTAURANT_NAME(),
                                restTypeSet(rest.getRESTAURANT().getRESTYPE()),
                                restAddreSet(rest.getRESTAURANT().getADDRESS()),
                                getStringDistant(defualtLatLng,
                                        rest.getRESTAURANT().getRESTAURANT_LATITUDE(),
                                        rest.getRESTAURANT().getRESTAURANT_LONGITUDE())
                        ));
            }
        }
        Log.d("REQUEST_SEARCH", " -- SEARCH RESULT -- " + "\n-QUERY : " + query + "\n-SIZE " + (search != null ? (search.size()) : "0"));
        return search;
    }

    // Add string to string of Type
    public String restTypeSet(List<FavoriteSearch.RESTYPE> restypes) {
        String str = "";
        for (int i = 0; i < restypes.size(); i++) {
            str += restypes.get(i).getRESTYPE_NAME() + ((i < restypes.size() - 1) ? "" : ", ");
        }
        return str;
    }

    // Add string to string of Address
    public String restAddreSet(FavoriteSearch.ADDRESS addresses) {
        String str = "St." + addresses.getADDRESS_STREET() +
                ", " + addresses.getADDRESS_COMMUNCE() +
                ", " + addresses.getADDRESS_DISTRICT() +
                ", " + addresses.getADDRESS_PROVINCE();
        return str;
    }

    // Get distant as string I
    private String getStringDistant(String FT, String FG, String TT, String TG) {
        LatLng From = new LatLng(convS2D(FT), convS2D(FG));
        LatLng To = new LatLng(convS2D(TT), convS2D(TG));
        double Distant = getDistance(From, To);
        return formatNumber(Distant);
    }

    // Get distant as string II
    private String getStringDistant(LatLng From, String TT, String TG) {
        LatLng To = new LatLng(convS2D(TT), convS2D(TG));
        double Distant = getDistance(From, To);
        return formatNumber(Distant);
    }

    // Calculate distant
    private double getDistance(LatLng From, LatLng To) {
        return SphericalUtil.computeDistanceBetween(From, To);
    }

    // Format distant as string
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

    // Convert String to Double
    private double convS2D(String s) {
        double lt;
        try {
            lt = Double.parseDouble(s);
        } catch (Exception c) {
            lt = 0.0;
        }
        return lt;
    }

    // Sort Restaurant Name A-Z
    public class RestComparator implements Comparator<Restaurant> {
        @Override
        public int compare(Restaurant o1, Restaurant o2) {
            return o1.getRest_name().compareTo(o2.getRest_name());
        }
    }

    // Sort Restaurant Distant 1-9
    public class NearByComparator implements Comparator<Restaurant> {
        @Override
        public int compare(Restaurant o1, Restaurant o2) {
            return o1.getRest_dist().compareTo(o2.getRest_dist());
        }
    }
}
