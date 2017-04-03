package com.example.jakobwilbrandt.boundservices;

//Idéen med dette projekt er at finde ud af hvordan vi kan få vores service til at connecte og
// snakke med vores app (ændre tingene). En bound service lukker automatisk ned når den har
// udført sin opgave, hvorimod en 'normal' service er en baggrundsprocess der kører hele tiden

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.example.jakobwilbrandt.boundservices.MyService.MyLocalBinder;
import java.util.concurrent.TimeUnit;
import org.w3c.dom.Text;

public class MainActivity
      extends AppCompatActivity {
    int counter = 0;
    int roll = 0;

    MyService jakobsService;
    boolean isBound = false; //Denne variable bruger vi til at tjekke om denne client er bound
    // til en service. Til at starte med er den ikke derfor sætter vi den til false

    public void rollDice(View view) {
       int id;
        ImageView img = (ImageView) findViewById(R.id.gif);
        ImageView number = (ImageView) findViewById(R.id.number);
        if (roll == 1) {
            roll--;
            number.setImageAlpha(255);
            jakobsService.playRoll(img,0);
            String diceRoll = jakobsService.rollDice(counter);
            id = jakobsService.getIdFromString(diceRoll);
            number.setImageResource(id);
            counter++;

            if (diceRoll.equals("13"))
            {
                counter = 0;
                diceRoll = jakobsService.rollDice(counter);
            }
        }
        else{
            number.setImageAlpha(0);
            jakobsService.playRoll(img,1);
            roll++;
        }



        //TextView diceText = (TextView) findViewById(R.id.diceText);
        //diceText.setText(diceRoll);

        //Her ser vi hvordan jakobsService
        // (af klassen MyService) har adgnag til de metoder der ligger inde i MyService.
    }

    public void chanceChange(View view){
        counter = 0;
        ImageView number = (ImageView) findViewById(R.id.number);
        String idString = jakobsService.chance();
        int chanceID = jakobsService.getIdFromString(idString);
        ImageView chance = (ImageView) findViewById(R.id.statistik);
       chance.setImageResource(chanceID);
        number.setImageAlpha(0);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //Her binder vi vores service. Istedet for bare at starte den binder vi den nu sammen med
        // vores mainActivity også, således at vi kan tilgå metoderne i vores service.
        Intent i = new Intent(this, MyService.class);
        bindService(i, jakobsConnection, Context.BIND_AUTO_CREATE);
        //Her tager vi og bruger vores connection som er
        // af klassen ServiceConnection.


    }

    //Denne klasse beskriver hvad der skal ske når vi connecter til vores service og hvad der
    // skal når vi disconnecter
    private ServiceConnection jakobsConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            MyLocalBinder binder = (MyLocalBinder) service;
            jakobsService = binder.getService();
            //Her sørger vi for at jakobsService har adgang
            // til alle metoderne i MyService (getService returnerer en referance til den
            // service-klasse som vi har kørende
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}
