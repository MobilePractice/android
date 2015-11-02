package com.example.android.drinkapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by alex.luc on 26/06/2015.
 */
public class Store implements Serializable{
    private int id;
    private String name;
    @SerializedName("address_line_1")
    private String addressLine1;
    private String telephone;
    @SerializedName("distance_in_meters")
    private int distance;

    public Store(){

    }

    public int getId(){
        return id;
    }

    public void setId(int anId){
        id = anId;
    }

    public String getName(){
        return name;
    }

    public void setName(String aName){
        name = aName;
    }

    public String getAddressLine1(){
        return addressLine1;
    }

    public void setAddressLine1(String anAddress){
        addressLine1 = anAddress;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setTelephone(String aTelephone){
        telephone = aTelephone;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
