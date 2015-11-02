/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.android.drinkapp.activities;

import android.app.Activity;
import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.drinkapp.R;
import com.example.android.drinkapp.model.Store;
import com.example.android.drinkapp.model.Stores;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

public class HomeBackupActivity extends ActionBarActivity {
    public interface StoreService {
        @GET("/stores")
        void nearestStores(@Query("lat") double lat, @Query("lon") double lon, Callback<Stores> cb);
    }

    // Whether the display should be refreshed.
    public static boolean refreshDisplay = true;

    private List<Store> storeList = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://lcboapi.com")
                .build();

        StoreService service = restAdapter.create(StoreService.class);
        service.nearestStores(43.6463573, -79.3956818, new Callback<Stores>() {
            @Override
            public void success(Stores stores, Response response) {
                storeList = stores.getStores();
                updateNearestStore();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TAG", error.toString());
            }
        });
    }

    // Populates the activity's options menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);


        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        //SearchView searchView =
        //       (SearchView) menu.findItem(R.id.action_search).getActionView();
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));


        return true;

    }

    // Handles the user's menu selection.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent settingsActivity = new Intent(getBaseContext(), SettingsActivity.class);
                startActivity(settingsActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateNearestStore(){
        Store nearestStore = storeList.get(0);
        TextView myStoreName = (TextView)findViewById(R.id.myLocationName);
        TextView myStoreTime = (TextView)findViewById(R.id.myLocationTime);
        myStoreName.setText(nearestStore.getName());
    }
}