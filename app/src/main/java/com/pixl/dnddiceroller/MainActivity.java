package com.pixl.dnddiceroller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.pixl.dnddiceroller.R;

import android.graphics.PorterDuff;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.seismic.ShakeDetector;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener {

    ImageButton fourSidedDie;
    TextView numberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);

        setContentView(R.layout.activity_main);

        fourSidedDie = findViewById(R.id.fourSidedDie);
        numberText = findViewById(R.id.numberText);

        //set die to unselected by default
        fourSidedDie.setSelected(false);




        fourSidedDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fourSidedDie.setColorFilter(0x80FFFFFF, PorterDuff.Mode.MULTIPLY);
                fourSidedDie.setSelected(true);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override public void hearShake() {
        if(fourSidedDie.isSelected()) {
            numberText.setText(String.valueOf(String.valueOf(dieRoll(4))));
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dice);
            mp.start();
        }
/*        if(sixSidedDie.isSelected()) {
            numberText.setText(String.valueOf(String.valueOf(dieRoll(6))));
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dice);
        mp.start();
        }*/
    }

    //this function simulates the dice being rolled
    //we pass in the int depending on which imageButton is selected
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private int dieRoll(int max) {
        return ThreadLocalRandom.current().nextInt(1,  max + 1);
    }
}
