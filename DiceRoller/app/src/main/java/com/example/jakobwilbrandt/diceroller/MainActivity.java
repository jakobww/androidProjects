package com.example.jakobwilbrandt.diceroller;

import DiceRolls.DiceCalc;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity
      extends AppCompatActivity {

DiceCalc diceRoll = new DiceCalc(MainActivity.this,this);

    private View.OnClickListener diceRollListener = new View.OnClickListener() {
        public void onClick(View v) {
            diceRoll.rollDice();
        }
    };

    private TextView.OnClickListener chanceChangeListener = new TextView.OnClickListener() {
        public void onClick(View v) {
            diceRoll.chanceChange();
        }
    };

    private TextView.OnClickListener hitMeClicker = new TextView.OnClickListener() {
        public void onClick(View v) {
            diceRoll.rollDice();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create typeface and set text font
        Typeface Amita=Typeface.createFromAsset(getAssets(), "fonts2/Electrolize-Regular.ttf");
        TextView Predictability = (TextView) findViewById(R.id.predictability);
        TextView statisticText = (TextView) findViewById(R.id.statisticText);
        TextView numberRolled = (TextView) findViewById(R.id.numberRolled);
        statisticText.setTypeface(Amita);
        Predictability.setTypeface(Amita);
        numberRolled.setTypeface(Amita);
        statisticText.setTextColor(Color.WHITE);
        Predictability.setTextColor(Color.WHITE);
        numberRolled.setTextColor(Color.WHITE);


        diceRoll.diceList();
        //numberRolled.setText(diceRoll.rollDice());




        ImageView button = (ImageView)findViewById(R.id.timeButton);
        // Register the onClick listener with the implementation above
        button.setOnClickListener(diceRollListener);
        statisticText.setOnClickListener(chanceChangeListener);
        numberRolled.setOnClickListener(hitMeClicker);



    }
}
