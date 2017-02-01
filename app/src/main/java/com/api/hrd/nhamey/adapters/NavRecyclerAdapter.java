package com.api.hrd.nhamey.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.NavDrawer;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by rathana on 9/1/17.
 */

public class NavRecyclerAdapter extends RecyclerView.Adapter<NavRecyclerAdapter.MyHolder>{
    private ArrayList<NavDrawer> navData;
    private Context context;
    private NavEventHandler navEventHandler;
    public NavRecyclerAdapter(Context context, ArrayList<NavDrawer> navData){
        this.context=context;
        this.navData=navData;
        this.navEventHandler= (NavEventHandler) context;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_recyclerview_layout,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if(this.navData!=null){
            if(!this.navData.isEmpty()){
                holder.nav_image.setImageResource(this.navData.get(position).getNav_image());
                holder.nav_title.setText(this.navData.get(position).getNav_title());
            }
        }else{

        }
    }

    @Override
    public int getItemCount() {
        return this.navData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private ImageView nav_image;
        private TextView nav_title;
        private TextView nav_alert;
        public MyHolder(View itemView) {
            super(itemView);
            nav_image= (ImageView) itemView.findViewById(R.id.nav_image);
            nav_title= (TextView) itemView.findViewById(R.id.nav_title);
            nav_alert= (TextView) itemView.findViewById(R.id.nav_alert);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navEventHandler.OnItemClickAdapter(navData.get(getAdapterPosition()),getAdapterPosition());
                }
            });
        }
    }

    public interface NavEventHandler{
        public void OnItemClickAdapter(NavDrawer navDrawer,int position);
    }
}
