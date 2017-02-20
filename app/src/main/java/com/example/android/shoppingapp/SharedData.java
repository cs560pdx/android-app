package com.example.android.shoppingapp;

/**
 * Created by minhvu on 2/18/17.
 */

public class SharedData {
    private static SharedData instance = new SharedData();
    public int click;
    public boolean[] items;
    public double[] price = {18.5,12.99,9.20,8.90,14.50,14.30,22.40,28.84,12.90,15.70};
    public int[] quantity = {0,0,0,0,0,0,0,0,0,0};

    private SharedData() {
        click = 0;
        items = new boolean[10];
    };
    public static SharedData getInstance() {
        return instance;
    }
    public void setItemsVisible(int index) {
        items[index] = true;
    }
    public void setItemNotVisible(int index) {
        items[index] = false;
    }
}
