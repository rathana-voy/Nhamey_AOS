package com.api.hrd.nhamey.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.AdsBanner;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class SamplePagerAdapter extends PagerAdapter {

    private ArrayList<AdsBanner> ads;
    private CallBack callBack;
    private Context context;
    private final Random random = new Random();
    private int mSize;
    public SamplePagerAdapter(Context context,ArrayList<AdsBanner> ads) {
        this.callBack= (CallBack) context;
        this.context=context;
        this.ads=ads;
        mSize = ads.size();
    }

    public SamplePagerAdapter(Context context,ArrayList<AdsBanner> ads,int count) {
        mSize = count;
        this.context=context;
        this.callBack= (CallBack) context;
        this.ads=ads;
    }

    @Override
    public int getCount() {
        return mSize;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        /*TextView textView = new TextView(view.getContext());
        textView.setText(String.valueOf(position + 1));
        textView.setBackgroundColor(0xff000000 | random.nextInt(0x00ffffff));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(48);*/
        ImageView image =new ImageView(view.getContext());
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.addView(image, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        Picasso.with(this.context)
                .load(ads.get(position).getAdsBanner_resource())
                .fit()
                .into(image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClick(position);
            }
        });
        return image;
    }

    public void addItem() {
        mSize++;
        notifyDataSetChanged();
    }

    public void removeItem() {
        mSize--;
        mSize = mSize < 0 ? 0 : mSize;

        notifyDataSetChanged();
    }

    public interface CallBack{
        public void onItemClick(int position);
    }
}