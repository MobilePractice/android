package com.example.android.drinkapp.activities;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android.drinkapp.R;
import com.example.android.drinkapp.adapters.SearchResultsAdapter;
import com.example.android.drinkapp.model.Product;
import com.example.android.drinkapp.model.SearchResults;
import com.example.android.drinkapp.services.SearchService;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SearchResultsActivity extends ListActivity {

    private ArrayList<Product> products;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String query = "";

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
        }

        products = new ArrayList<>();

        final SearchResultsAdapter adapter = new SearchResultsAdapter(this,
                R.layout.search_results_list_item, products);
        setListAdapter(adapter);

        SearchService.instance().searchProducts(query, new Callback<SearchResults>() {
            @Override
            public void success(SearchResults searchResults, Response response) {
                products.addAll(searchResults.getProducts());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TAG", error.toString());
            }
        });
    }
}
