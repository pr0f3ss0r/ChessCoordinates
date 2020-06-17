package com.tosindroid.yes.chesscoordinates;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView randomSquareTextView, score, timerCountdown, stopButton;
    private String[] id;
    //private String get;
    int aboutToStart = 3;
    boolean clickable = false;
    private TextView[] textViews = new TextView[64];
    private final String[] squares = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8",
            "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8",
            "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8",
            "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8",
            "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8",
            "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8",
            "g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8",
            "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomSquareTextView = findViewById(R.id.randomSquaresTextView);
        score = findViewById(R.id.score);
        timerCountdown = findViewById(R.id.timerCountdown);
        stopButton = findViewById(R.id.stopButton);


        int counter;
        id = new String[]{
                "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8",
                "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8",
                "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8",
                "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8",
                "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8",
                "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8",
                "g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8",
                "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8"};

        for (int i = 0; i < id.length; i++) {
            counter = getResources().getIdentifier(id[i], "id", getPackageName());
            textViews[i] = findViewById(counter);
            textViews[i].setText(id[i]);
            textViews[i].setTag(id[i]);
            final String get = textViews[i].getTag().toString();
            int wid = getScreenWidth() / 8;
            textViews[i].setWidth(wid);
            textViews[i].setHeight(wid);
                textViews[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(clickable==true) {
                            randomSquareTextView.setText(squares[new Random().nextInt(squares.length - 1)]);
                            getTV();
                        }
                        Log.i("helloo", get);
                    }
                });

        }

        // getting the score and the timer selected from the previous activity

        Intent getTimer = getIntent();
        String timer = getTimer.getStringExtra("TIMER");
        timerCountdown.setText(timer);

        //display 3 seconds countdown and start the game immediately after the screen is opened.
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (aboutToStart > 0) {
                    randomSquareTextView.setText(String.valueOf(aboutToStart));
                    handler.postDelayed(this, 1000);
                    aboutToStart--;
                } else {
                    randomSquareTextView.setText(squares[new Random().nextInt(squares.length - 1)]);
                    clickable = true;
                }
            }
        });
    }


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public void getTV(){
        score.setText(randomSquareTextView.getText());

    }
}

