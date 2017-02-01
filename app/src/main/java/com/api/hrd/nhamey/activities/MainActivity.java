package com.api.hrd.nhamey.activities;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.NavRecyclerAdapter;
import com.api.hrd.nhamey.models.NavDrawer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavRecyclerAdapter.NavEventHandler{

    private ArrayList<NavDrawer> navs=new ArrayList<>();

    protected static int position;
    protected DrawerLayout mDrawer;
    protected CoordinatorLayout coordinatorLayout;

    private static boolean isLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawer= (DrawerLayout) findViewById(R.id.drawer_layout);
        coordinatorLayout= (CoordinatorLayout) findViewById(R.id.inflate_layout);

        //navigation drawer
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.nav_recycler_base_activity);

        navs.add(new NavDrawer(R.drawable.home,"Home"));
        navs.add(new NavDrawer(R.drawable.favorite,"Favorite"));
        navs.add(new NavDrawer(R.drawable.consulting_message,"Review restaurant"));
        navs.add(new NavDrawer(R.drawable.facebook,"Login with Facebook"));
        navs.add(new NavDrawer(R.drawable.google_plus,"Login with Google"));
        navs.add(new NavDrawer(R.drawable.register,"Register"));

        NavRecyclerAdapter adapter=new NavRecyclerAdapter(this,navs);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);

        //start home active
        if(isLaunch){
            isLaunch=false;
            if(position!=0){
                openActivity(position);
            }else openActivity(0);
            this.finish();
        }

    }

    @Override
    public void OnItemClickAdapter(NavDrawer navDrawer, int position) {
        openActivity(position);

    }

    protected void openActivity(int position){

        MainActivity.position=position;
        switch (position){
            case 0:{
                 startActivity(new Intent(MainActivity.this,TestActivity.class));
                break;
            }
            case 1:{
                startActivity(new Intent(MainActivity.this,NextActivity.class));
                break;
            }
            case 2:{

                break;
            }
            case 3:{

                break;
            }
            case 4:{

                break;
            }
            case 5:{

                break;
            }

        }
        //after click on item drawer close
        mDrawer.closeDrawers();
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!isLaunch){
            isLaunch=true;
        }
    }
}
