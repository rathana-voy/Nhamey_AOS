package com.api.hrd.nhamey.adapters;

import android.content.Context;
import android.location.Location;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.api.hrd.nhamey.models.MapPionter;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.api.hrd.nhamey.util.layout.DataAdapterProvider;

import java.util.ArrayList;

import layout.content_listview;
import layout.content_mapview;

//Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;
    int catId;
    private DataAdapterProvider<RestType.DATA> restType;
    private RestType.DATA restTypeData;
    private ArrayList<MapPionter> mapPionters;
    private Context context;
    private Location location;

    public static content_mapview tab2;
    private boolean readyBindLocation = false;

    //Constructor to the class
    public Pager(FragmentManager fm, Context context, int tabCount, RestType.DATA restTypeData) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
        this.restTypeData = restTypeData;
        this.context = context;
    }

    public Pager(FragmentManager fm, Context context, int tabCount, RestType.DATA restTypeData, Location location) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
        this.restTypeData = restTypeData;
        this.context = context;
        this.location = location;
        tab2 = new content_mapview();
        readyBindLocation = true;
    }
    public Pager(FragmentManager fm, Context context, int tabCount, RestType.DATA restTypeData, content_mapview tab2) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
        this.restTypeData = restTypeData;
        this.context = context;
        this.tab2 = tab2;
        readyBindLocation = true;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                content_listview tab1 = new content_listview();
                restType = tab1;
                tab1.setData(this.restTypeData, context, false);
                return tab1;
            case 1:
//                tab2 = new content_mapview();
//                tab2.setLocation(location);
                tab2.setData(this.restTypeData, context, false);
                Log.d("PAGE", " -- LOCATION SEND -- ");
                return tab2;
            default:
                content_listview tab3 = new content_listview();
                restType = tab3;
                tab3.setData(this.restTypeData, context, false);
                return tab3;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}