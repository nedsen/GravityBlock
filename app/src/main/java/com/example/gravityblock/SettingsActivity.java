package com.example.gravityblock;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.gravityblock.MainActivity.LEVEL;
import static com.example.gravityblock.MainActivity.SHARED_PREFS;

public class SettingsActivity extends AppCompatActivity {

    private Button increaseButton;
    private Button resetButton;
    private TextView numText;
    private int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        numText = (TextView) findViewById(R.id.tempTextView);
        increaseButton = (Button) findViewById(R.id.tempButton);
        resetButton = (Button) findViewById(R.id.tempButton2);

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sps = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
                SharedPreferences.Editor spsEdit = sps.edit();
                if(number < 25) {
                    number++;
                }
                numText.setText(String.valueOf(number));
                spsEdit.putInt(LEVEL, number);
                spsEdit.apply();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sps = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
                SharedPreferences.Editor spsEdit = sps.edit();

                number = 1;
                numText.setText(String.valueOf(number));
                spsEdit.putInt(LEVEL, number);
                spsEdit.apply();

                SharedPreferences spsActual = getSharedPreferences(Level.LEVEL_SAVED_PREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor spsEditActual = spsActual.edit();
                for(int i = 1; i < 6; i++) {
                    spsEditActual.putBoolean(Level.LEVEL_MIN_MOVES_STRINGS[i], false);
                    spsEditActual.putBoolean(Level.LEVEL_COMPLETED_STRINGS[i], false);
                    spsEditActual.putBoolean(Level.LEVEL_UNLOCKED_STRINGS[i], true);
                }
                for(int i = 6; i < Level.LEVEL_UNLOCKED_STRINGS.length; i++){
                    spsEditActual.putBoolean(Level.LEVEL_MIN_MOVES_STRINGS[i], false);
                    spsEditActual.putBoolean(Level.LEVEL_COMPLETED_STRINGS[i], false);
                    spsEditActual.putBoolean(Level.LEVEL_UNLOCKED_STRINGS[i], false);
                }
                spsEditActual.apply();
            }
        });
        loadNumber();

    }
    public void loadNumber(){
        SharedPreferences sps = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        number = sps.getInt(LEVEL, 1);
        numText.setText(String.valueOf(number));
    }
}
