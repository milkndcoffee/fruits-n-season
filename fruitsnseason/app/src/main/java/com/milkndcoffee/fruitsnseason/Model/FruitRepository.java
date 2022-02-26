package com.milkndcoffee.fruitsnseason.Model;

import android.content.Context;
import android.util.Log;

import com.milkndcoffee.fruitsnseason.Controller.FruitFetcher;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FruitRepository {
    private static FruitRepository instance;
    private List<Fruit> mFruits;
    private FruitFetcher mFruitFetcher;

    public static FruitRepository getInstance(Context context) {
        if (instance == null) {
            instance = new FruitRepository(context);
        }
        return instance;
    }

    private FruitRepository(Context context){
        mFruits = new ArrayList<>();

        /*
        Resources res = context.getResources();
        String[] bands = res.getStringArray(R.array.bands);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        String[] imgs = res.getStringArray(R.array.imgs);
        String[] links = res.getStringArray(R.array.links);
        for (int i = 0; i < bands.length; i++) {
            mBands.add(new Band(i + 1, bands[i], descriptions[i], imgs[i], links[i]));
        }
        TODO: Create GET Request here with volley, then for loop values into array? maybe */
    }

    //get single Fruit
    public Fruit getFruit(int fruitId){
        for (Fruit fruit : mFruits){
            if (fruit.getId() == fruitId){
                return fruit;
            }
        }
        return null;
    }
}
