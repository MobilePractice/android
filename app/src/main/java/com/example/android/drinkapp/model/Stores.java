package com.example.android.drinkapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stores {
    @SerializedName("result")
    List<Store> stores;

    public List<Store> getStores(){
        return stores;
    }
}