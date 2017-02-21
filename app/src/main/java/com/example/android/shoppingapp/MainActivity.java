package com.example.android.shoppingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layoutDelivering = (LinearLayout) findViewById(R.id.layout_delivering);
        layoutDelivering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, deliveringActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutStumbling = (LinearLayout) findViewById(R.id.layout_stumbling);
        layoutStumbling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, stumblingActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutShortness = (LinearLayout) findViewById(R.id.layout_shortness);
        layoutShortness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, shortnessActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutMeditations = (LinearLayout) findViewById(R.id.layout_meditations);
        layoutMeditations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, meditationsActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layout_letter);
        layoutLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, letterActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layoutWhatIf = (LinearLayout) findViewById(R.id.layout_whatif);
        layoutWhatIf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, whatifActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout layoutPower = (LinearLayout) findViewById(R.id.layout_power);
        layoutPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, powerActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout layoutThinking = (LinearLayout) findViewById(R.id.layout_thinking);
        layoutThinking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, thinkingActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout layoutNation = (LinearLayout) findViewById(R.id.layout_nation);
        layoutNation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, nationActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout layout1984 = (LinearLayout) findViewById(R.id.layout_a1984);
        layout1984.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, a1984Activity.class);
                startActivity(intent);
            }
        });
        checkDisplay();

    }
    public void checkDisplay() {
        SharedData data = SharedData.getInstance();
        for(int i = 0; i < data.items.length; i++)
        {
            if(data.items[i])
            {
                switch (i){
                    case 0:
                        Button button = (Button) findViewById(R.id.button_delivering_happiness);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;
                    case 1:
                        button = (Button) findViewById(R.id.button_stumbling_on_happiness);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;
                    case 2:
                        button = (Button) findViewById(R.id.button_shortness);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;
                    case 3:
                        button = (Button) findViewById(R.id.button_meditations);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;
                    case 4:
                        button = (Button) findViewById(R.id.button_letter);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;
                    case 5:
                        button = (Button) findViewById(R.id.button_whatif);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;
                    case 6:
                        button = (Button) findViewById(R.id.button_power);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;
                    case 7:
                        button = (Button) findViewById(R.id.button_thinking);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;
                    case 8:
                        button = (Button) findViewById(R.id.button_nation);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;
                    case 9:
                        button = (Button) findViewById(R.id.button_1984);
                        button.setBackgroundColor(Color.GREEN);
                        button.setText("Added");
                        break;

                }
            }
        }
    }
    public void checkButtonToCart(View view) {
        Button button = (Button) view;
        int id = view.getId();
        SharedData data = SharedData.getInstance();
        if(button.getText().toString().equals("Added"))
        {
            button.setBackgroundResource(android.R.drawable.btn_default);
            button.setText("Add to Cart");
            setNotVisible(id);
            if(data.click > 0)
                --data.click;
        }
        else{
            button.setBackgroundColor(Color.GREEN);
            button.setText("Added");
            setVisible(id);
            ++data.click;

        }
    }
    public void setVisible(int id) {
        SharedData data = SharedData.getInstance();
        switch (id) {
            case R.id.button_delivering_happiness:
                data.setItemsVisible(0);
                break;
            case R.id.button_stumbling_on_happiness:
                data.setItemsVisible(1);
                break;
            case R.id.button_shortness:
                data.setItemsVisible(2);
                break;
            case R.id.button_meditations:
                data.setItemsVisible(3);
                break;
            case R.id.button_letter:
                data.setItemsVisible(4);
                break;
            case R.id.button_whatif:
                data.setItemsVisible(5);
                break;
            case R.id.button_power:
                data.setItemsVisible(6);
                break;
            case R.id.button_thinking:
                data.setItemsVisible(7);
                break;
            case R.id.button_nation:
                data.setItemsVisible(8);
                break;
            case R.id.button_1984:
                data.setItemsVisible(9);
                break;
        }
    }
    public void setNotVisible(int id) {
        SharedData data = SharedData.getInstance();
        switch (id) {
            case R.id.button_delivering_happiness:
                data.setItemNotVisible(0);
                break;
            case R.id.button_stumbling_on_happiness:
                data.setItemNotVisible(1);
                break;
            case R.id.button_shortness:
                data.setItemNotVisible(2);
                break;
            case R.id.button_meditations:
                data.setItemNotVisible(3);
                break;
            case R.id.button_letter:
                data.setItemNotVisible(4);
                break;
            case R.id.button_whatif:
                data.setItemNotVisible(5);
                break;
            case R.id.button_power:
                data.setItemNotVisible(6);
                break;
            case R.id.button_thinking:
                data.setItemNotVisible(7);
                break;
            case R.id.button_nation:
                data.setItemNotVisible(8);
                break;
            case R.id.button_1984:
                data.setItemNotVisible(9);
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_name) {
            Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


