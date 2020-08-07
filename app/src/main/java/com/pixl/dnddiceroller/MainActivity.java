package com.pixl.dnddiceroller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.seismic.ShakeDetector;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener {

    ImageButton fourSidedDie;
    ImageButton sixSidedDie;
    ImageButton eightSidedDie;
    ImageButton tenSidedDie;
    ImageButton twelveSidedDie;
    ImageButton twentySidedDie;
    TextView numberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialize shake detector
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);

        //set screen to activity_main.xml
        setContentView(R.layout.activity_main);

        //initialize image buttons
        fourSidedDie = findViewById(R.id.fourSidedDie);
        sixSidedDie = findViewById(R.id.sixSidedDie);
        eightSidedDie = findViewById(R.id.eightSidedDie);
        tenSidedDie = findViewById(R.id.tenSidedDie);
        twelveSidedDie = findViewById(R.id.twelveSidedDie);
        twentySidedDie = findViewById(R.id.twentySidedDie);

        //initialize number text
        numberText = findViewById(R.id.numberText);

        //set all dice to unselected by default
        fourSidedDie.setSelected(false);
        sixSidedDie.setSelected(false);
        eightSidedDie.setSelected(false);
        tenSidedDie.setSelected(false);
        twelveSidedDie.setSelected(false);
        twentySidedDie.setSelected(false);

        //set on click listeners for each image button
        fourSidedDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fourSidedDie.setColorFilter(0xE6FFFFFF);
                fourSidedDie.setSelected(true);

                sixSidedDie.setSelected(false);
                sixSidedDie.setColorFilter(null);
                eightSidedDie.setSelected(false);
                eightSidedDie.setColorFilter(null);
                tenSidedDie.setSelected(false);
                tenSidedDie.setColorFilter(null);
                twelveSidedDie.setSelected(false);
                twelveSidedDie.setColorFilter(null);
                twentySidedDie.setSelected(false);
                twentySidedDie.setColorFilter(null);
            }
        });

        sixSidedDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sixSidedDie.setColorFilter(0xE6FFFFFF);
                sixSidedDie.setSelected(true);

                fourSidedDie.setSelected(false);
                fourSidedDie.setColorFilter(null);
                eightSidedDie.setSelected(false);
                eightSidedDie.setColorFilter(null);
                tenSidedDie.setSelected(false);
                tenSidedDie.setColorFilter(null);
                twelveSidedDie.setSelected(false);
                twelveSidedDie.setColorFilter(null);
                twentySidedDie.setSelected(false);
                twentySidedDie.setColorFilter(null);
            }
        });

        eightSidedDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eightSidedDie.setColorFilter(0xE6FFFFFF);
                eightSidedDie.setSelected(true);

                fourSidedDie.setSelected(false);
                fourSidedDie.setColorFilter(null);
                sixSidedDie.setSelected(false);
                sixSidedDie.setColorFilter(null);
                tenSidedDie.setSelected(false);
                tenSidedDie.setColorFilter(null);
                twelveSidedDie.setSelected(false);
                twelveSidedDie.setColorFilter(null);
                twentySidedDie.setSelected(false);
                twentySidedDie.setColorFilter(null);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override public void hearShake() {
        if(fourSidedDie.isSelected()) {
            numberText.setText(String.valueOf(dieRoll(4)));
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dice);
            mp.start();
        }
        if(sixSidedDie.isSelected()) {
            numberText.setText(String.valueOf(dieRoll(6)));
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dice);
            mp.start();
        }
        if(eightSidedDie.isSelected()) {
            numberText.setText(String.valueOf(dieRoll(8)));
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dice);
            mp.start();
        }
        if(tenSidedDie.isSelected()) {
            numberText.setText(String.valueOf(dieRoll(10)));
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dice);
            mp.start();
        }
    }

    //this function simulates the dice being rolled
    //we pass in the int depending on which imageButton is selected
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private int dieRoll(int max) {
        return ThreadLocalRandom.current().nextInt(1,  max + 1);
    }
}
