package com.tosindroid.yes.chesscoordinates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button play_btn, learn_btn, settings_btn, credits_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        play_btn = findViewById(R.id.play_btn);
        learn_btn = findViewById(R.id.learn_btn);
        settings_btn = findViewById(R.id.settings_btn);
        credits_btn = findViewById(R.id.credits_btn);

       play_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent levelIntent = new Intent(WelcomeActivity.this, LevelActivity.class);
               startActivity(levelIntent);
           }
       });

        learn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent learnIntent = new Intent(WelcomeActivity.this, LearnActivity.class);
                startActivity(learnIntent);
            }
        });

        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(WelcomeActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        credits_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creditsIntent = new Intent(WelcomeActivity.this, CreditsActivity.class);
                startActivity(creditsIntent);
            }
        });








    }
}
