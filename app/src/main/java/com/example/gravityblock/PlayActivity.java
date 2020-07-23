package com.example.gravityblock;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static com.example.gravityblock.MainActivity.LEVEL;
import static com.example.gravityblock.MainActivity.SHARED_PREFS;

public class PlayActivity extends AppCompatActivity {

    //Define the different components of the activity
    private RelativeLayout gameLayout;

    private ImageView rotateLeftButton;
    private ImageView rotateRightButton;
    private ImageView homeButton;
    private ImageView restartButton;
    private ImageView chooseLevelButton;
    private ImageView settingsButton;

    private Level currentLevel;
    private int levelNum;

    //private LevelList levels= new LevelList(this);
    //The different square colors
    //private SquareColor redSquare = new SquareColor(R.color.redSquareColor, R.drawable.red_square_background);
    //private SquareColor yellowSquare = new SquareColor(R.color.yellowSquareColor, R.drawable.yellow_square_background);



    Runnable afterRotation = new Runnable() {
        @Override
        public void run() {
            if(currentLevel.passed()){
                Handler g = new Handler();
                g.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showNextLevelDialog();
                    }
                }, 500);

                SharedPreferences sps = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
                int levelUpTo = sps.getInt(LEVEL, 1);

                //Increse the level up to if needed
                if(levelNum + 1 > levelUpTo){
                    SharedPreferences.Editor spsEdit = sps.edit();
                    spsEdit.putInt(LEVEL, levelNum + 1);
                    spsEdit.apply();
                }

            }
            else{
                rotateLeftButton.setEnabled(true);
                rotateRightButton.setEnabled(true);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        gameLayout = (RelativeLayout) findViewById(R.id.gameLayout);

        rotateLeftButton = (ImageView) findViewById(R.id.rotateLeftButton);
        rotateRightButton = (ImageView) findViewById(R.id.rotateRightButton);

        homeButton = (ImageView) findViewById(R.id.playHomeButton);
        restartButton = (ImageView) findViewById(R.id.restartLevelButton);
        chooseLevelButton = (ImageView) findViewById(R.id.playChooseLevelButton);
        settingsButton = (ImageView) findViewById(R.id.playSettingsButton);

        Bundle b = getIntent().getExtras();
        levelNum = b.getInt("levelNum");

        currentLevel = Level.setLevelContext(LevelList.Levels[levelNum], this);
        currentLevel.setLayout(gameLayout);



        rotateLeftButton.setEnabled(false);
        rotateRightButton.setEnabled(false);
        currentLevel.fall(0);
        Handler h = new Handler();
        h.postDelayed(afterRotation, currentLevel.maxFallDuration);


        rotateLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateLeftButton.setEnabled(false);
                rotateRightButton.setEnabled(false);

                currentLevel.rotateLeft();

                currentLevel.fall(currentLevel.rotationDuration);

                Handler h = new Handler();
                h.postDelayed(afterRotation, currentLevel.rotationDuration + currentLevel.maxFallDuration);


            }
        });

        rotateRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateLeftButton.setEnabled(false);
                rotateRightButton.setEnabled(false);

                currentLevel.rotateRight();

                currentLevel.fall(currentLevel.rotationDuration);

                Handler h = new Handler();
                h.postDelayed(afterRotation, currentLevel.rotationDuration + currentLevel.maxFallDuration);


            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        chooseLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity(ChooseLevel.class);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity(SettingsActivity.class);
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRestartDialog();
            }
        });

    }
    private void launchActivity(Class c) {

        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }
    private void showNextLevelDialog(){
        final Context c = this;
        final Dialog nextLevelDialog = new Dialog(c);
        nextLevelDialog.setContentView(R.layout.level_pass_dialog);

        Button nextLevelButton = (Button) nextLevelDialog.findViewById(R.id.nextLevelButton);
        nextLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to Next Level
                if(levelNum < LevelList.Levels.length - 1) {
                    levelNum++;
                }
                gameLayout.removeAllViews();
                gameLayout.setRotation(0);

                //Set the current level to the new level number
                currentLevel = Level.setLevelContext(LevelList.Levels[levelNum], c);
                currentLevel.setLayout(gameLayout);

                currentLevel.fall(0);
                Handler h = new Handler();
                h.postDelayed(afterRotation, currentLevel.maxFallDuration);

                nextLevelDialog.hide();
            }
        });

        Button retryLevelButton = (Button) nextLevelDialog.findViewById(R.id.DialogRetryButton);
        retryLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Restart Level

                gameLayout.removeAllViews();
                gameLayout.setRotation(0);

                //Set the current level to the new level number
                currentLevel = Level.setLevelContext(LevelList.Levels[levelNum], c);
                currentLevel.setLayout(gameLayout);

                currentLevel.fall(0);
                Handler h = new Handler();
                h.postDelayed(afterRotation, currentLevel.maxFallDuration);

                nextLevelDialog.hide();
            }
        });


        Button homeButton = (Button) nextLevelDialog.findViewById(R.id.dialogHomeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nextLevelDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        nextLevelDialog.show();
    }

    private void showRestartDialog(){
        final Context c = this;
        final Dialog restartDialog = new Dialog(c);
        restartDialog.setContentView(R.layout.restart_dialog);

        Button yesButton = (Button) restartDialog.findViewById(R.id.restartDialogYesButton);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Restart Level

                gameLayout.removeAllViews();
                gameLayout.setRotation(0);

                //Set the current level to the new level number
                currentLevel = Level.setLevelContext(LevelList.Levels[levelNum], c);
                currentLevel.setLayout(gameLayout);

                currentLevel.fall(0);
                Handler h = new Handler();
                h.postDelayed(afterRotation, currentLevel.maxFallDuration);

                restartDialog.hide();
            }
        });

        Button noButton = (Button) restartDialog.findViewById(R.id.restartDialogNoButton);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartDialog.hide();
            }
        });

        restartDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        restartDialog.show();
    }
}
