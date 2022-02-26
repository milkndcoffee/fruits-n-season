package com.milkndcoffee.fruitsnseason.Controller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.milkndcoffee.fruitsnseason.Model.Fruit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FruitFetcher {
    public interface OnFruitsDataReceivedListener{
        void onFruitsReceived(List<Fruit> fruits);
        void onErrorResponse(VolleyError error);
    }
    public interface  OnFruitDataReceivedListener{
        void onFruitReceived(Fruit fruit);
        void onErrorResponse(VolleyError error);
    }

    private final String WEBAPI_BASE_URL = "https://fruits-n-season-default-rtdb.firebaseio.com/fruits.json?";
    private final String TAG = "FruitFetcher";
    private final RequestQueue mRequestQueue;

    public FruitFetcher(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    //@Test
    //public void test

    /* FETCHES FRUITS WITHIN MONTH */
    public void fetchFruits(final OnFruitsDataReceivedListener listener, String month) {
        String url = WEBAPI_BASE_URL + "orderBy=\"inSeason/"+ month + "\"" + "&equalTo=true";
        //url = "https://fruits-n-season-default-rtdb.firebaseio.com/fruits.json?orderBy=\"inSeason/apr\"&equalTo=true";
        //+ "orderBy=\"name\"&equalTo=\"test\"";

        //Request fruits
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> listener.onFruitsReceived(jsonToFruits(response)),
                listener::onErrorResponse);

        mRequestQueue.add(request);
    }
    private List<Fruit> jsonToFruits(JSONObject json){
        //Creating a list of fruits
        List<Fruit> fruitList = new ArrayList<>();

        try{
            Log.i("jsonToFruits", json.toString());
            //JSONArray fruitArray = json.getJSONArray("fruits");

            int i = 0;
            Iterator<String> keys = json.keys();
            while(keys.hasNext()) {
                Fruit fruit = new Fruit();

                String nextKey = keys.next();
                JSONObject fruitObj = json.getJSONObject(nextKey);

                //fruit.setId();
                fruit.setName(fruitObj.getString("name"));
                fruit.setImgSrc(fruitObj.getString("imgSrc"));
                fruit.setId(i);
                fruitList.add(fruit);

                i++;
                Log.i("jsonToFruits ADDED", fruit.toString());
            }
        }catch (JSONException e){
            Log.e(TAG, "Field missing in the JSON data: " + e.getMessage());
        }
        return fruitList;
    }


    /* FETCHES SPECIFIC FRUIT */
    public void fetchFruit(final OnFruitDataReceivedListener listener, String month, int counterBreak) {
        String url = WEBAPI_BASE_URL + "orderBy=\"inSeason/"+ month + "\"" + "&equalTo=true";
        //url = "https://fruits-n-season-default-rtdb.firebaseio.com/fruits.json?orderBy=\"inSeason/apr\"&equalTo=true";
        //+ "orderBy=\"name\"&equalTo=\"test\"";

        //Request fruits
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> listener.onFruitReceived(jsonToFruit(response, counterBreak)),
                listener::onErrorResponse);

        mRequestQueue.add(request);
    }

    private Fruit jsonToFruit(JSONObject json, int counterBreak) {
        Fruit fruit = new Fruit();

        try{
            Log.i("jsonToFruits", json.toString());
            //JSONArray fruitArray = json.getJSONArray("fruits");

            Iterator<String> keys = json.keys();
            int i = 0;
            while(keys.hasNext()) {

                String nextKey = keys.next();
                JSONObject fruitObj = json.getJSONObject(nextKey);

                if (i == counterBreak){
                    fruit.setName(fruitObj.getString("name"));
                    fruit.setImgSrc(fruitObj.getString("imgSrc"));
                    String monthStrings = "in season: [";
                    JSONObject monthObj = fruitObj.getJSONObject("inSeason");
                    if(monthObj.getBoolean("jan")){
                        monthStrings = monthStrings + " jan ";
                    } if (monthObj.getBoolean("feb")){
                        monthStrings = monthStrings + " feb ";
                    } if (monthObj.getBoolean("mar")){
                        monthStrings = monthStrings + " mar ";
                    } if (monthObj.getBoolean("apr")){
                        monthStrings = monthStrings + " apr ";
                    } if (monthObj.getBoolean("may")){
                        monthStrings = monthStrings + " may ";
                    } if (monthObj.getBoolean("jun")){
                        monthStrings = monthStrings + " jun ";
                    } if (monthObj.getBoolean("jul")){
                        monthStrings = monthStrings + " jul ";
                    } if (monthObj.getBoolean("aug")){
                        monthStrings = monthStrings + " aug ";
                    } if (monthObj.getBoolean("sep")){
                        monthStrings = monthStrings + " sep ";
                    } if (monthObj.getBoolean("nov")){
                        monthStrings = monthStrings + " nov ";
                    }

                    monthStrings = monthStrings + "]";
                    fruit.setMonths(monthStrings);
                    return fruit;
                } else{
                    i++;
                }
            }
        }catch (JSONException e){
            Log.e(TAG, "Field missing in the JSON data: " + e.getMessage());
        }

        return fruit;
    }


  /*
    public interface OnFruitDataReceivedListener{
        void onFruitReceived(Fruit fruit);
        void onErrorResponse(VolleyError error);
    }

    private final String WEBAPI_BASE_URL = "https://fruits-n-season-default-rtdb.firebaseio.com/.json?";
    private final String TAG = "FruitFetcher";

    private final RequestQueue mRequestQueue;

    public FruitFetcher(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public void fetchFruits(final OnFruitsDataReceivedListener listener){
        String url = "https://fruits-n-season-default-rtdb.firebaseio.com/.json?";
                //+ "orderBy=\"name\"&equalTo=\"test\"";

        //Request fruits
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> listener.onFruitsReceived(jsonToFruits(response)),
                listener::onErrorResponse);

        mRequestQueue.add(request);
    }





    public void fetchFruit(final OnFruitDataReceivedListener listener, String fruitName){
        String baseUrl = "https://fruits-n-season-default-rtdb.firebaseio.com/fruits.json?";
        String url = baseUrl + "orderBy=\"name\"&equalTo=\"" + fruitName + "\"";

        //Request fruits
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> listener.onFruitReceived(jsonToFruit(response)),
                listener::onErrorResponse);

        mRequestQueue.add(request);
    }

    private Fruit jsonToFruit(JSONObject json) {
        Fruit fruit = new Fruit();
        try{
            //JSONArray jsonTry;
            Log.i("jsonToFruit", json.toString());
            fruit.setName(json.optString("name", "fallback"));

            Iterator<String> keys = json.keys();
            while(keys.hasNext()){
                String nextKey = keys.next();
                JSONObject fruitObj = json.getJSONObject(nextKey);
                fruit.setName(fruitObj.optString("name", "fallbackAgain"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fruit.setId(999);
        return fruit;
    }

    private List<Fruit> jsonToFruits(JSONObject json){
        //Creating a list of fruits
        List<Fruit> fruitList = new ArrayList<>();

        try{
            JSONArray fruitArray = json.getJSONArray("fruits");
            Log.i("jsonToFruits", json.toString());
            for (int i=0; i<fruitArray.length(); i++){
                JSONObject fruitObj = fruitArray.getJSONObject(i);

                Fruit fruit = new Fruit();
                fruit.setName(fruitObj.getString("name"));
                fruit.setId(i); // change later

                fruitList.add(fruit);
            }
        }catch (JSONException e){
            Log.e(TAG, "Field missing in the JSON data: " + e.getMessage());
        }
        return fruitList;
    }*/
}
