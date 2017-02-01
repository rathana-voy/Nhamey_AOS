package com.api.hrd.nhamey.models.api_respone;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rathana on 17/1/17.
 */

public class RestType implements Parcelable {


    @SerializedName("STATUS")
    public boolean STATUS;
    @SerializedName("CODE")
    public String CODE;
    @SerializedName("MESSAGE")
    public String MESSAGE;
    @SerializedName("DATA")
    public List<DATA> DATA;
    @SerializedName("PAGINATION")
    public PAGINATION PAGINATION;

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public List<RestType.DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<RestType.DATA> DATA) {
        this.DATA = DATA;
    }

    public RestType.PAGINATION getPAGINATION() {
        return PAGINATION;
    }

    public void setPAGINATION(RestType.PAGINATION PAGINATION) {
        this.PAGINATION = PAGINATION;
    }

    public static class DATA implements Parcelable {

        @SerializedName("restype_id")
        public int restype_id;
        @SerializedName("restype_name")
        public String restype_name;
        @SerializedName("restype_name_kh")
        public String restype_name_kh;
        @SerializedName("restype_picture")
        public String restype_picture;
        @SerializedName("date_added")
        public String date_added;
        @SerializedName("date_modify")
        public String date_modify;
        @SerializedName("parentid_restypeid")
        public int parentid_restypeid;
        @SerializedName("description")
        public String description;
        @SerializedName("restpictures")
        public String restpictures;
        @SerializedName("restype_files")
        public String restype_files;
        @SerializedName("menus")
        public String menus;
        @SerializedName("restaurants")
        public String restaurants;

        public int getRestype_id() {
            return restype_id;
        }

        public void setRestype_id(int restype_id) {
            this.restype_id = restype_id;
        }

        public String getRestype_name() {
            return restype_name;
        }

        public void setRestype_name(String restype_name) {
            this.restype_name = restype_name;
        }

        public String getRestype_picture() {
            return restype_picture;
        }

        public void setRestype_picture(String restype_picture) {
            this.restype_picture = restype_picture;
        }

        public String getRestype_name_kh() {
            return restype_name_kh;
        }

        public void setRestype_name_kh(String restype_name_kh) {
            this.restype_name_kh = restype_name_kh;
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

        public int getParentid_restypeid() {
            return parentid_restypeid;
        }

        public void setParentid_restypeid(int parentid_restypeid) {
            this.parentid_restypeid = parentid_restypeid;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRestpictures() {
            return restpictures;
        }

        public void setRestpictures(String restpictures) {
            this.restpictures = restpictures;
        }

        public String getRestype_files() {
            return restype_files;
        }

        public void setRestype_files(String restype_files) {
            this.restype_files = restype_files;
        }

        public String getMenus() {
            return menus;
        }

        public void setMenus(String menus) {
            this.menus = menus;
        }

        public String getRestaurants() {
            return restaurants;
        }

        public void setRestaurants(String restaurants) {
            this.restaurants = restaurants;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.description);
            dest.writeString(this.restype_name);
            dest.writeString(this.restype_name_kh);
            dest.writeString(this.restype_picture);
            dest.writeString(this.date_added);
            dest.writeString(this.date_modify);
            dest.writeInt(this.parentid_restypeid);
            dest.writeInt(this.restype_id);
            dest.writeString(this.restpictures);
            dest.writeString(this.restype_files);
            dest.writeString(this.menus);
            dest.writeString(this.restaurants);
        }

        public DATA() {
        }

        protected DATA(Parcel in) {
            this.description = in.readString();
            this.restype_name = in.readString();
            this.restype_name_kh = in.readString();
            this.restype_picture = in.readString();
            this.date_added = in.readString();
            this.date_modify = in.readString();
            this.parentid_restypeid = in.readInt();
            this.restype_id = in.readInt();
            this.restpictures = in.readString();
            this.restype_files = in.readString();
            this.menus = in.readString();
            this.restaurants = in.readString();
        }

        public static final Creator<DATA> CREATOR = new Creator<DATA>() {
            @Override
            public DATA createFromParcel(Parcel source) {
                return new DATA(source);
            }

            @Override
            public DATA[] newArray(int size) {
                return new DATA[size];
            }
        };
    }

    public static class PAGINATION implements Parcelable {

        @SerializedName("PAGE")
        public int PAGE;
        @SerializedName("LIMIT")
        public int LIMIT;
        @SerializedName("TOTAL_COUNT")
        public int TOTAL_COUNT;
        @SerializedName("TOTAL_PAGES")
        public int TOTAL_PAGES;

        public int getTOTAL_COUNT() {
            return TOTAL_COUNT;
        }

        public void setTOTAL_COUNT(int TOTAL_COUNT) {
            this.TOTAL_COUNT = TOTAL_COUNT;
        }

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

        public int getTOTAL_PAGES() {
            return TOTAL_PAGES;
        }

        public void setTOTAL_PAGES(int TOTAL_PAGES) {
            this.TOTAL_PAGES = TOTAL_PAGES;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.PAGE);
            dest.writeInt(this.LIMIT);
            dest.writeInt(this.TOTAL_COUNT);
            dest.writeInt(this.TOTAL_PAGES);
        }

        public PAGINATION() {
        }

        protected PAGINATION(Parcel in) {
            this.PAGE = in.readInt();
            this.LIMIT = in.readInt();
            this.TOTAL_COUNT = in.readInt();
            this.TOTAL_PAGES = in.readInt();
        }

        public static final Creator<PAGINATION> CREATOR = new Creator<PAGINATION>() {
            @Override
            public PAGINATION createFromParcel(Parcel source) {
                return new PAGINATION(source);
            }

            @Override
            public PAGINATION[] newArray(int size) {
                return new PAGINATION[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.STATUS ? (byte) 1 : (byte) 0);
        dest.writeString(this.CODE);
        dest.writeString(this.MESSAGE);
        dest.writeList(this.DATA);
        dest.writeParcelable(this.PAGINATION, flags);
    }

    public RestType() {
    }

    protected RestType(Parcel in) {
        this.STATUS = in.readByte() != 0;
        this.CODE = in.readString();
        this.MESSAGE = in.readString();
        this.DATA = new ArrayList<RestType.DATA>();
        in.readList(this.DATA, RestType.DATA.class.getClassLoader());
        this.PAGINATION = in.readParcelable(RestType.PAGINATION.class.getClassLoader());
    }

    public static final Parcelable.Creator<RestType> CREATOR = new Parcelable.Creator<RestType>() {
        @Override
        public RestType createFromParcel(Parcel source) {
            return new RestType(source);
        }

        @Override
        public RestType[] newArray(int size) {
            return new RestType[size];
        }
    };
}
