package com.tosindroid.yes.chesscoordinates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class LevelActivity extends AppCompatActivity {

    private Spinner selectLevel, selectTime;
    private Button start;
    private String selectedTimer, timerValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        selectLevel = findViewById(R.id.selectLevel);
        selectTime = findViewById(R.id.selectTime);
        start = findViewById(R.id.start);


        ArrayAdapter<CharSequence> levelAdapter =  ArrayAdapter.createFromResource(this, R.array.selectLevel, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> timeAdapter =  ArrayAdapter.createFromResource(this, R.array.selectTime, android.R.layout.simple_spinner_dropdown_item);

        selectLevel.setAdapter(levelAdapter);
        selectTime.setAdapter(timeAdapter);

          selectTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   selectedTimer = parent.getSelectedItem().toString();
                  switch (selectedTimer){
                      case "30secs":
                          timerValue = "30";
                          break;
                      case "1 min":
                          timerValue = "60";
                          break;
                      case "1:30secs":
                          timerValue = "90";
                          break;
                      case "2 mins":
                          timerValue = "120";
                          break;
                      case "3 mins":
                          timerValue = "180";
                          break;
                  }


              }

              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
          });


        // setting the TextView to show randomSquares after the start button is clicked

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting random square coordinates string
                Intent mainIntent = new Intent(LevelActivity.this, MainActivity.class);
                mainIntent.putExtra("TIMER", timerValue);
                startActivity(mainIntent);

            }
        });


    }

}
