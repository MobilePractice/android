package com.example.android.networkusage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * Created by alex.luc on 25/06/2015.
 */
public class LcboJsonParser {

    public List<Store> parse(InputStream inputStream){
        System.out.println("JSON:LcboJsonParser: starting to parse");
        //List<String> storeNames = new ArrayList<String>();
        List<Store> storeList = new ArrayList<Store>();

        try{
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject)jsonParser.parse(new InputStreamReader(inputStream));
            int status = Integer.parseInt(jsonObj.get("status").toString());
            System.out.println("JSON:LcboJsonParser: status xbxbx = " + status);

            Calendar calendar = Calendar.getInstance();
            String dayOfWeekAbbrv = new SimpleDateFormat("E").format(calendar.getTime());
            String dayOfWeek = new SimpleDateFormat("EEEE").format(calendar.getTime());
            dayOfWeek = dayOfWeek.toLowerCase();
            System.out.println("JSON:LcboJsonParser: dayOfWeek = " + dayOfWeek + " dayOfWeekAbbrv = " + dayOfWeekAbbrv);

            JSONArray resultsArray = (JSONArray)jsonObj.get("result");
            JSONObject curStore = null;
            String storeName = "";
            Store aStore = null;
            String openTime = "";
            int distance;
            for(int i = 0; i < resultsArray.size(); i++){
                curStore = (JSONObject)resultsArray.get(i);
                storeName = (String)curStore.get("name");
                aStore = new Store();
                System.out.println("JSON:LcboJsonParser: storeName = " + storeName);
                aStore.setName((String)curStore.get("name"));
                aStore.setAddress1((String)curStore.get("address_line_1"));
                aStore.setTelephone((String)curStore.get("telephone"));
                aStore.setDayOfWeek(dayOfWeekAbbrv);
                openTime = curStore.get(dayOfWeek + "_open") + " - " + curStore.get(dayOfWeek + "_close");
                if(openTime.indexOf("null") > -1)
                    openTime = "   Closed    ";
                aStore.setOpenTime(openTime);
                //storeNames.add(storeName);
                aStore.setDistance(Integer.parseInt(curStore.get("distance_in_meters").toString()));
                storeList.add(aStore);
            }
        }catch(Exception e){
            System.out.println("JSONParser exception");
            e.printStackTrace();
        }

        return storeList;
    }

//    public void parse(InputStream inputStream){
//        System.out.println("JSON:LcboJsonParser: starting to parse");
//        JsonReader jsonReader = Json.createReader(inputStream);
//        JsonObject jsonObj = jsonReader.readObject();
//        JsonArray jsonArray = jsonObj.getJsonArray("result");
//        for(JsonObject result : jsonArray.getValuesAs(JsonObject.class)){
//            System.out.println("JSON:result = " + result.getJsonObject("name"));
//        }
//    }
}
