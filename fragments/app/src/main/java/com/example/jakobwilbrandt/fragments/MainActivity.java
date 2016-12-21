package com.example.jakobwilbrandt.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements topsectionfragment.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


    //Vores fragment bruger en metode der hedder createMeme. Da vi har linket vores fragment til vores mainActivity SKAL vores mainactivity java fil implementerer createMeme.
    //denne metode bliver kaldt af topsectionfragment, når brugeren trykker på knappen.
    //Vha. vores fragment manager finder vi det fragment der er blevet lavet (fragment2) og putter det ind i et fragment af typen bottompicturefragment (bottomfragment).
    // Nu kan vi bearbejde vores fragment og kalde vores setMemeText på det. Denne metode er implementeret i bottomMemeFragment. Bemærk at dette kun er implementering af den metoder der laver meme.
    @Override
    public void createMeme(String top, String bottom) {
bottompicturefragment bottomfragment = (bottompicturefragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomfragment.setMemeText(top, bottom);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
