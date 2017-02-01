package com.api.hrd.nhamey.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.hrd.nhamey.R;
import com.api.hrd.nhamey.adapters.NavRecyclerAdapter;
import com.api.hrd.nhamey.adapters.RestaurantAdapter;
import com.api.hrd.nhamey.adapters.RestaurantCategoryAdapter;
import com.api.hrd.nhamey.adapters.SamplePagerAdapter;
import com.api.hrd.nhamey.dialogs.RestaurantCategoryDiaglogFragment;
import com.api.hrd.nhamey.fragments.LoginFragment;
import com.api.hrd.nhamey.fragments.FavoriteFragment;
import com.api.hrd.nhamey.fragments.GoogleFragment;
import com.api.hrd.nhamey.fragments.HomeFragment;
import com.api.hrd.nhamey.fragments.LoginFragment;
import com.api.hrd.nhamey.fragments.RestaurantFragment;
import com.api.hrd.nhamey.fragments.ReviewFragment;
import com.api.hrd.nhamey.models.AdsBanner;
import com.api.hrd.nhamey.models.NavDrawer;
import com.api.hrd.nhamey.models.User;
import com.api.hrd.nhamey.models.api_respone.RestType;
import com.api.hrd.nhamey.models.api_respone.Restaurant;
import com.api.hrd.nhamey.util.ToastMessage;
import com.api.hrd.nhamey.util.layout.DataUserLoginHandler;
import com.api.hrd.nhamey.util.seccion.Session;
import com.api.hrd.nhamey.webservice.generators.ServiceGenerator;
import com.api.hrd.nhamey.webservice.services.RestaurantService;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import layout.CommunicatorFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements SamplePagerAdapter.CallBack,
        NavRecyclerAdapter.NavEventHandler,
        HomeFragment.HomeFragmentHandler,
        FavoriteFragment.FavoriteFragmentHandler,
        RestaurantCategoryAdapter.RestTypeRecyclerHandler,
        LoginFragment.LoginFragmentHandler,
        RestaurantFragment.RestaurantFragmentHandler,
        CommunicatorFragment,
        RestaurantCategoryDiaglogFragment.CategoryOptionHandler

{
    private ArrayList<RestType.DATA> restTypes=new ArrayList<>();
    private ArrayList<AdsBanner> ads=new ArrayList<>();
    private ArrayList<NavDrawer> navs=new ArrayList<>();
    private RestType.DATA restType;
    private RestaurantService restaurantService;
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;


    //code request
    public final static int FAVORITE_NOT_LOGIN_REQUEST=0;
    public final static int LOGIN_SUCCESS_REQUEST=1;

    private ViewPager viewPager;
    private TabLayout.Tab tab;
    private TabLayout tabLayout;
    private ImageView ivUserProfile;
    private TextView tvUserEmail;
    private TextView tvUserName;

    private NavRecyclerAdapter navRecyclerAdapter;
    Fragment fragment;
    private View decorView;
    private DisplayMetrics dm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //setSupportActionBar(toolbar);
        restaurantService= ServiceGenerator.createService(RestaurantService.class);
        //navigation drawer
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.nav_recycler_view);
        this.ivUserProfile= (ImageView) findViewById(R.id.image_profile_nav);
        this.tvUserEmail= (TextView) findViewById(R.id.tv_user_email_nav);
        this.tvUserName= (TextView) findViewById(R.id.tv_user_name_nav);

        navRecyclerAdapter=new NavRecyclerAdapter(this,navs);
        recyclerView.setAdapter(navRecyclerAdapter);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);

        navs.add(new NavDrawer(R.drawable.home,"Home"));
        navs.add(new NavDrawer(R.drawable.heart,"Favorite"));
        navs.add(new NavDrawer(R.drawable.customer_reviews,"Review restaurant"));
        Session.readUserSession(HomeActivity.this);
        if(Session.userId==0) {
            navs.add(new NavDrawer(R.drawable.sign_in, "Login"));
            navs.add(new NavDrawer(R.drawable.registered,"Register"));
        }else{
            navs.add(new NavDrawer(R.drawable.sign_in, "Logout"));
        }
        navRecyclerAdapter.notifyDataSetChanged();



        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);// Drawer object Assigned to the view
        mDrawerToggle = setupDrawerToggle();
        // Drawer Toggle Object Made
        mDrawerLayout.addDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();

        FragmentManager fragmentManager=getFragmentManager();
        fragment=fragmentManager.findFragmentByTag("HOME");
        if(fragment!=null){
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.flContent,fragment).commit();
        }else{
            HomeFragment homeFragment=new HomeFragment();
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.replace(R.id.flContent,homeFragment).commit();
        }

    }

    /*public void getRestaurant(int restTypeId){
        Call<Restaurant> call=this.restaurantService.getRestaurantsByRestType("",restTypeId,1,200);
        call.enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                Log.d("oooooooooo",response.body().getDATA().get(0).getRest_name()+"");
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {

            }
        });
    }*/
    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(HomeActivity.this, mDrawerLayout, toolbar, R.string.openDrawer,  R.string.closeDrawer);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    //ads handling
    @Override
    public void onItemClick(int position) {
        switch (position){
            case 0: ToastMessage.mesageShort(HomeActivity.this,"click pos : " +position);break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.home_option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()){
            case R.id.favorite:{
                Session.readUserSession(HomeActivity.this);
                if(Session.userId==0){
                    Intent intent = new Intent(HomeActivity.this, FavoriteRestaurantNotLoginActivity.class);
                    startActivityForResult(intent,FAVORITE_NOT_LOGIN_REQUEST);
                }else {
                    Intent intent = new Intent(HomeActivity.this, FavoriteRestaurantActivity.class);
                    startActivity(intent);
                }
                break;
            }
            case R.id.action_location:{
                Intent intent=new Intent(HomeActivity.this,LocationSearchActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.action_rest_category:{

                FragmentManager fm = getFragmentManager();
                RestaurantCategoryDiaglogFragment dialog=RestaurantCategoryDiaglogFragment
                        .newInstance("choose categories" ,this.restTypes);
                dialog.show(fm,"CATEGORY");
                break;
            }

        }
        return true;
    }

    //handle event navigation drawer item
    @Override
    public void OnItemClickAdapter(NavDrawer navDrawer,int position) {
        Fragment fragment = null;
        Class fragmentClass = null;
        String fragName=null;
        Log.e("navs size ",this.navs.size()+"");

        switch (position){
            case 0:{
                fragmentClass = HomeFragment.class;
                fragName="HOME";
                break;
            }
            case 1:{
                Session.readUserSession(HomeActivity.this);
                if (Session.userId != 0) {
                    Intent intent = new Intent(HomeActivity.this, FavoriteRestaurantActivity.class);
                    intent.putExtra("NAV_TITLE", navDrawer.getNav_title());
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(HomeActivity.this, FavoriteRestaurantNotLoginActivity.class);
                    startActivityForResult(intent,FAVORITE_NOT_LOGIN_REQUEST);
                }
                break;
            }
            case 2:{
                fragmentClass=ReviewFragment.class;
                fragName="REVIEW";
                break;
            }
            case 3:{
                Session.readUserSession(HomeActivity.this);
                if (Session.userId == 0) {
                    fragmentClass=LoginFragment.class;
                    fragName="LOGIN";

                    Glide.with(HomeActivity.this)
                            .load(R.drawable.user_f)
                            .crossFade()
                            .into(ivUserProfile);

                    this.tvUserName.setText("");
                    this.tvUserEmail.setText("");

                }else {
                    Session.clearSession();
                    //change to login when user  logout
                    navs.set(3,new NavDrawer(R.drawable.sign_in, "Login"));
                    this.navRecyclerAdapter.notifyItemChanged(3);
                    navs.add(new NavDrawer(R.drawable.registered,"Register"));
                    this.navRecyclerAdapter.notifyItemInserted(this.navs.size()-1);
                    fragmentClass = HomeFragment.class;
                    fragName="HOME";
                }

                break;
            }
            case 4:{
                Intent intent =new Intent(HomeActivity.this,SignupActivity.class);
                intent.putExtra("NAV_TITLE",navDrawer.getNav_title());
                startActivity(intent);
                break;
            }
        }
        if(fragmentClass!=null) {
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(fragment!=null) {
            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment,fragName).commit();

            // Set action bar title
            setTitle(navDrawer.getNav_title());

        }

        // Close the navigation drawer
        mDrawerLayout.closeDrawers();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("oooooo no result" ,"favorite request");
        if(requestCode==FAVORITE_NOT_LOGIN_REQUEST){
            if(resultCode==RESULT_OK){

                LoginFragment loginFragment=new LoginFragment();
                getFragmentManager().beginTransaction().replace(R.id.flContent,loginFragment,"LOGIN").commit();

            }
        }

        if(requestCode==LOGIN_SUCCESS_REQUEST){
            if(resultCode==RESULT_OK){
                HomeFragment homeFragment=new HomeFragment();
                getFragmentManager().beginTransaction().replace(R.id.flContent,homeFragment,"HOME").commit();

            }
        }

    }

    @Override
    public void adsHandling() {
        //sib_anim();
    }
//get restType when user click

    @Override
    public void getRestTypes(List<RestType.DATA> restTypes) {
        this.restTypes= (ArrayList<RestType.DATA>) restTypes;
    }


    @Override
    public void getViews(View... views) {
        this.toolbar= (Toolbar) views[0];
        this.tabLayout= (TabLayout) views[1];
        this.viewPager = (ViewPager) views[2];
    }
    @Override
    public void getViews(TabLayout.Tab tab) {
        this.tab = tab;
    }
    @Override
    public void DrawerToggleButtonHandle() {
        this.setDrawerToogle();
    }

    public void setDrawerToogle(){
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);// Drawer object Assigned to the view
        mDrawerToggle = setupDrawerToggle();
        // Drawer Toggle Object Made
        mDrawerLayout.addDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();
    }

    //resttype click
    @Override
    public void cardOnClickL(int position) {
        /*RestaurantFragment resFragment=(RestaurantFragment) getFragmentManager().findFragmentByTag("RESTAURANT");
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        if(resFragment!=null){
            resFragment.setRestType(this.restTypes.get(position));
            transaction.replace(R.id.flContent,resFragment,"RESTAURANT");
            transaction.addToBackStack(null).commit();
            Log.e("fragment !null" ,"OK");
        }else {
            RestaurantFragment restaurantFragment =new RestaurantFragment();
            restaurantFragment.setRestType(this.restTypes.get(position));
            transaction.replace(R.id.flContent,restaurantFragment,"RESTAURANT");
            transaction.addToBackStack(null).commit();

        }*/

        if(restTypes!=null){
            restType=restTypes.get(position);
        }
        //ToastMessage.mesageShort(HomeActivity.this,""+position);
        Intent i = new Intent(HomeActivity.this,RestaurantActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable("REST_TYPE", this.restTypes.get(position));
        i.putExtras(bundle);
        startActivity(i);
    }

    @Override
    public void getRestTypeIDHandler(int id) {

    }


    @Override
    public void onListClick(int position) {

    }

    @Override
    public void checkViewCreated(Boolean created) {

    }

    @Override
    public void RespondString(String data) {

    }

    @Override
    public void RespondStringArrayList(ArrayList<String> data) {

    }


    /*public void getRestaurant(int restTypeId){
        final ArrayList<com.api.hrd.nhamey.models.Restaurant> restaurants =new ArrayList<>();
        Call<Restaurant> call=this.restaurantService.getRestaurantsByRestType("",restTypeId,1,200);
        call.enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                String image_url = null;
                if(response.body().getDATA()!=null) {
                    for (Restaurant.DATA rest : response.body().getDATA()) {

                        if (rest.getRestpictures().get(0) != null ) {
                            image_url = rest.getRestpictures().get(0).getPath_name();
                        } else {
                            image_url = "http://120.136.24.174:1304/resources/upload/resttype/38becb2c-68b3-4293-a524-c9f740a0d44c.png";
                        }

                        restaurants.add(new com.api.hrd.nhamey.models.Restaurant(
                                image_url,
                                rest.getRest_name()  != null  ? rest.getRest_name() + "" : "",
                                rest.getRestype()  != null  ? rest.getRestype() + "" : "",
                                rest.getAddress()  != null  ? rest.getAddress() + "" : "",
                                "1.2K"));
                    }

                }
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {

            }
        });
    }*/


    //get restType from category option menu
    @Override
    public void getRestType(RestType.DATA restType) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ooooo home"," resume");
        Session.readUserSession(this);

        if(Session.userId!=0){

            // set user info
            String userProgile=null;
            if(Session.userImageProfile==null){
                if(Session.userGender.equalsIgnoreCase("male")){
                    Glide.with(HomeActivity.this)
                            .load(R.drawable.user_m)
                            .crossFade()
                            .into(ivUserProfile);
                }else{
                    Glide.with(HomeActivity.this)
                            .load(R.drawable.user_f)
                            .crossFade()
                            .into(ivUserProfile);
                }

            }else{
                Glide.with(HomeActivity.this)
                        .load(Session.userImageProfile)
                        .override(600, 200)
                        .crossFade()
                        .into(ivUserProfile);
            }

            this.tvUserName.setText(Session.userName);
            this.tvUserEmail.setText(Session.userEmail);

            navs.set(3,new NavDrawer(R.drawable.sign_in, "Logout"));
            this.navRecyclerAdapter.notifyItemChanged(3);
                if(navs.size()==5){
                    navs.remove(4);
                    this.navRecyclerAdapter.notifyItemRemoved(4);
                }
        }
    }

}

