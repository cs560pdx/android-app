package com.example.android.shoppingapp;

/**
 * Created by minhvu on 2/18/17.
 */

public class SharedData {
    private static SharedData instance = new SharedData();
    private SharedData() {};
    public static SharedData getInstance() {
        return instance;
    }

}
