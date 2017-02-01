package com.api.hrd.nhamey.models;

/**
 * Created by Thyreach on 1/19/2017.
 */

public class AllCommentModel {

    String profileName;

    String commentData;
    String profileImage;

    public AllCommentModel(String profileName, String commentData,String profileImage){
        this.profileName = profileName;
        this.commentData = commentData;
        this.profileImage = profileImage;

    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }


    public String getCommentData() {
        return commentData;
    }

    public void setCommentData(String commentData) {
        this.commentData = commentData;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
