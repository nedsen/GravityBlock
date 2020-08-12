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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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

    private TextView movesText;
    private TextView levelNumText;
    private TextView levelTextText;

    private Level currentLevel;
    private int levelNum;

    private int numMoves;

    public int activityOrigin;

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

                SharedPreferences sps = getSharedPreferences(Level.LEVEL_SAVED_PREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor spsEdit1 = sps.edit();
                SharedPreferences.Editor spsEdit2 = sps.edit();
                //spsEdit.putBoolean(Level.LEVEL_COMPLETED_STRINGS[3], true);

                boolean completed = sps.getBoolean(Level.LEVEL_COMPLETED_STRINGS[levelNum], false);
                if(!completed){
                    spsEdit1.putBoolean(Level.LEVEL_COMPLETED_STRINGS[levelNum], true);
                    spsEdit1.apply();
                    int completeInRow = 0;
                    int levelRow = ((levelNum - 1) / 5);
                    for(int i = 0; i < 5; i ++){
                        boolean c = sps.getBoolean(Level.LEVEL_COMPLETED_STRINGS[5 * levelRow + i + 1], false);
                        if(c){
                            completeInRow ++;
                        }
                    }
                    if(completeInRow == 3){
                        for(int i = 0; i < 5; i++){
                            spsEdit2.putBoolean(Level.LEVEL_UNLOCKED_STRINGS[5 * (levelRow) + i + 6], true);
                            spsEdit2.apply();
                            Toast newLevelsToast = Toast.makeText(getApplicationContext(), "New Levels Unlocked", Toast.LENGTH_LONG);
                            newLevelsToast.show();
                        }
                    }
                }

                SharedPreferences.Editor spsEditMinMoves = sps.edit();

                boolean minMoves = sps.getBoolean(Level.LEVEL_MIN_MOVES_STRINGS[levelNum], false);
                if(!minMoves && numMoves <= currentLevel.minMoves){
                    spsEditMinMoves.putBoolean(Level.LEVEL_MIN_MOVES_STRINGS[levelNum], true);
                    spsEditMinMoves.apply();
                }
                //int levelUpTo = sps.getInt(LEVEL, 1);

                //Increse the level up to if needed
                /*if(levelNum + 1 > levelUpTo){
                    SharedPreferences.Editor spsEdit = sps.edit();
                    spsEdit.putInt(LEVEL, levelNum + 1);
                    spsEdit.apply();
                }*/

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

        movesText = (TextView) findViewById(R.id.movesText);
        levelNumText = (TextView) findViewById(R.id.levelNumText);
        levelTextText = (TextView) findViewById(R.id.levelTextText);

        Bundle b = getIntent().getExtras();
        levelNum = b.getInt("levelNum");
        levelNumText.setText("Level " + String.valueOf(levelNum));

        activityOrigin = b.getInt("origin");

        currentLevel = Level.setLevelContext(LevelList.Levels[levelNum], this);
        currentLevel.setLayout(gameLayout);
        levelTextText.setText(currentLevel.levelText);

        numMoves = 0;
        movesText.setText("Moves: " + String.valueOf(numMoves));

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

                numMoves ++;
                movesText.setText("Moves: " + String.valueOf(numMoves));

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

                numMoves ++;
                movesText.setText("Moves: " + String.valueOf(numMoves));

                currentLevel.rotateRight();

                currentLevel.fall(currentLevel.rotationDuration);

                Handler h = new Handler();
                h.postDelayed(afterRotation, currentLevel.rotationDuration + currentLevel.maxFallDuration);


            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        chooseLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToChooseLevel();
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
    }
    private void showNextLevelDialog(){
        final Context c = this;
        final Dialog nextLevelDialog = new Dialog(c);
        nextLevelDialog.setContentView(R.layout.level_pass_dialog);
        nextLevelDialog.setCancelable(false);

        final TextView dialogMovesText = (TextView) nextLevelDialog.findViewById(R.id.dialogMovesText);
        TextView minMovesText = (TextView) nextLevelDialog.findViewById(R.id.dialogMinMovesText);
        TextView congratsText = (TextView) nextLevelDialog.findViewById(R.id.dialogCongratsText);

        dialogMovesText.setText("Moves: " + String.valueOf(numMoves));
        minMovesText.setText("Minimum Moves: " + String.valueOf(currentLevel.minMoves));

        if(numMoves == currentLevel.minMoves){
            congratsText.setText("Excellent!");
        }
        else if(numMoves < currentLevel.minMoves - 3){
            congratsText.setText("Great Job!");
        }
        else{
            congratsText.setText("Good");
        }

        Button nextLevelButton = (Button) nextLevelDialog.findViewById(R.id.nextLevelButton);
        nextLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to Next Level if it is unlocked
                SharedPreferences sps = getSharedPreferences(Level.LEVEL_SAVED_PREFERENCES, Context.MODE_PRIVATE);

                boolean unlocked = sps.getBoolean(Level.LEVEL_UNLOCKED_STRINGS[levelNum + 1], false);

                if(levelNum < LevelList.Levels.length - 1 && unlocked) {
                    levelNum++;

                    levelNumText.setText("Level " + String.valueOf(levelNum));
                    numMoves = 0;
                    movesText.setText("Moves: " + String.valueOf(numMoves));

                    gameLayout.removeAllViews();
                    gameLayout.setRotation(0);

                    //Set the current level to the new level number
                    currentLevel = Level.setLevelContext(LevelList.Levels[levelNum], c);
                    currentLevel.setLayout(gameLayout);
                    levelTextText.setText(currentLevel.levelText);

                    currentLevel.fall(0);
                    Handler h = new Handler();
                    h.postDelayed(afterRotation, currentLevel.maxFallDuration);

                    nextLevelDialog.hide();
                }
                else if (!unlocked){
                    //Toast
                    Toast notUnlockedToast = Toast.makeText(getApplicationContext(), "The next level is not yet unlocked", Toast.LENGTH_LONG);
                    notUnlockedToast.show();
                }
                else if(levelNum == LevelList.Levels.length){
                    //Toast
                    Toast notAvailableToast = Toast.makeText(getApplicationContext(), "Last level: the next level is not yet available", Toast.LENGTH_LONG);
                }
            }
        });

        Button retryLevelButton = (Button) nextLevelDialog.findViewById(R.id.DialogRetryButton);
        retryLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Restart Level
                gameLayout.removeAllViews();
                gameLayout.setRotation(0);

                //Set number of Moves to 0
                numMoves = 0;
                movesText.setText("Moves: " + String.valueOf(numMoves));

                //Set the current level to the new level number
                currentLevel = Level.setLevelContext(LevelList.Levels[levelNum], c);
                currentLevel.setLayout(gameLayout);

                currentLevel.fall(0);
                Handler h = new Handler();
                h.postDelayed(afterRotation, currentLevel.maxFallDuration);

                nextLevelDialog.hide();
            }
        });

        Button dialogChooseLevelButton = (Button) nextLevelDialog.findViewById(R.id.DialogChooseLevelButton);
        dialogChooseLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToChooseLevel();
            }
        });


        Button homeButton = (Button) nextLevelDialog.findViewById(R.id.dialogHomeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
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

                //Set number of Moves to 0
                numMoves = 0;
                movesText.setText("Moves: " + String.valueOf(numMoves));

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

    private void goHome(){
        if(activityOrigin == Origins.CHOOSE_LEVEL){
            ChooseLevel.chooseLevelActivity.finish();
        }
        finish();
    }
    private void goToChooseLevel(){
        if(activityOrigin == Origins.CHOOSE_LEVEL){
            ChooseLevel.chooseLevelActivity.finish();
        }
        Intent intent = new Intent(this, ChooseLevel.class);
        startActivity(intent);
        overridePendingTransition(R.anim.ltr_enter, R.anim.no_transition);
        finishAfterTransition();
    }
    private void goToSettings(){
        launchActivity(SettingsActivity.class);
    }
}
