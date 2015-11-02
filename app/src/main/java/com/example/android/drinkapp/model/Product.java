package com.example.android.drinkapp.model;

import com.google.gson.annotations.SerializedName;

public class Product {
    String name;
    @SerializedName("price_in_cents")
    Double currentPrice;
    @SerializedName("image_thumb_url")
    String imageThumbnail;


    public String getName(){
        return name;
    }
    public Double getCurrentPrice(){
        return currentPrice / 100;
    }
    public String getImageThumbnail(){
        return imageThumbnail;
    }
}