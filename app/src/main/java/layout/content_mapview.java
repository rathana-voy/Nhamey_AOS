package layout;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.MapPionter;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.api.hrd.nhamey.models.api_respone.Restaurant;
import com.api.hrd.nhamey.util.layout.DataProviderMapPage;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.RestaurantService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class content_mapview extends Fragment implements OnMapReadyCallback, DataProviderMapPage<RestType.DATA> {

    private static Location location;
    private static boolean mapReady = false;
    private static GoogleMap googleMap;
    private MapView mapView;
    private View mView;
    private ArrayList<MapPionter> mapPionters;
    private RestaurantService restaurantService;
    private ArrayList<LatLng> setOfLatlng;
    private static int CAT_ID;
    private Context context;


    public content_mapview() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_content_mapview, container, false);
        Log.d("PAGE - LOCATION", " Location INIT ");
        return mView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.googleMap = googleMap;
        reRefreshMap();

        Log.d("MARKER", "-- ON MAP READY --" + (mapReady ? " OK " : " NO "));
    }

    public void reRefreshMap(){
        if(this.googleMap == null){
            Log.d("MARKER", "-- ON MAP READY RELOAD --");
            return;
        }else {
            googleMap.clear();
        }
        LatLng hrd = new LatLng(11.5757943, 104.8869615);
        String location = new String("HRD CENTER");
        String location_description = new String("The biggest TRAINING CENTER of technology in Cambodia.");
        getRestaurants(CAT_ID);
        if (ActivityCompat.checkSelfPermission(context.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity)context.getApplicationContext(),
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    }, 10);
            return;
        }
        this.googleMap.setMyLocationEnabled(true);
        this.googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        this.googleMap.getUiSettings().setZoomControlsEnabled(true);
        this.googleMap.isIndoorEnabled();
        this.googleMap.addMarker(new MarkerOptions().position(hrd).title(location).snippet(location_description));
        CameraPosition cameraPosition = CameraPosition.builder().target(hrd).zoom(16).bearing(0).tilt(45).build();
        this.googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mapReady = true;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.mGoogleMap);

        Log.d("MARKER", "-- ON CREATED VIEW -- MAP VIEW " + (mapView != null ? " OK " : " NO "));
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void setData(RestType.DATA data, Context context, boolean isChange) {

        if (data != null) {
            Log.d("MARKER", "-- SET DATA -- CAT ID " + (data.restype_id));
            this.context = context;
            if (isChange) {
                // From Dialog
                CAT_ID = data.restype_id;
                reRefreshMap();
                Log.d("MARKER", "-- SET DATA -- CAT ID " + (CAT_ID) + " [ DIALOG ]");
            } else {
                // From Home
                CAT_ID = data.restype_id;
                Log.d("MARKER", "-- SET DATA -- CAT ID " + (CAT_ID) + " [ HOME ]");
            }
        }
        else {
            Log.d("MARKER", "-- SET DATA -- CAT ID NULL");
        }
    }

    public void setMarkerOnMap(ArrayList<MapPionter> mapPionters) {
        Log.d("MARKER", "-- SET MARKER IN MAP --" + (mapPionters != null ? " OK " : " NO "));
        if (mapPionters != null) {
            for (MapPionter pionters : mapPionters) {
                this.googleMap.addMarker(new MarkerOptions().position(new LatLng(pionters.getLatitude(), pionters.getLongitude())));
            }
            Log.d("MARKER", " RESOURCE MAP POINT SIZE " + mapPionters.size());
        } else {
            Log.d("MARKER", " RESOURCE MAP POINT NULL");
        }
    }

    protected void getRestaurants(int catId) {
        Log.d("MARKER", "-- REQUEST DATA BY ID -- CAT ID " + (catId));
        this.restaurantService = ServiceGenerator.createService(RestaurantService.class);
        Call<Restaurant> call = this.restaurantService.getRestaurantsByRestType("", catId, 1, 200);
        call.enqueue(new Callback<Restaurant>() {

            @Override
            public void onResponse(Call<com.api.hrd.nhamey.models.api_respone.Restaurant> call, Response<Restaurant> response) {
                Log.d("MARKER", "-- REQUEST START  -- ");
                if (response.body().getDATA() != null) {
                    mapPionters = new ArrayList<>();
                    setOfLatlng = new ArrayList<>();
                    for (com.api.hrd.nhamey.models.api_respone.Restaurant.DATA rest : response.body().getDATA()) {
                        mapPionters.add(new MapPionter(convS2D(rest.getLatitude()), convS2D(rest.getLongitude()), rest.getRest_name(), ""));
                        setOfLatlng.add(new LatLng(convS2D(rest.getLatitude()), convS2D(rest.getLongitude())));
                    }
                    setMarkerOnMap(mapPionters);
                    Log.d("MARKER", "-- RESOURCE READY && MAP --" + (mapReady ? " OK " : " NO ") + showMarker(mapPionters) + "" + showMarkerLT(setOfLatlng));
                } else {
                    Log.d("MARKER", "-- RESOURCE NULL --");
                }
            }

            @Override
            public void onFailure(Call<com.api.hrd.nhamey.models.api_respone.Restaurant> call, Throwable t) {
                Log.d("MARKER", " -- RESOURCE FAIL --");
            }
        });
    }

    // --- Additional Function for MAP ---
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

    // Get location
    public Location getLocation() {
        return location;
    }

    // Set location
    public void setLocation(Location location) {
        this.location = location;
    }

    // Test Name of restaurant
    public String showMarker(ArrayList<MapPionter> mapPionter) {
        String marker = "\nNAME OF PLACE: \n";
        if (mapPionter != null) {
            for (MapPionter map : mapPionter) {
                marker += "- " + map.getTitle() + "\n";
            }
        }
        return marker;
    }

    // Test Lat & Lng of restaurant
    public String showMarkerLT(ArrayList<LatLng> mapLT) {
        String marker = "\nLAT_LNG OF PLACE: \n";
        if (mapLT != null) {
            for (LatLng map : mapLT) {
                marker += "- LT " + map.latitude + ", LG " + map.longitude + "\n";
            }
        }
        return marker;
    }

    // Calculate Distant
    private double getDistance(LatLng From, LatLng To) {
        return SphericalUtil.computeDistanceBetween(From, To);
    }

    // Format number to string
    private String formatNumber(double distance) {
        String unit = "m";
        if (distance < 1) {
            distance *= 1000;
            unit = "mm";
        } else if (distance > 1000) {
            distance /= 1000;
            unit = "km";
        }

        return String.format("%4.3f%s", distance, unit);
    }
}
