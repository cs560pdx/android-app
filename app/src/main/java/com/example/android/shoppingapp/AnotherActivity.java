package com.example.android.shoppingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnotherActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        SharedData data = SharedData.getInstance();
        if(data.click > 0)
        {
            checkDisplayItems();
            double totalCost = calculateTotal();
            setTotal(totalCost);
        }
        else
        {
            hideAllItems();
            Toast.makeText(this, "Your cart is empty",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void setQuantity(int itemId, final int indexPos){
        Spinner spinner = (Spinner) findViewById(itemId);

        // Initializing a String Array
        String[] plants = new String[]{ "1", "2", "3","4","5"};
        final List<String> plantsList = new ArrayList<>(Arrays.asList(plants));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,plantsList){
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position%2 == 1) {
                    // Set the item background color
                    tv.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                else {
                    // Set the alternate item background color
                    tv.setBackgroundColor(Color.parseColor("#d3d3d3"));
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedData data = SharedData.getInstance();
                data.quantity[indexPos] = i+1;
                setTotal(calculateTotal());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case android.R.id.home:
                finish();
        }
        return true;
    }
    public void deleteItemDelivering(View view) {
        SharedData data = SharedData.getInstance();
        LinearLayout delete = (LinearLayout) findViewById(R.id.checkout_delivering);
        data.quantity[0] = 0;
        data.click--;
        delete.removeAllViews();
        double totalCost = calculateTotal();
        setTotal(totalCost);
    }
    public void deleteItemStumbling(View view) {
        SharedData data = SharedData.getInstance();
        LinearLayout delete = (LinearLayout) findViewById(R.id.checkout_stumbling);
        data.quantity[1] = 0;
        data.click--;
        delete.removeAllViews();
        double totalCost = calculateTotal();
        setTotal(totalCost);
    }

    public void deleteItemShortness(View view) {
        SharedData data = SharedData.getInstance();
        LinearLayout delete = (LinearLayout) findViewById(R.id.checkout_shortness);
        data.quantity[2] = 0;
        data.click--;
        delete.removeAllViews();
        double totalCost = calculateTotal();
        setTotal(totalCost);
    }

    public void deleteItemMeditations(View view) {
        SharedData data = SharedData.getInstance();
        LinearLayout delete = (LinearLayout) findViewById(R.id.checkout_meditations);
        data.quantity[3] = 0;
        data.click--;
        delete.removeAllViews();
        double totalCost = calculateTotal();
        setTotal(totalCost);
    }

    public void deleteItemLetter(View view) {
        SharedData data = SharedData.getInstance();
        LinearLayout delete = (LinearLayout) findViewById(R.id.checkout_letter);
        data.quantity[4] = 0;
        data.click--;
        delete.removeAllViews();
        double totalCost = calculateTotal();
        setTotal(totalCost);
    }

    public void deleteItemWhatIf(View view) {
        SharedData data = SharedData.getInstance();
        LinearLayout delete = (LinearLayout) findViewById(R.id.checkout_letter);
        data.quantity[5] = 0;
        data.click--;
        delete.removeAllViews();
        double totalCost = calculateTotal();
        setTotal(totalCost);
    }

    public void checkDisplayItems(){
        SharedData data = SharedData.getInstance();
        if(data.items[0] == true){
            displayItem(R.id.checkout_delivering);
            data.quantity[0] = 1;
        }
        if(data.items[0] == false){
            hideItem(R.id.checkout_delivering);
            data.quantity[0] = 0;
        }

        if(data.items[1] == true){
            displayItem(R.id.checkout_stumbling);
            data.quantity[1] = 1;
        }

        if(data.items[1] == false){
            hideItem(R.id.checkout_stumbling);
            data.quantity[1] = 0;
        }

        if(data.items[2] == true){
            displayItem(R.id.checkout_shortness);
            data.quantity[2] = 1;
        }

        if(data.items[2] == false){
            hideItem(R.id.checkout_shortness);
            data.quantity[2] = 0;
        }

        if(data.items[3] == true){
            displayItem(R.id.checkout_meditations);
            data.quantity[3] = 1;
        }

        if(data.items[3] == false){
            hideItem(R.id.checkout_meditations);
            data.quantity[3] = 0;
        }

        if(data.items[4] == true){
            displayItem(R.id.checkout_letter);
            data.quantity[4] = 1;
        }

        if(data.items[4] == false){
            hideItem(R.id.checkout_letter);
            data.quantity[4] = 0;
        }

        if(data.items[5] == true){
            displayItem(R.id.checkout_whatif);
            data.quantity[5] = 1;
        }

        if(data.items[5] == false){
            hideItem(R.id.checkout_whatif);
            data.quantity[5] = 0;
        }

    }
    public void displayItem(int id) {
        LinearLayout item = (LinearLayout) findViewById(id);
        item.setVisibility(View.VISIBLE);
        switch (id){
            case R.id.checkout_delivering:
                setQuantity(R.id.spinner_checkout,0);
                break;
            case R.id.checkout_stumbling:
                setQuantity(R.id.spinner_checkout_2,1);
                break;
            case R.id.checkout_shortness:
                setQuantity(R.id.spinner_checkout_3,2);
                break;
            case R.id.checkout_meditations:
                setQuantity(R.id.spinner_checkout_4,3);
                break;
            case R.id.checkout_letter:
                setQuantity(R.id.spinner_checkout_5,4);
                break;
            case R.id.checkout_whatif:
                setQuantity(R.id.spinner_checkout_6,5);
                break;
        }
    }
    public void hideItem(int id) {
        LinearLayout item = (LinearLayout) findViewById(id);
        item.setVisibility(View.GONE);
        switch (id){
            case R.id.checkout_delivering:
                setQuantity(R.id.spinner_checkout,0);
                break;
            case R.id.checkout_stumbling:
                setQuantity(R.id.spinner_checkout_2,1);
                break;
            case R.id.checkout_shortness:
                setQuantity(R.id.spinner_checkout_3,2);
                break;
            case R.id.checkout_meditations:
                setQuantity(R.id.spinner_checkout_4,3);
                break;
            case R.id.checkout_letter:
                setQuantity(R.id.spinner_checkout_5,4);
                break;
            case R.id.checkout_whatif:
                setQuantity(R.id.spinner_checkout_6,5);
                break;
        }
    }

    public void hideAllItems() {
        LinearLayout item = (LinearLayout) findViewById(R.id.checkout_all_items);
        item.setVisibility(View.GONE);
    }
    public void setTotal(double total) {
        TextView ll = (TextView) findViewById(R.id.total_result);
        ll.setText(String.format("%.2f", total));
    }
    public double calculateTotal() {
        SharedData data = SharedData.getInstance();
        double total = 0;
        for(int i = 0; i < data.items.length; i++)
        {
            if(data.items[i])
                total = total + data.price[i]*data.quantity[i];
        }
        return total;
    }
}
