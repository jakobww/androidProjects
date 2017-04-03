package com.example.jakobwilbrandt.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Apples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apples);


        //Her initiere vi et intent (vores service) og starter intent.
        Intent intentService1 = new Intent(this, MyService.class);
        startService(intentService1);

        //Her får vi vores IntentService til at launche
        Intent intentService2 = new Intent(this, JakobsIntentService.class);
        startService(intentService2);// Husk også at sætte et log filter så vi kun får den ene besked ud.


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    //Vi behøver ikke sætte en listener op, da vi har gjort det på en simpel måde i vores XML kode for knappen
    public void onClick(View view){
        Intent i = new Intent(this,Bacon.class);
        final EditText messageToSend = (EditText) findViewById(R.id.messageToSend);
        String userMessage = messageToSend.getText().toString();

i.putExtra("AppleMessage", userMessage);
        startActivity(i);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apples, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
