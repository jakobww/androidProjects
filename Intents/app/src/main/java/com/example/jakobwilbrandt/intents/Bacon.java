package com.example.jakobwilbrandt.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Bacon
      extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Her giver vi Bacon tilladelse til at hente informationer fra Apples. Data bliver smidt
        // over i applesData
        Bundle applesData = getIntent().getExtras();
        //Hvis der ikke bliver sendt noget med.
        if (applesData == null) {
            return;
        }

        //Nedenfor laves der en string hvor vi smider vores besked over i. Det med citationstegn
        // skal være det samme som det vi har skrevet i vores putExtra funktion som sender det
        // med i Apple.java
        String appleMessage = applesData.getString("AppleMessage");

        //læg mærke til at bacontext er final og at vi alligevel ændrer den. Det er muligt fordi
        // det er en referance til vores objekt og ikke objektet selv. Tror jeg.
        final TextView bacontext = (TextView) findViewById(R.id.bacontext);
        bacontext.setText(appleMessage);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                      .setAction("Action", null)
                      .show();
            }
        });
    }

    public void onClick(View view) {
        Intent i = new Intent(this, Apples.class);
        startActivity(i);
    }

}
