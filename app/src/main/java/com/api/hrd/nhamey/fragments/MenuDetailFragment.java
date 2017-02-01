package com.api.hrd.nhamey.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.PagerAdapter_Detail_Resturant;

/**
 * Created by Thyreach on 1/9/2017.
 */
public class MenuDetailFragment extends android.support.v4.app.Fragment {

    View rootView;
    TabLayout tabLayout;
    TabLayout tabLayoutcard;
    ViewPager viewPager;
   /* private int restId;

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }
*/
    PagerAdapter_Detail_Resturant adapter;

    private FragmentActivity myContext;


   /* @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.food_and_drink_fragment, container, false);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Food"));
        tabLayout.addTab(tabLayout.newTab().setText("Drink"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        /*Log.e("oo>>>>oooo rest Id : " ,this.getRestId()+"");*/
        viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        //==== to get getSupportFragmentManger ====//
        //FragmentManager fragManager = getActivity().getSupportFragmentManager();
         adapter = new PagerAdapter_Detail_Resturant
                (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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



        return rootView;
    }

    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }*/

/*    @Override
    public void onResume() {
        super.onResume();
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    }*/

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e("onViewStateRestored","MenuDetailFragment");
        adapter = new PagerAdapter_Detail_Resturant
                (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

    }
}
