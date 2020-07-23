package com.example.gravityblock;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static com.example.gravityblock.MainActivity.LEVEL;
import static com.example.gravityblock.MainActivity.SHARED_PREFS;

public class ChooseLevel extends AppCompatActivity {

    private RelativeLayout levelButtonLayout;
    int numLevels = LevelList.Levels.length - 1;
    private Button[] buttons;

    private ImageView homeButton;
    private ImageView settingsButton;

    int screenHeight;
    int screenWidth;
    float dpValue;

    int topButtonsHeight = 100;
    int topBottomMargins = 16;
    int leftRightMargins = 16;
    int buttonSpacing = 16;




    public int levelUpTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
        dpValue = getResources().getDisplayMetrics().density;

        //Check What level the user is up to
        loadLevelUpTo();

        homeButton = (ImageView) findViewById(R.id.chooseLevelHomeButton);
        settingsButton = (ImageView) findViewById(R.id.chooseLevelSettingsButton);


        levelButtonLayout = findViewById(R.id.chooseLevelButtonLayout);

        int layoutWidth = levelButtonLayout.getWidth();

        float buttonSize = (float)(screenWidth - 3 * leftRightMargins - 6 * buttonSpacing) / (float)(5);

        buttons = new Button[numLevels];

        for(int i = 0; i < numLevels; i++){
            Button b = new Button(this);
            b.setText(String.valueOf(i + 1));
            RelativeLayout.LayoutParams bParams = new RelativeLayout.LayoutParams((int)buttonSize * (int)(dpValue), (int)buttonSize * (int)(dpValue));
            int x = i % 5;
            int y = i / 5;
            bParams.setMargins((int)(((i % 5) * (buttonSpacing + buttonSize) + buttonSpacing)) * (int)(dpValue), (int)(((i / 5) * (buttonSpacing + buttonSize) + buttonSpacing)) * (int)(dpValue), buttonSpacing, buttonSpacing);

            b.setLayoutParams(bParams);

            if(i > levelUpTo - 1){
                b.setBackgroundColor(getResources().getColor(R.color.unclickableLevelColor));
                b.setTextColor(getResources().getColor(R.color.unclickableTextColor));
            }
            buttons[i] = b;
            levelButtonLayout.addView(b);
        }

        for(int i = 0; i < levelUpTo; i ++){
            final int levelNum = i + 1;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchPlayActivity(levelNum);
                }
            });
        }

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity(SettingsActivity.class);
            }
        });

    }
    private void launchActivity(Class c) {

        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }
    private void launchPlayActivity(int levelNum) {

        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("levelNum", levelNum);

        startActivity(intent);
        finish();
    }

    public void loadLevelUpTo(){
        SharedPreferences sps = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        levelUpTo = sps.getInt(LEVEL, 1);
    }

}
