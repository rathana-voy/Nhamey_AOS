package com.api.hrd.nhamey.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.RestaurantCategoryAdapter;
import com.api.hrd.nhamey.models.AdsBanner;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.api.hrd.nhamey.util.ToastMessage;
import com.api.hrd.nhamey.util.ViewFindUtils;
import com.api.hrd.nhamey.util.BannerSlider;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.HomeApiService;
import com.flyco.banner.anim.select.ZoomInEnter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rathana on 10/1/17.
 */

public class HomeFragment extends Fragment {
    private ArrayList<AdsBanner> ads;
    private ArrayList<RestType.DATA> rests;
    private Toolbar toolbar;
    private ProgressBar restTypeProgressBar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView foodLists;
    private HomeFragmentHandler homeFragmentHandler;

    private HomeApiService.AdsBannerService adsBannerService;
    private HomeApiService.RestType restType;
    private View decorView;
    private DisplayMetrics dm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        this.adsBannerService = ServiceGenerator.createService(HomeApiService.AdsBannerService.class);
        this.restType=ServiceGenerator.createService(HomeApiService.RestType.class);
        ads=new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.from(container.getContext()).inflate(R.layout.home_fragment_layout,container,false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        foodLists= (RecyclerView) view.findViewById(R.id.v_food_list);
        restTypeProgressBar= (ProgressBar) view.findViewById(R.id.resttype_progressBar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.min_collapsing);

        homeFragmentHandler= (HomeFragmentHandler) getActivity();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        //send view to HomeActivity
        homeFragmentHandler.getViews(toolbar,null,null);

        homeFragmentHandler.DrawerToggleButtonHandle();
        restTypeProgressBar.setVisibility(ProgressBar.INVISIBLE);
        //sliderProgressBar.setVisibility(ProgressBar.INVISIBLE);

        homeFragmentHandler.adsHandling();

        //start slider
        decorView = getActivity().getWindow().getDecorView();
        dm = getResources().getDisplayMetrics();
        sib_anim();
        Log.e("ooooosize call",ads.size()+"");
        //category lists
        this.getRestType();
    }

    public interface HomeFragmentHandler extends SetToolbar{
        void adsHandling();
        void getRestTypes(List<RestType.DATA> restTypes);

    }

    private void sib_anim() {
        final BannerSlider sib= ViewFindUtils.find(decorView, R.id.ads_banner_slide);
        Call<com.api.hrd.nhamey.models.api_respone.AdsBanner> call= adsBannerService.getAdsBanners(1,10);
        call.enqueue(new Callback<com.api.hrd.nhamey.models.api_respone.AdsBanner>() {
            @Override
            public void onResponse(Call<com.api.hrd.nhamey.models.api_respone.AdsBanner> call, Response<com.api.hrd.nhamey.models.api_respone.AdsBanner> response) {

                if(response.body()!=null){
                    List<com.api.hrd.nhamey.models.api_respone.AdsBanner.DATA> data =  response.body().getDATA();

                    for(com.api.hrd.nhamey.models.api_respone.AdsBanner.DATA data1 : data){
                        AdsBanner adsBanner=new AdsBanner();
                        adsBanner.setAdsBanner_id(data1.getAdsbanner_id());
                        adsBanner.setAdsBanner_Image(ServiceGenerator.ApiBaseUrl+data1.getAdsbanner_image());
                        ads.add(adsBanner);
                        Log.e("ooooo",data1.getAdsbanner_image());
                    }
                    Log.e("ooooosize",ads.size()+"");
                    //set data to slider
                    sib
                            .setSelectAnimClass(ZoomInEnter.class)
                            .setSource(ads)
                            .startScroll();
                }

            }

            @Override
            public void onFailure(Call<com.api.hrd.nhamey.models.api_respone.AdsBanner> call, Throwable t) {
                Log.e("oooooError",t.toString());
            }

        });

        sib.setOnItemClickL(new BannerSlider.OnItemClickL() {
            @Override
            public void onItemClick(int position) {
                ToastMessage.mesageShort(getActivity(),"position --> "+ ads.get(position).getAdsBanner_id());
            }
        });
    }

    protected void getRestType(){
        restTypeProgressBar.setVisibility(ProgressBar.VISIBLE);
        Call<RestType> call=restType.getRestType("",1,100);
        call.enqueue(new Callback<RestType>() {
            @Override
            public void onResponse(Call<RestType> call, Response<RestType> response) {
                if(response.body()!=null){
                    rests = (ArrayList<RestType.DATA>) response.body().getDATA();
                   /* for(RestType.DATA d :data) {
                        HomeFragment.this.rests.add(new com.api.hrd.nhamey.models.RestType(d.getRestype_name(),d.getRestype_picture()));
                        Log.d("ooooorest data", d.getRestype_picture());
                    }*/
                    Log.e("size ooom" ,HomeFragment.this.rests.size()+"");
                }else {
                    Log.d("ooooorest data is empty","data is empty");
                }
                restTypeProgressBar.setVisibility(ProgressBar.INVISIBLE);

                if(rests==null) {
                    rests=new ArrayList();
                }
                homeFragmentHandler.getRestTypes(rests);
                //int columns = getResources().getInteger(R.integer.gallery_columns);
                RestaurantCategoryAdapter restTypeAdapter = new RestaurantCategoryAdapter(rests, getActivity());
                foodLists.setAdapter(restTypeAdapter);
                //GridAutofitLayoutManager gridLayoutManager=new GridAutofitLayoutManager(getActivity(),200);
                foodLists.setLayoutManager(new GridLayoutManager(getActivity(), getResources().getInteger(R.integer.gallery_columns)));
                //foodLists.addItemDecoration(new GridSpacingItemDecoration(3,20,false));

            }
            @Override
            public void onFailure(Call<RestType> call, Throwable t) {
                Log.e("ooooorest Error",t.toString());
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.home_option_menu,menu);
    }

}
