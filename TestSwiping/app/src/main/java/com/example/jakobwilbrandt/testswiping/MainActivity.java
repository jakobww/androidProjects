package com.example.jakobwilbrandt.testswiping;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    //write objects to use later on.
    private TextView JakobsMsg;
    private RelativeLayout BG;
    private Button button1;
    private GestureDetectorCompat gestureDetector; //Object to use for gestures


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        JakobsMsg = (TextView)findViewById(R.id.JakobsMsg); //connect the content from the XML to an object we can work with
        BG = (RelativeLayout) findViewById(R.id.BG);
        button1 = (Button)findViewById(R.id.button1);


        //Her sørger vi for at Objektet lytter.
        this.gestureDetector = new GestureDetectorCompat(this,this); //this.gestureDetector betyder at vi refererer til lige præcis dette lokale objekt. Ikke det globale som er defineret ovenfor
        gestureDetector.setOnDoubleTapListener(this);


        //Her sørger vi for at der kan trykkes på knappen.
        button1.setOnClickListener( //her fortæller vi at knappen skal lytte efter om der er nogen der klikker på den
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //Her skrives hvad knappen skal gøre når den bliver trykket.
                        TextView hejText = (TextView) findViewById(R.id.JakobsMsg); //laver en variable der forbindes med vores text hej. Vi kan nu behandle det som et objekt
                        hejText.setText("I just got tapped button");
                        BG.setBackgroundColor(Color.GREEN); //Her sætter vi baggrundsfarve til grøn vha. tap på knappen.
                    }
                }

        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /////////////////////BEGIN GESTURES///////////////////////
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        JakobsMsg.setText("I Just got tapped");
        BG.setBackgroundColor(Color.BLUE);
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        JakobsMsg.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        JakobsMsg.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        JakobsMsg.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        JakobsMsg.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        JakobsMsg.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        JakobsMsg.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        JakobsMsg.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        JakobsMsg.setText("onFling");
        return true;
    }

    /////////////////////END GESTURES///////////////////////



    //Here we override onTouchEvent. Normally it just checks if the user touches the screen. We want to check for gestures.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event); //FIRST we check if it was a special type of gesture
        return super.onTouchEvent(event);
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
