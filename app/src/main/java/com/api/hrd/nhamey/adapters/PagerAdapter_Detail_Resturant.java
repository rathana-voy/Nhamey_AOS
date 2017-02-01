package com.api.hrd.nhamey.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.api.hrd.nhamey.fragments.DrinkMenuFragment;
import com.api.hrd.nhamey.fragments.FoodMenuFragment;

/**
 * Created by Thyreach on 1/9/2017.
 */

public class PagerAdapter_Detail_Resturant extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    private int restId;
    FoodMenuFragment foodTap = new FoodMenuFragment();

    DrinkMenuFragment drinkTap = new DrinkMenuFragment();

   // FoodMenuFragment foodMenuFragment = new FoodMenuFragment();

    public PagerAdapter_Detail_Resturant(FragmentManager fm, int NumOfTabs) {
        super(fm);
       /* this.restId=restId;*/
        this.mNumOfTabs = NumOfTabs;
    }

    /*@Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FoodMenuFragment foodTap = new FoodMenuFragment();
                return foodTap;
            case 1:
                DrinkMenuFragment drinkTap = new DrinkMenuFragment();
                return drinkTap;

            default:
                return null;
        }
    }*/

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                //foodMenuFragment.setRestIdFromActivity();
                FoodMenuFragment foodFrag= new FoodMenuFragment();
              /*  foodFrag.setRestId(this.restId);*/
                return foodFrag;
            case 1:
                DrinkMenuFragment drinkMenuFrag=new DrinkMenuFragment();
                /*drinkMenuFrag.setRestId(this.restId);*/
                return drinkMenuFrag;

            default:
                return null;
        }
    }

}