package com.api.hrd.nhamey.models.api_respone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Thyreach on 1/24/2017.
 */

public class Comment_Respone {

    @SerializedName("CODE")
    public String CODE;
    @SerializedName("STATUS")
    public boolean STATUS;
    @SerializedName("MESSAGE")
    public String MESSAGE;
    @SerializedName("DATA")
    public List<DATA> DATA;

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

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public List<Comment_Respone.DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<Comment_Respone.DATA> DATA) {
        this.DATA = DATA;
    }

    public static class Role {
        @SerializedName("id")
        public int id;
        @SerializedName("key")
        public String key;
        @SerializedName("name")
        public String name;

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

    public static class Rest {
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
        public String address;
        @SerializedName("user")
        public String user;
        @SerializedName("restpictures")
        public String restpictures;
        @SerializedName("restype")
        public String restype;
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

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getOpen_close() {
            return open_close;
        }

        public void setOpen_close(String open_close) {
            this.open_close = open_close;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getRest_name_kh() {
            return rest_name_kh;
        }

        public void setRest_name_kh(String rest_name_kh) {
            this.rest_name_kh = rest_name_kh;
        }

        public int getTotal_favorite() {
            return total_favorite;
        }

        public void setTotal_favorite(int total_favorite) {
            this.total_favorite = total_favorite;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getRestpictures() {
            return restpictures;
        }

        public void setRestpictures(String restpictures) {
            this.restpictures = restpictures;
        }

        public String getRestype() {
            return restype;
        }

        public void setRestype(String restype) {
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

    public static class DATA {
        @SerializedName("comment_id")
        public int comment_id;
        @SerializedName("comment")
        public String comment;
        @SerializedName("user")
        public User user;
        @SerializedName("rest")
        public Rest rest;

        public int getComment_id() {
            return comment_id;
        }

        public void setComment_id(int comment_id) {
            this.comment_id = comment_id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Rest getRest() {
            return rest;
        }

        public void setRest(Rest rest) {
            this.rest = rest;
        }
    }
}
