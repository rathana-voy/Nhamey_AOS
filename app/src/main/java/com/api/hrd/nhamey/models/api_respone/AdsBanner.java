package com.api.hrd.nhamey.models.api_respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by RATHANA on 15-Jan-17.
 */

public class AdsBanner {

    @SerializedName("MESSAGE")
    public String MESSAGE;
    @SerializedName("CODE")
    public String CODE;
    @SerializedName("STATUS")
    public boolean STATUS;
    @SerializedName("DATA")
    public List<DATA> DATA;
    @SerializedName("PAGINATION")
    public PAGINATION PAGINATION;



    public static class DATA {
        @SerializedName("adsbanner_id")
        public int adsbanner_id;
        @SerializedName("adsbanner_image")
        public String adsbanner_image;
        @SerializedName("adsbanner_url")
        public String adsbanner_url;
        @SerializedName("date_added")
        public String date_added;
        @SerializedName("date_modify")
        public String date_modify;
        @SerializedName("adsbanner_image_path")
        public String adsbanner_image_path;
        @SerializedName("adsbanner_image_name")
        public String adsbanner_image_name;

        public int getAdsbanner_id() {
            return adsbanner_id;
        }

        public void setAdsbanner_id(int adsbanner_id) {
            this.adsbanner_id = adsbanner_id;
        }

        public String getAdsbanner_image() {
            return adsbanner_image;
        }

        public void setAdsbanner_image(String adsbanner_image) {
            this.adsbanner_image = adsbanner_image;
        }

        public String getAdsbanner_url() {
            return adsbanner_url;
        }

        public void setAdsbanner_url(String adsbanner_url) {
            this.adsbanner_url = adsbanner_url;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getDate_modify() {
            return date_modify;
        }

        public void setDate_modify(String date_modify) {
            this.date_modify = date_modify;
        }

        public String getAdsbanner_image_path() {
            return adsbanner_image_path;
        }

        public void setAdsbanner_image_path(String adsbanner_image_path) {
            this.adsbanner_image_path = adsbanner_image_path;
        }

        public String getAdsbanner_image_name() {
            return adsbanner_image_name;
        }

        public void setAdsbanner_image_name(String adsbanner_image_name) {
            this.adsbanner_image_name = adsbanner_image_name;
        }
    }

    public static class PAGINATION {
        @SerializedName("PAGE")
        public int PAGE;
        @SerializedName("LIMIT")
        public int LIMIT;
        @SerializedName("TOTAL_COUNT")
        public int TOTAL_COUNT;
        @SerializedName("TOTAL_PAGES")
        public int TOTAL_PAGES;

        public int getPAGE() {
            return PAGE;
        }

        public void setPAGE(int PAGE) {
            this.PAGE = PAGE;
        }

        public int getLIMIT() {
            return LIMIT;
        }

        public void setLIMIT(int LIMIT) {
            this.LIMIT = LIMIT;
        }

        public int getTOTAL_COUNT() {
            return TOTAL_COUNT;
        }

        public void setTOTAL_COUNT(int TOTAL_COUNT) {
            this.TOTAL_COUNT = TOTAL_COUNT;
        }

        public int getTOTAL_PAGES() {
            return TOTAL_PAGES;
        }

        public void setTOTAL_PAGES(int TOTAL_PAGES) {
            this.TOTAL_PAGES = TOTAL_PAGES;
        }
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public List<AdsBanner.DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<AdsBanner.DATA> DATA) {
        this.DATA = DATA;
    }

    public AdsBanner.PAGINATION getPAGINATION() {
        return PAGINATION;
    }

    public void setPAGINATION(AdsBanner.PAGINATION PAGINATION) {
        this.PAGINATION = PAGINATION;
    }
}
