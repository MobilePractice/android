package com.example.android.drinkapp.services;


import com.example.android.drinkapp.model.SearchResults;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public class SearchService extends BaseRestAdapter {
    public interface SearchServiceImpl {
        @GET("/products")
        void searchProducts(@Query("q") String query, Callback<SearchResults> cb);
    }

    private SearchService(){}

    public static SearchServiceImpl instance(){
        return baseAdapter.create(SearchServiceImpl.class);
    }
}
