package com.example.jakobwilbrandt.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;



public class topsectionfragment extends Fragment {



    //Vi laver dem her for at kunne gemme det input vi får. De forskellige fragments kommunikerer ALTID via vores activity. Aldrig direkte til hinanden.
    private static EditText topTextInput;
    private static EditText bottomTextInput;


    TopSectionListener activiyCommander;

    public interface TopSectionListener{
        public void createMeme(String top, String bottom);
    }


    //On attach bliver kaldt når main activity bruger fragment. OnCreate bliver kaldt når mainActivity starter op. Oncreate kalder nu onAttatch
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activiyCommander = (TopSectionListener) activity;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString());
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topsectionfragment,container,false);


        //Vi linker her layout til objekter
topTextInput = (EditText)view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText)view.findViewById(R.id.bottomTextInput);
final Button button = (Button) view.findViewById(R.id.button);



        //Vi fortæller knappen at den skal lytte og hvad den skal gøre
        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        buttonClicked(v);
                    }
                }

        );

        return view;
    }


    //her gør vi det lidt pænere at se på, sådan at vi nemmere kan finde den kode der bliver kaldt når knappen bliver tapped.
    // Læg mærke til at createMeme bliver kaldt her når knappen bliver trykket. Vi tager vores lokale objekter (bottomTextInput og topTextInput) og får den tekst som brugeren har skrevet.
    //Nu sender vi den tekst med som parametre til den metode som er implementeret i vores mainActivity, således at mainActivity kan kalde createMeme, som nu snakker sammen med fragment2 (billedet)
    public void buttonClicked(View view)
    {
activiyCommander.createMeme(topTextInput.getText().toString(),bottomTextInput.getText().toString());
    }
}
