package com.example.jakobwilbrandt.boundservices;

import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.lang.Integer;
import java.util.Random;

public class MyService
      extends Service {

    //Dette objekt er bindeleddet mellem vores service og vores client / app
    private final IBinder jakobsBinder = new MyLocalBinder();

    public MyService() {
    }

    //Når vores MainActivity binder til en service går den nu ind i denne fil og kigger efter
    // onBind metoden. Her returnerer vi jakobBinder, som er en instance af klassen MyLocalBinder
    // . Dette objekt af klassen MyLocalBinder har nu mulighed for at tilgå alle de metoder der
    // findes i denne fil. Dermed kan vi fra vores mainActivity kalde de metoder som vi har
    // defineret i vores service fil
    @Override
    public IBinder onBind(Intent intent) {
        return jakobsBinder;
    }

    //Når man skal binde en service til en client skal man lave et objekt som extends Binder
    // class. Denne klasse kan nu binde to ting sammen. Det eneste som vi vil have at denne
    // klasse skal gøre er at returnere en referance til Superclass (her kaldet MyService). Når
    // vi (gennem dette objekt) får adgang til MyService, kan vi bruge de ting som findes i vores
    // Service klasse.

    //Det vil sige at hele pointen med koden i denne fil er at få tilgang til de metoder som rent
    // faktisk gør det vi gerne vil. På den måde kan vi (ud over at starte/stoppe vores service)
    // altså også kalde metoder i vores service class
    public class MyLocalBinder
          extends Binder {
        MyService getService() {
            return MyService.this;
        }

    }

    public static class rolledNumbers {

        public static List<Integer> list = new ArrayList<>();
        public static Integer chance = 1;
        public static int predict = 10;

    }

    public String chance()
    {
        if (rolledNumbers.chance == 1)
        {
            rolledNumbers.chance = 2;

        }
        else if (rolledNumbers.chance == 2)
        {
            rolledNumbers.chance = 20;
        }
        else
        {
            rolledNumbers.chance = 1;
        }

        if (rolledNumbers.chance == 1)
        {return "R.drawable.predictable";}

        else if (rolledNumbers.chance == 2)
        {return "R.drawable.less_random";}

        else
        {return "R.drawable.random";}
    }

    public int getIdFromString( String idStr )
    {
        int id = 0 ;

        switch(idStr)
        {
            case "R.drawable.random": id = R.drawable.random;
                break;

            case "R.drawable.less_random": id = R.drawable.less_random;
                break;

            case "R.drawable.predictable": id = R.drawable.predictable;
                break;

            case "10": id = R.drawable.n10;
                break;

            case "2": id = R.drawable.n2;
                break;

            case "3": id = R.drawable.n3;
                break;

            case "4": id = R.drawable.n4;
                break;

            case "5": id = R.drawable.n5;
                break;

            case "6": id = R.drawable.n6;
                break;

            case "7": id = R.drawable.n7;
                break;

            case "8": id = R.drawable.n8;
                break;

            case "9": id = R.drawable.n9;
                break;

            case "11": id = R.drawable.n11;
                break;

            case "12": id = R.drawable.n12;
                break;

            default: id = R.drawable.n2;
                break;
          }

        return id ;
    }

public void playRoll(ImageView img, int roll) {

    img.setBackgroundResource(R.drawable.spin_animation);
    AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

    if (roll == 1)
    {
        img.getBackground().setAlpha(255);
        frameAnimation.start();
    }

    else
    {
        img.getBackground().setAlpha(0);
    }
}

    public String rollDice(int count){




        if (count == 0) {

            rolledNumbers.list.clear();

            for (int i = 0; i < rolledNumbers.chance * 1; i++) {
                rolledNumbers.list.add(2);
            }

            for (int i = 0; i < rolledNumbers.chance * 2; i++) {
                rolledNumbers.list.add(3);
            }

            for (int i = 0; i < rolledNumbers.chance * 3; i++) {
                rolledNumbers.list.add(4);
            }

            for (int i = 0; i < rolledNumbers.chance * 4; i++) {
                rolledNumbers.list.add(5);
            }

            for (int i = 0; i < rolledNumbers.chance * 5; i++) {
                rolledNumbers.list.add(6);
            }

            for (int i = 0; i < rolledNumbers.chance * 6; i++) {
                rolledNumbers.list.add(7);
            }

            for (int i = 0; i < rolledNumbers.chance * 5; i++) {
                rolledNumbers.list.add(8);
            }

            for (int i = 0; i < rolledNumbers.chance * 4; i++) {
                rolledNumbers.list.add(9);
            }

            for (int i = 0; i < rolledNumbers.chance * 3; i++) {
                rolledNumbers.list.add(10);
            }

            for (int i = 0; i < rolledNumbers.chance * 2; i++) {
                rolledNumbers.list.add(11);
            }

            for (int i = 0; i < rolledNumbers.chance * 1; i++) {
                rolledNumbers.list.add(12);
            }

            for (int i = 0; i < rolledNumbers.predict; i++)
            {
                rolledNumbers.list.add((int)(Math.random() * 12 + 2));
            }

            for (int i = 0; i < new Random().nextInt(20) + 3; i++) {
                Collections.shuffle(rolledNumbers.list);
            }

            rolledNumbers.list.add(13);

            return Integer.toString(rolledNumbers.list.get(count));
        }
        else
        {
           return Integer.toString(rolledNumbers.list.get(count));
        }

    }



}
