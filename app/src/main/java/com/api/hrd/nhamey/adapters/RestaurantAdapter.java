package com.api.hrd.nhamey.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.Address;
import com.api.hrd.nhamey.models.Restaurant;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {

    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    private Context context;
    private CardEventHandler cardEventHandler;
    public RestaurantAdapter(ArrayList<Restaurant> restaurants , Context context) {
        this.restaurants = restaurants;
        this.cardEventHandler= (CardEventHandler) context;
        this.context=context;
        Log.e("ooooooo restserser",this.restaurants.size()+"");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_restaurant_ca, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //holder.rest_image.setImageResource(restaurants.get(position).getImage());

        Glide.with(context)
                .load(restaurants.get(position).getImage())
                .override(600, 200)
                .crossFade()
                .into(holder.rest_image);
        holder.rest_name.setText(restaurants.get(position).getRest_name());
        holder.rest_type.setText(restaurants.get(position).getRest_type());
        holder.rest_addr.setText(restaurants.get(position).getRest_addr());
        holder.rest_dist.setText(restaurants.get(position).getRest_dist());

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    private String getFullAddress(Address address) {
        String addr = "st. " + address.getStreet() + ", " + address.getCommunce() + ", " + address.getDistrict() + ", " + address.getProvince();
        return addr;
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView rest_image;
        private TextView rest_name;
        private TextView rest_type;
        private TextView rest_addr;
        private TextView rest_dist;

        public MyViewHolder(final View itemView) {
            super(itemView);
            rest_image = (ImageView) itemView.findViewById(R.id.imageView_restaurant);
            rest_name = (TextView) itemView.findViewById(R.id.textView_restaurant_name);
            rest_type = (TextView) itemView.findViewById(R.id.textView_restaurant_type);
            rest_addr = (TextView) itemView.findViewById(R.id.textView_restaurant_address);
            rest_dist = (TextView) itemView.findViewById(R.id.textView_restaurant_distant);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cardEventHandler.OnItemClickAdapter(restaurants.get(getAdapterPosition()), getAdapterPosition());
                    //Toast.makeText(context, "click card !" + restaurants.get(getAdapterPosition()).getRest_id() , Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "cick", Toast.LENGTH_LONG).show();
        }
    }

    public interface CardEventHandler{
        public void OnItemClickAdapter(Restaurant restaurant, int position);
    }

}
