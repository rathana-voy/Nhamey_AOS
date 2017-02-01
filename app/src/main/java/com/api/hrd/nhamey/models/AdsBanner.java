package com.api.hrd.nhamey.models;

/**
 * Created by RATHANA on 09-Jan-17.
 */

public class AdsBanner {
    private int adsBanner_id;
    private String adsBanner_Image;
    private String adsBanner_Url;
    private int adsBanner_resource;

    public AdsBanner(){}
    public AdsBanner(int resource){
        this.adsBanner_resource=resource;
    }
    public AdsBanner(String image_url){
        this.adsBanner_Image=image_url;
    }

    public int getAdsBanner_id() {
        return adsBanner_id;
    }

    public void setAdsBanner_id(int adsBanner_id) {
        this.adsBanner_id = adsBanner_id;
    }

    public String getAdsBanner_Image() {
        return adsBanner_Image;
    }

    public void setAdsBanner_Image(String adsBanner_Image) {
        this.adsBanner_Image = adsBanner_Image;
    }

    public String getAdsBanner_Url() {
        return adsBanner_Url;
    }

    public void setAdsBanner_Url(String adsBanner_Url) {
        this.adsBanner_Url = adsBanner_Url;
    }

    public int getAdsBanner_resource() {
        return adsBanner_resource;
    }

    public void setAdsBanner_resource(int adsBanner_resource) {
        this.adsBanner_resource = adsBanner_resource;
    }
}

