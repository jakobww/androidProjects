package com.example.jakobwilbrandt.intents;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

//Denne måde at lave en service på laver IKKE automatisk en thread. Det skal vi selv gøre.

public class MyService
      extends Service {

    private static final String TAG = "com.example.jakobwilbrandt.intents";

    public MyService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "On start is called");

        Runnable r = new Runnable() {
            //Herfra definerer vi hvad der skal ske når denne thread bliver kørt
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    long futureTime = System.currentTimeMillis() + 5000;
                    while (System.currentTimeMillis() < futureTime) {
                        try {
                            synchronized (this) {
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG, "Service is doing something");
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        Thread JakobsThread = new Thread(r);
        JakobsThread.start();
        return Service.START_STICKY; //Dette betyder at hvis vores service af en eller anden
        // grund crasher, så genstarter den automatisk
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "On destroy is called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
