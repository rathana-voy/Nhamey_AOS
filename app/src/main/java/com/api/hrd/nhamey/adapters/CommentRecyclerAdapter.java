package com.api.hrd.nhamey.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.models.AllCommentModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by Thyreach on 1/19/2017.
 */

public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.ViewHolder>{
    private List<AllCommentModel> allCommentlList;
    private Context mContext;

    public CommentRecyclerAdapter(Context mContext, List<AllCommentModel> allCommentlList){
        this.mContext = mContext;
        this.allCommentlList = allCommentlList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View commentCardView = inflater.inflate(R.layout.each_comment_card_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(commentCardView);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        AllCommentModel allCommentModel = allCommentlList.get(position);

        TextView textViewProfileName = viewHolder.textView_profileName;
        textViewProfileName.setText(allCommentModel.getProfileName());


        TextView textViewCommentedData = viewHolder.textView_commentData;
        textViewCommentedData.setText(allCommentModel.getCommentData());

        ImageView imageViewCommentedProfileImage = viewHolder.imageView_imageProfile;

        String imgUrl = "http://www.nham24.com/upload/1479621863-logo.jpg";
        Glide.with(mContext).load(imgUrl)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageViewCommentedProfileImage);
        Log.e("Cll away "+allCommentModel.getProfileImage(),"Call away");

    }


    @Override
    public int getItemCount() {
        return allCommentlList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView_profileName;

        public TextView textView_commentData;
        public ImageView imageView_imageProfile;

        public ViewHolder(View itemView) {
            super(itemView);

            textView_profileName = (TextView) itemView.findViewById(R.id.profile_name_commented);
            textView_commentData = (TextView) itemView.findViewById(R.id.data_commented);
            imageView_imageProfile = (ImageView) itemView.findViewById(R.id.img_profile_commented);
        }
    }
}
