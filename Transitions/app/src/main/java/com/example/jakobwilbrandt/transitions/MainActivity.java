package com.example.jakobwilbrandt.transitions;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager; //sørger for at vi kan bruge animationer


public class MainActivity extends AppCompatActivity {

//vi laver en reference til vores layout
    ViewGroup mainView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView = (ViewGroup) findViewById(R.id.mainView);
        mainView.setOnTouchListener(

                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        moveButton();
                        return true;
                    }
                }

        );
    }



    public void moveButton() {
        View button = (View) findViewById(R.id.button);


        //Kigger på den første state af vores layout, og det sidste state og gætter så selv (bruger en default) animation
        TransitionManager.beginDelayedTransition(mainView);

        //change the position
        //Vi laver en positionRules (af typen RelativeLayout.LayoutParams) som vi kan bruge til at ændre reglerne
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        button.setLayoutParams(positionRules);
        


        //change the size

        ViewGroup.LayoutParams sizeRules = button.getLayoutParams();
        sizeRules.width = 250;
        sizeRules.height = 450;
        //her fortæller vi knappen at den skal bruge sizeRules.
        button.setLayoutParams(sizeRules);


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
