package com.api.hrd.nhamey.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.CommentRecyclerAdapter;
import com.api.hrd.nhamey.models.AllCommentModel;
import com.api.hrd.nhamey.models.api_respone.Comment_Respone;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.CommendService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rathana on 10/1/17.
 */

public class ReviewFragment extends android.support.v4.app.Fragment {
    RecyclerView recyclerView;
    ArrayList<AllCommentModel> allcommentArrayList = new ArrayList<>();
    CommentRecyclerAdapter commentRecyclerAdapter;
     EditText editText;
     Button button;
    /*Api*/
    CommendService requestCommentService = ServiceGenerator.createService(CommendService.class);
    List<Comment_Respone.DATA> commentData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.review_fragment_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_allcomment);

        //================================



        button = (Button) rootView.findViewById(R.id.button);
        editText = (EditText) rootView.findViewById(R.id.editText2
        );
        button.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                   /* if (editText.getText().toString().length()!=0){
                            button.setEnabled(true);
                    }*/
                checkFieldsForEmptyValues();
            }
        });

        //=================================
        checkFieldsForEmptyValues();
        return rootView;


    }
    void checkFieldsForEmptyValues(){

        String s1 = editText.getText().toString();

        if(s1.equals("")){
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reqeustCommentByRestaurant();
    }

    public void reqeustCommentByRestaurant(){
        Call<Comment_Respone> call = requestCommentService.getCommentByRestaurant(2);
        call.enqueue(new Callback<Comment_Respone>() {
            @Override
            public void onResponse(Call<Comment_Respone> call, Response<Comment_Respone> response) {

                if (response.body()!= null){
                    commentData = response.body().getDATA();
                    /*Log.e("is is is",""+ response.body().getCODE().toString());*/

                 allcommentArrayList.clear();
                 for (int i = 0; i < commentData.size(); i++) {
                          allcommentArrayList.add(new AllCommentModel(commentData.get(i).getUser().getFirst_name()+" "+commentData.get(i).getUser().getLast_name(),commentData.get(i).getComment(), commentData.get(i).getUser().getPicture()));
                    // Log.e(">>>> data is",""+allcommentArrayList.get(i).getProfileName()+" "+allcommentArrayList.get(i).getCommentData()+" "+allcommentArrayList.get(i).getProfileImage());
                }
                    Log.e("ListReviewFragmen >>>",""+allcommentArrayList.size());
                    commentRecyclerAdapter = new CommentRecyclerAdapter(getActivity().getApplicationContext(),allcommentArrayList);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(commentRecyclerAdapter);
               /* commentRecyclerAdapter = new CommentRecyclerAdapter(getActivity().getApplicationContext(),allcommentArrayList);
                recyclerView.setAdapter(commentRecyclerAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));*/

                }

            }



            @Override
            public void onFailure(Call<Comment_Respone> call, Throwable t) {
                    Log.e("onFailure","ReviewFragment-> resquestCommentById");
            }
        });

    }


}
