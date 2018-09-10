package com.aramzy.recyclingfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RecyclingFactsActivity extends AppCompatActivity {

    private static final String FACT_KEY = "fact_key";
    private static final String COLOR_KEY = "color_key";
    private TextView lbl;
    private RelativeLayout RL;
    private String fact;
    private String color;
    private String oldColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycling_facts);
        lbl = findViewById(R.id.lbl);
        Button btn = findViewById(R.id.btn);
        RL = findViewById(R.id.RL);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                generateFact();
                generateColor();

            }

        });

        generateFact();
        generateColor();

        oldColor = "";

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString(FACT_KEY, fact);
        outState.putString(COLOR_KEY, color);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        fact = savedInstanceState.getString(FACT_KEY);
        color = savedInstanceState.getString(COLOR_KEY);
        lbl.setText(fact);
        RL.setBackgroundColor(Color.parseColor(color));

    }

    private void generateFact() {

        RecyclingFactsGenerator rfg = new RecyclingFactsGenerator(getResources().getStringArray(R.array.facts));
        fact = rfg.generateFact();
        if(!lbl.getText().toString().equals(fact)) {

            lbl.setText(fact);

        } else {

            generateFact();

        }

    }

    private void generateColor() {

        RecyclingColorGenerator rcg = new RecyclingColorGenerator(getResources().getStringArray(R.array.colors));
        color = rcg.generateColor();
        if(!color.equals(oldColor)) {

            RL.setBackgroundColor(Color.parseColor(color));

        } else {

            generateColor();

        }

        oldColor = color;

    }

}