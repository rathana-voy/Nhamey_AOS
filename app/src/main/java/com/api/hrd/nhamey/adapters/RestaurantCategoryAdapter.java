package com.api.hrd.nhamey.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.Food;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by RATHANA on 04-Jan-17.
 */

public class RestaurantCategoryAdapter extends RecyclerView.Adapter<RestaurantCategoryAdapter.MyViewHolder>{

    private ArrayList<RestType.DATA> restTypes;
    private Context context;
    private RestTypeRecyclerHandler restTypeRecyclerHandler;
    public RestaurantCategoryAdapter(ArrayList restTypes , Context context){
        this.restTypes=restTypes;
        this.context=context;
        this.restTypeRecyclerHandler = (RestTypeRecyclerHandler) context;
        Log.e("size" ,this.restTypes.size()+"");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rest_cateogory,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if(this.restTypes!=null) {

            Glide.with(context)
                    .load(this.restTypes.get(position).getRestype_picture())
                    .override(600, 200)
                    .crossFade()
                    .into(holder.v_food_image);

            //holder.v_food_image.setImageResource(R.drawable.pizza_margherita);
            holder.tv_food_title.setText(this.restTypes.get(position).getRestype_name());
        }
    }

    @Override
    public int getItemCount() {
        return this.restTypes.size();
    }

    protected  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView v_food_image;
        private TextView tv_food_title;
        public MyViewHolder(View itemView) {
            super(itemView);
            v_food_image = (ImageView) itemView.findViewById(R.id.iv_food_image);
            tv_food_title= (TextView) itemView.findViewById(R.id.tv_food_title);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            restTypeRecyclerHandler.cardOnClickL(getAdapterPosition());
        }
    }

    public interface RestTypeRecyclerHandler{
        public void cardOnClickL(int position);
    }
}
