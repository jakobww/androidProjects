package com.example.jakobwilbrandt.intents;

//Vi har her lavet en helt ny class fra bunden

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

//Vi lader som om denne intentservice skal download billeder i baggrunden. En intentservice er en
// process der kører i baggrunden. Den fungerer ligesom en thread med en handler (den bliver bare
// lavet automatisk når man sætter en service op
public class JakobsIntentService
      extends IntentService {

    private static final String TAG = "com.example.jakobwilbrandt.intents";

    public JakobsIntentService() {
        super("JakobsIntentService"); //Vi fortæller vores superclass hvad denne class hedder
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does. The code
        Log.i(TAG, "The service is now running"); //Husk herefter at ændre manifestet
    }
}
