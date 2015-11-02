package com.example.android.drinkapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResults {
    @SerializedName("result")
    List<Product> products;

    public List<Product> getProducts(){
        return products;
    }
}