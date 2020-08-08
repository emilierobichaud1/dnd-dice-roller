package com.pixl.dnddiceroller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    ImageView dndIcon;
    ImageView fourSideImage;
    ImageView sixSideImage;
    ImageView eightSideImage;
    ImageView tenSideImage;
    ImageView twelveSideImage;
    ImageView twentySideImage;
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

        //TODO initialize images using the id given in xml code
        //initialize imageviews
        dndIcon = findViewById(R.id.dndIcon);

        //initialize all die as invisible

/*        fourSideImage.setVisibility(View.INVISIBLE);
        sixSideImage.setVisibility(View.INVISIBLE);
        eightSideImage.setVisibility(View.INVISIBLE);
        tenSideImage.setVisibility(View.INVISIBLE);
        twelveSideImage.setVisibility(View.INVISIBLE);
        twentySideImage.setVisibility(View.INVISIBLE);*/

        //set all dice to unselected by default
        fourSidedDie.setSelected(false);
        sixSidedDie.setSelected(false);
        eightSidedDie.setSelected(false);
        tenSidedDie.setSelected(false);
        twelveSidedDie.setSelected(false);
        twentySidedDie.setSelected(false);

        //TODO add onClickListener for 10, 12, 20
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

                //TODO set visibility for each image
                //show icon on click
                //fourSideImage.setVisibility(View.VISIBLE);

                //TODO the rest should be invisible
                dndIcon.setVisibility(View.INVISIBLE);

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

        tenSidedDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tenSidedDie.setColorFilter(0xE6FFFFFF);
                tenSidedDie.setSelected(true);

                fourSidedDie.setSelected(false);
                fourSidedDie.setColorFilter(null);
                sixSidedDie.setSelected(false);
                sixSidedDie.setColorFilter(null);
                twelveSidedDie.setSelected(false);
                twelveSidedDie.setColorFilter(null);
                eightSidedDie.setSelected(false);
                eightSidedDie.setColorFilter(null);
                twentySidedDie.setSelected(false);
                twentySidedDie.setColorFilter(null);
            }
        });

        twelveSidedDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twelveSidedDie.setColorFilter(0xE6FFFFFF);
                twelveSidedDie.setSelected(true);

                fourSidedDie.setSelected(false);
                fourSidedDie.setColorFilter(null);
                sixSidedDie.setSelected(false);
                sixSidedDie.setColorFilter(null);
                tenSidedDie.setSelected(false);
                tenSidedDie.setColorFilter(null);
                eightSidedDie.setSelected(false);
                eightSidedDie.setColorFilter(null);
                twentySidedDie.setSelected(false);
                twentySidedDie.setColorFilter(null);
            }
        });

        twentySidedDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twentySidedDie.setColorFilter(0xE6FFFFFF);
                twentySidedDie.setSelected(true);

                fourSidedDie.setSelected(false);
                fourSidedDie.setColorFilter(null);
                sixSidedDie.setSelected(false);
                sixSidedDie.setColorFilter(null);
                tenSidedDie.setSelected(false);
                tenSidedDie.setColorFilter(null);
                eightSidedDie.setSelected(false);
                eightSidedDie.setColorFilter(null);
                twelveSidedDie.setSelected(false);
                twelveSidedDie.setColorFilter(null);
            }
        });

    }

    // TODO add action for 12, 20 die
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
        if(twelveSidedDie.isSelected()) {
            numberText.setText(String.valueOf(dieRoll(12)));
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dice);
            mp.start();
        }
        if(twentySidedDie.isSelected()) {
            numberText.setText(String.valueOf(dieRoll(20)));
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
