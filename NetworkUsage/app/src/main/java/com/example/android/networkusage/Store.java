package com.example.android.networkusage;

import java.io.Serializable;

/**
 * Created by alex.luc on 26/06/2015.
 */
public class Store implements Serializable{
    private int id;
    private String name;
    private String address1;
    private String telephone;
    private String dayOfWeek;
    private String openTime;
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

    public String getAddress1(){
        return address1;
    }

    public void setAddress1(String anAddress){
        address1 = anAddress;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setTelephone(String aTelephone){
        telephone = aTelephone;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
