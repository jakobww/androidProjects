package com.example.jakobwilbrandt.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    //write objects to use later on.
    private TextView JakobsMsg;
    private GestureDetectorCompat gestureDetector; //Object to use for gestures


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        JakobsMsg = (TextView)findViewById(R.id.JakobsMsg); //connect the content from the XML to an object we can work with

        //Her sørger vi for at Objektet lytter.
        this.gestureDetector = new GestureDetectorCompat(this,this); //this.gestureDetector betyder at vi refererer til lige præcis dette lokale objekt. Ikke det globale som er defineret ovenfor
        gestureDetector.setOnDoubleTapListener(this);


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
        JakobsMsg.setText("onSingleTapConfirmed");
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
