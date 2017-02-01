package com.api.hrd.nhamey.util;

import android.support.v4.view.ViewPager;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.AdsBanner;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.flyco.banner.transform.DepthTransformer;
import com.flyco.banner.transform.FadeSlideTransformer;
import com.flyco.banner.transform.FlowTransformer;
import com.flyco.banner.transform.RotateDownTransformer;
import com.flyco.banner.transform.RotateUpTransformer;
import com.flyco.banner.transform.ZoomOutSlideTransformer;

import java.util.ArrayList;

/**
 * Created by RATHANA on 14-Jan-17.
 */

public class DataProvider {
    //public static String[] urls = new String[]{};
    public static String[] urls=new String[]{
            ServiceGenerator.ApiBaseUrl+"/resources/upload/ads/ad3e7f31-ec8d-41a9-9a53-2a99744f5d60.png",
            ServiceGenerator.ApiBaseUrl+"/resources/upload/ads/42fbe53f-6c1d-41e5-8766-4db54bede40e.png"
    };

    public static ArrayList<AdsBanner> getList() {
        ArrayList<AdsBanner> list = new ArrayList<>();
        for (int i = 0; i < urls.length; i++) {
            AdsBanner item = new AdsBanner();
            item.setAdsBanner_Image(urls[i]);
            list.add(item);
        }

        return list;
    }
    public static ArrayList<Integer> getUserGuides() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.food);
        list.add(R.drawable.food_2);
        list.add(R.drawable.food_3);
        list.add(R.drawable.food_4);

        return list;
    }
    public static Class<? extends ViewPager.PageTransformer> transformers[] = new Class[]{
            DepthTransformer.class,
            FadeSlideTransformer.class,
            FlowTransformer.class,
            RotateDownTransformer.class,
            RotateUpTransformer.class,
            ZoomOutSlideTransformer.class,
    };


}
