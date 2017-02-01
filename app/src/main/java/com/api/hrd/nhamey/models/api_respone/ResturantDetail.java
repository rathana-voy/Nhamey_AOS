package com.api.hrd.nhamey.models.api_respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Thyreach on 1/21/2017.
 */

public class ResturantDetail {
    @SerializedName("STATUS")
    public boolean STATUS;
    @SerializedName("CODE")
    public String CODE;
    @SerializedName("MESSAGE")
    public String MESSAGE;
    @SerializedName("DATA")
    public DATA DATA;

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

    public ResturantDetail.DATA getDATA() {
        return DATA;
    }

    public void setDATA(ResturantDetail.DATA DATA) {
        this.DATA = DATA;
    }

    public static class Address {
        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getCommunce() {
            return communce;
        }

        public void setCommunce(String communce) {
            this.communce = communce;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getVillage() {
            return village;
        }

        public void setVillage(String village) {
            this.village = village;
        }

        @SerializedName("address_id")
        public int address_id;
        @SerializedName("street")
        public String street;
        @SerializedName("district")
        public String district;
        @SerializedName("communce")
        public String communce;
        @SerializedName("province")
        public String province;
        @SerializedName("village")
        public String village;
    }

    public static class Role {
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @SerializedName("id")
        public int id;
        @SerializedName("key")
        public String key;
        @SerializedName("name")
        public String name;
    }

    public static class User {
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("gender")
        public String gender;
        @SerializedName("salt")
        public String salt;
        @SerializedName("dob")
        public String dob;
        @SerializedName("joined")
        public String joined;
        @SerializedName("picture")
        public String picture;
        @SerializedName("user_id")
        public int user_id;
        @SerializedName("username")
        public String username;
        @SerializedName("password")
        public String password;
        @SerializedName("role")
        public Role role;
        @SerializedName("email")
        public String email;
        @SerializedName("role_name")
        public String role_name;
        @SerializedName("user_hash")
        public String user_hash;
        @SerializedName("roles")
        public String roles;

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getJoined() {
            return joined;
        }

        public void setJoined(String joined) {
            this.joined = joined;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRole_name() {
            return role_name;
        }

        public void setRole_name(String role_name) {
            this.role_name = role_name;
        }

        public String getUser_hash() {
            return user_hash;
        }

        public void setUser_hash(String user_hash) {
            this.user_hash = user_hash;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }
    }

    public static class Restpictures {
        @SerializedName("picture_id")
        public int picture_id;
        @SerializedName("path_name")
        public String path_name;
        @SerializedName("date_added")
        public String date_added;
        @SerializedName("date_modify")
        public String date_modify;

        public int getPicture_id() {
            return picture_id;
        }

        public void setPicture_id(int picture_id) {
            this.picture_id = picture_id;
        }

        public String getPath_name() {
            return path_name;
        }

        public void setPath_name(String path_name) {
            this.path_name = path_name;
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
    }

    public static class Restype {
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

        public String getRestype_name_kh() {
            return restype_name_kh;
        }

        public void setRestype_name_kh(String restype_name_kh) {
            this.restype_name_kh = restype_name_kh;
        }

        public String getRestype_picture() {
            return restype_picture;
        }

        public void setRestype_picture(String restype_picture) {
            this.restype_picture = restype_picture;
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
    }

    public static class DATA {
        @SerializedName("rest_id")
        public int rest_id;
        @SerializedName("rest_name")
        public String rest_name;
        @SerializedName("contact")
        public String contact;
        @SerializedName("about")
        public String about;
        @SerializedName("open_close")
        public String open_close;
        @SerializedName("latitude")
        public String latitude;
        @SerializedName("longitude")
        public String longitude;
        @SerializedName("rest_name_kh")
        public String rest_name_kh;
        @SerializedName("total_favorite")
        public int total_favorite;
        @SerializedName("address")
        public Address address;
        @SerializedName("user")
        public User user;
        @SerializedName("restpictures")
        public List<Restpictures> restpictures;
        @SerializedName("restype")
        public List<Restype> restype;
        @SerializedName("categories")
        public String categories;
        @SerializedName("restypes")
        public String restypes;

        public int getRest_id() {
            return rest_id;
        }

        public void setRest_id(int rest_id) {
            this.rest_id = rest_id;
        }

        public String getRest_name() {
            return rest_name;
        }

        public void setRest_name(String rest_name) {
            this.rest_name = rest_name;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public String getOpen_close() {
            return open_close;
        }

        public void setOpen_close(String open_close) {
            this.open_close = open_close;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getTotal_favorite() {
            return total_favorite;
        }

        public void setTotal_favorite(int total_favorite) {
            this.total_favorite = total_favorite;
        }

        public String getRest_name_kh() {
            return rest_name_kh;
        }

        public void setRest_name_kh(String rest_name_kh) {
            this.rest_name_kh = rest_name_kh;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<Restpictures> getRestpictures() {
            return restpictures;
        }

        public void setRestpictures(List<Restpictures> restpictures) {
            this.restpictures = restpictures;
        }

        public List<Restype> getRestype() {
            return restype;
        }

        public void setRestype(List<Restype> restype) {
            this.restype = restype;
        }

        public String getCategories() {
            return categories;
        }

        public void setCategories(String categories) {
            this.categories = categories;
        }

        public String getRestypes() {
            return restypes;
        }

        public void setRestypes(String restypes) {
            this.restypes = restypes;
        }
    }


}

