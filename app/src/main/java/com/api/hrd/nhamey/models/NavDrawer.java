package com.api.hrd.nhamey.models;

/**
 * Created by rathana on 9/1/17.
 */

public class NavDrawer {
    private int nav_image;
    private String nav_title;

    public NavDrawer(){}
    public NavDrawer(int image,String title){
        this.nav_image=image;this.nav_title=title;
    }

    public String getNav_title() {
        return nav_title;
    }

    public void setNav_title(String nav_title) {
        this.nav_title = nav_title;
    }

    public int getNav_image() {
        return nav_image;
    }

    public void setNav_image(int nav_image) {
        this.nav_image = nav_image;
    }

}
