package com.example.gravityblock;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.nio.InvalidMarkException;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private Button chooseLevel;

    private ImageView gravityText;
    private ImageView blockText;
    private ImageView purpleBottom;
    private ImageView purpleTop;

    public static final String SHARED_PREFS = "GBSPs";
    public static final String LEVEL = "Level";

    private int levelUpTo;

    private int numLevels = LevelList.Levels.length - 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sps = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        levelUpTo = sps.getInt(LEVEL, 1);

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(levelUpTo != numLevels) {
                    launchPlayActivity(levelUpTo);
                }
                else{
                    launchPlayActivity(1);
                }
            }
        });

        chooseLevel = (Button) findViewById(R.id.chooseLevelButton);
        chooseLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity(ChooseLevel.class);
            }
        });

        gravityText = (ImageView) findViewById(R.id.gravityText);
        blockText = (ImageView) findViewById(R.id.blockText);
        purpleBottom = (ImageView) findViewById(R.id.HomePurpleBottom);
        purpleTop = (ImageView) findViewById(R.id.HomePurpleTop);






    }

    private void launchActivity(Class c) {

        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    private void launchPlayActivity(int levelNum) {

        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("levelNum", levelNum);

        startActivity(intent);
    }

}
