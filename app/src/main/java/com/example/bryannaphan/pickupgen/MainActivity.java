package com.example.bryannaphan.pickupgen;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public static String[] DEFAULTS = {
        "Do you have a Band-Aid? Because I just scraped my knee falling for you.",
            "If you were a vegetable youd be a cute-cumber.",
            "Do you have a sunburn, or are you always this hot?",
            "Are you Australian? Because you meet all of my koala-fications.",
            "Are you a banana? Because I find you a-peeling!"
    };
    FragmentManager fm  = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.bryannaphan.pickupgen.R.layout.activity_main);

        final ArrayList<String> pickupLines = new ArrayList<String>(Arrays.asList(DEFAULTS));


        final Button textButton = (Button) findViewById(com.example.bryannaphan.pickupgen.R.id.textButton);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                int count = sharedPref.getInt("count",0);
                for(int i = 0; i < count; i++) {
                    String current = sharedPref.getString("custom" + i, "");;
                    if(!current.equals("") && !pickupLines.contains(current)) {
                        pickupLines.add(current);
                    }
                }

                final Random rand = new Random();
                final TextView helloText = (TextView) findViewById(com.example.bryannaphan.pickupgen.R.id.helloText);
                int randNum = rand.nextInt(pickupLines.size());
                helloText.setText(pickupLines.get(randNum));
            }
        });

        final FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddLineFragment addFrag = new AddLineFragment();
                addFrag.show(fm, "dialog fragment");
            }
        });

    }
}
