package com.api.hrd.nhamey.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.FoodInfo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by Thyreach on 1/10/2017.
 */

public class FoodMenuRecyclerAdapter extends RecyclerView.Adapter<FoodMenuRecyclerAdapter.ViewHolder> {
    private List<FoodInfo> foodInfoList;
    private Context mContext;
   private DetailEachFood detailEachFood;



    @Override
    public FoodMenuRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View foodInfoView = inflater.inflate(R.layout.card_food_detail, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(foodInfoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodMenuRecyclerAdapter.ViewHolder viewHolder, final int position) {

        // Get the data model based on position
        FoodInfo foodinfo = foodInfoList.get(position);

        // Set item views based on your views and data model
        TextView textViewName = viewHolder.foodName;
        textViewName.setText(foodinfo.getFood_name());

        TextView textViewDes = viewHolder.foodDes;
        textViewDes.setText(foodinfo.getFood_des());

        TextView textViewPrice = viewHolder.foodPrice;
        textViewPrice.setText("$"+foodinfo.getFood_price());

        ImageView imageViewFood = viewHolder.foodImage;
        String imgUrl = foodinfo.getFood_image().toString();
        Glide.with(mContext).load(imgUrl)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageViewFood);
    }

    @Override
    public int getItemCount() {
        return foodInfoList.size();
    }


//Class ViewHolder =============

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView foodName;
        public TextView foodDes;
        public TextView foodPrice;
        public ImageView foodImage;

        public ViewHolder(View itemView){
            super(itemView);


            foodName = (TextView) itemView.findViewById(R.id.food_name);
            foodDes = (TextView) itemView.findViewById(R.id.food_description);
            foodPrice = (TextView) itemView.findViewById(R.id.food_price);
            foodImage = (ImageView) itemView.findViewById(R.id.food_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    detailEachFood.showFoodDetail(foodInfoList.get(getAdapterPosition()), getAdapterPosition());
                    //Toast.makeText(getContext(),"Te....",Toast.LENGTH_LONG);
                }
            });
        }

    }



    public FoodMenuRecyclerAdapter(Context context, List<FoodInfo> foodinfo){
        mContext = context;
        foodInfoList = foodinfo;
        this.detailEachFood = (DetailEachFood) context;

    }
    //easy access context obj in recyclerview
    private Context getContext() {
        return mContext;
    }
    public interface DetailEachFood{
        public void showFoodDetail(FoodInfo foodInfo, int position);
    }
}

