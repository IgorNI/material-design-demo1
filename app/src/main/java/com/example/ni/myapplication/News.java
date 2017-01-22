package com.example.ni.myapplication;

import java.io.Serializable;

/**
 * Created by ni on 2017/1/22.
 */

public class News implements Serializable{
    private String title;
    private String description;
    private int photoId;

    public News(String title,String description,int photoId){
        this.title = title;
        this.description = description;
        this.photoId = photoId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
