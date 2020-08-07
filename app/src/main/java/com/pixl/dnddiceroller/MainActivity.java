package com.pixl.dnddiceroller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    ImageButton fourSidedDie;
    Button rollButton;
    TextView numberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the XML file below is the main screen
        setContentView(R.layout.activity_main);

        fourSidedDie = findViewById(R.id.fourSidedDie);
        numberText = findViewById(R.id.numberText);
        rollButton = findViewById(R.id.rollButton);
        rollButton.setEnabled(false);


        //need img buttons, logic for buttons

        fourSidedDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //what happens when die is selected?
                //image shows up in center
                // and roll button is clickable
                rollButton.setEnabled(true);
            }
        });

        rollButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                numberText.setText(String.valueOf(dieRoll(4)));
            }
        });
    }

    //this function simulates the dice being rolled
    //we pass in the int depending on which imageButton is selected
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private int dieRoll(int max) {
        return ThreadLocalRandom.current().nextInt(1,  max + 1);
    }
}
