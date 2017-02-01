package com.api.hrd.nhamey.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.Pager;
import com.api.hrd.nhamey.adapters.RestaurantAdapter;
import com.api.hrd.nhamey.models.Restaurant;
import com.api.hrd.nhamey.models.Restaurants;
import com.api.hrd.nhamey.models.Restype;
import com.api.hrd.nhamey.util.GPSTracker;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.RestaurantService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import layout.CommunicatorFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Category extends AppCompatActivity implements CommunicatorFragment {

    ArrayList<Restaurant> restaurants;
    ArrayList<Restaurants> restaurants_full;
    ArrayAdapter<String> arrayAdapter;
    String[] stringsFilter;
    RestaurantService restService;
    private TabLayout tabLayout;
    private TabLayout.Tab tab;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Set Toolbar action
        Toolbar toolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Category");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.mTabCategory);
        viewPager = (ViewPager) findViewById(R.id.mPagerCategory);

        /*Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);*/

        // Set TAP for view LIST and MAP
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
//                Toast.makeText(Category.this, "---- OK ----" + tab.getPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Spinner location = (Spinner) findViewById(R.id.spinner_location);
        Spinner categpry = (Spinner) findViewById(R.id.spinner_category);

        stringsFilter = getResources().getStringArray(R.array.number_array);
        arrayAdapter = new ArrayAdapter<>(Category.this, android.R.layout.simple_spinner_dropdown_item, stringsFilter);

        location.setAdapter(arrayAdapter);
        categpry.setAdapter(arrayAdapter);

        // ---------- TEST LOCATION ONLY ----------------
        GPSTracker gpsTracker = new GPSTracker(getApplicationContext());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_category, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_location_ca:
                menuSelectColocation(tabLayout, stringsFilter, item.getTitle().toString());
                break;
            case R.id.menu_sort_ca:
                menuSelectColocation(tabLayout, stringsFilter, item.getTitle().toString());
                break;
            case R.id.menu_category_ca:
                menuSelectColocation(tabLayout, stringsFilter, item.getTitle().toString());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListClick(int position) {
        // Test when click on IMAGE in fragment in ListVIew TAP
        Toast.makeText(this, "Menu " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void checkViewCreated(Boolean created) {
        if (created) {
            // Set up page viewer for fragment
            Log.d("ARR_PASS", " PAGE VIEW SET ");
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    tab = tabLayout.getTabAt(position);
                    tab.select();
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });

            // Start to send request to server
            Log.d("ARR_PASS", " REQUEST DATA ");
            restaurants = new ArrayList<>();
            restService = ServiceGenerator.createService(RestaurantService.class);
            Call<JsonObject> callRestaurantObj = restService.getRestaurants();
            callRestaurantObj.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                    Log.d("DATA JASON", "GET \n" + response.body().get("DATA"));
                    Gson gson = new Gson();
                    restaurants_full = gson.fromJson(response.body().get("DATA"), new TypeToken<ArrayList<Restaurants>>() {
                    }.getType());
                    for (int i = 0; i < restaurants_full.size(); i++) {
                        /*restaurants.add(new Restaurant(R.drawable.pizza_margherita,
                                restaurants_full.get(i).getRest_name() + "",
                                restType(restaurants_full.get(i).getRestype()),
                                restaurants_full.get(i).getAddress().getProvince(),
                                "123 Km"));*/
                    }

                    // Log whne data finished bind
                    Log.d("ARR_PASS", " BIND DATA SUCCESS ! ");

                    // Set data into recycler view in fragment
                    Log.d("ARR_PASS", " SET RECYCLER ");
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mRecycler_view);
                    RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurants,Category.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Category.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(restaurantAdapter);

                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    // Log when data fail to bind
                    Log.d("ARR_PASS", " BIND DATA FAIL ! ");
                }
            });
        } else {
            // Log when view not found
            Log.d("ARR_PASS", " CANNOT FIND VIEW !! ");
        }
    }

    public String restType(List<Restype> type) {
        int size = type.size();
        String restType = "";
        for (int i = 0; i < size; i++) {
            restType += type.get(i).getRestype_name() + (i == size - 1 ? "" : " ,");
        }
        return restType;
    }

    public void menuSelectColocation(View view, String[] strings, String label) {
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.activity_search_location, null);

        final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        Button btnCancel = (Button) popupView.findViewById(R.id.btn_popup_cancel);
        ListView listView = (ListView) popupView.findViewById(R.id.list_view_popup);
        TextView textView = (TextView) popupView.findViewById(R.id.popup_label);
        LinearLayout backgroundClose = (LinearLayout) popupView.findViewById(R.id.activity_research_loacation);

        backgroundClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        textView.setText(label);

        strings = getResources().getStringArray(R.array.number_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strings);
        listView.setAdapter(adapter);

        btnCancel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
    }

    @Override
    public void RespondString(String data) {

    }

    @Override
    public void RespondStringArrayList(ArrayList<String> data) {

    }
}
