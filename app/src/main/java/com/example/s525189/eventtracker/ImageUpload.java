package com.example.s525189.eventtracker;

/**
 * Created by s525389 on 4/16/2018.
 */

public class ImageUpload {
    private String mName;
    private String mImageUrl;

    public ImageUpload(String s){


    }
    public ImageUpload(String name, String imageUrl){
        if (name.trim().equals(" ")){
            name = "No Name";
        }
        mName = name;
        mImageUrl = imageUrl;

    }
    public String getName(){
        return mName;
    }
    public void setName (String name){
        mName = name;
    }

    public  String getImageUrl(){
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl){
        mImageUrl = imageUrl;
    }
}
