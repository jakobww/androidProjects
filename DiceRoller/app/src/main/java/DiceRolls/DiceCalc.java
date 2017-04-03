package DiceRolls;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class DiceCalc {



    Context context;
    Activity activity;
    public static List<Integer> list = new ArrayList<>();
    public static Integer chance = 1;
    public static int predict = 10;
    Random rn = new Random();

    public DiceCalc(Context context, Activity activity){
        this.activity=activity;
        this.context=context;
    }

    CountDownTimer timer = new CountDownTimer(1000, 50) {

        public void onTick(long millisUntilFinished) {
            getViewFromClass("numberRolled").setTextSize(150);
            getViewFromClass("numberRolled").setText(""+(rn.nextInt(12 - 2 + 1)+2));
        }

    public void onFinish() {
        getViewFromClass("numberRolled").setText(list.get(list.size()-1).toString());
        if (list.size() > 1)
        {
            list.remove(list.size()-1);
        }
        else
        {
            diceList();
        }
    }
};

    public TextView getViewFromClass(String id)
    {
        return (TextView) this.activity.findViewById(this.context.getResources().getIdentifier(id,"id", this.context.getPackageName()));
    }


    public void diceList() {

           list.clear();

            for (int i = 0; i < chance * 1; i++) {
                list.add(2);
            }

            for (int i = 0; i < chance * 2; i++) {
                list.add(3);
            }

            for (int i = 0; i < chance * 3; i++) {
                list.add(4);
            }

            for (int i = 0; i < chance * 4; i++) {
                list.add(5);
            }

            for (int i = 0; i < chance * 5; i++) {
                list.add(6);
            }

            for (int i = 0; i < chance * 6; i++) {
                list.add(7);
            }

            for (int i = 0; i < chance * 5; i++) {
                list.add(8);
            }

            for (int i = 0; i < chance * 4; i++) {
                list.add(9);
            }

            for (int i = 0; i < chance * 3; i++) {
                list.add(10);
            }

            for (int i = 0; i < chance * 2; i++) {
                list.add(11);
            }

            for (int i = 0; i < chance * 1; i++) {
                list.add(12);
            }

        if (chance == 1) {
            for (int i = 0; i < predict/2; i++) {
                list.add((int) (Math.random() * 11 + 2));
            }
        }
        else
        {
            for (int i = 0; i < predict; i++) {
                list.add((int) (Math.random() * 11 + 2));
            }
        }


            for (int i = 0; i < new Random().nextInt(20) + 3; i++) {
                Collections.shuffle(list);
            }



    }

    public void rollDice() {

        timer.start();
    }

    public void chanceChange(){

        list.clear();
        getViewFromClass("numberRolled").setTextSize(90);

        if(chance == 1) {
            getViewFromClass("statisticText").setText("Less Predictable");
            chance = 2;
        }
        else if(chance == 2){
            getViewFromClass("statisticText").setText("Random");
            chance = 20;
        }
        else{
            getViewFromClass("statisticText").setText("Predictable");
            chance = 1;
        }
        getViewFromClass("numberRolled").setText("Hit me!");
        diceList();

    }


}



