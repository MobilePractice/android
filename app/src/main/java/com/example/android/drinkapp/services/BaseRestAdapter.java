package com.example.android.drinkapp.services;


import retrofit.RestAdapter;

public class BaseRestAdapter {
    protected static RestAdapter baseAdapter =
        new RestAdapter.Builder()
            .setEndpoint("http://mobilepractice.herokuapp.com/api/drink")
            .build();
}
