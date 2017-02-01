package com.api.hrd.nhamey.adapters;

/**
 * Created by Thyreach on 1/18/2017.
 */

/*****public class PagerAdapterForCardDetailResturant extends FragmentStatePagerAdapter {*/

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by Thyreach on 1/9/2017.
 */

public class PagerAdapterForCardDetailResturant extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterForCardDetailResturant(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Log.e("???",">>>>>>>>>>>>>>>");
                return null;
            case 1:
                Log.e("????",">>>>>>>>>>>>>>>");
                return null;
            case 2:
                Log.e("?????",">>>>>>>>>>>>>>>");
                return null;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}