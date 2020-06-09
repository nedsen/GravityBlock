package com.example.gravityblock;

import android.app.Dialog;
import android.content.Context;
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

public class PlayActivity extends AppCompatActivity {

    //Define the different components of the activity
    private RelativeLayout gameLayout;

    private ImageView rotateLeftButton;
    private ImageView rotateRightButton;
    private ImageView homeButton;
    private ImageView restartButton;

    private Level currentLevel;
    private int levelNum;

    //private LevelList levels= new LevelList(this);
    //The different square colors
    private SquareColor redSquare = new SquareColor(R.color.redSquareColor, R.drawable.red_square_background);
    private SquareColor yellowSquare = new SquareColor(R.color.yellowSquareColor, R.drawable.yellow_square_background);

    //List of the levels
//    private Level[] levels = new Level[]{
//            //Level 0
//            new Level(
//                    //Walls
//                    new Wall[]{
//                            new Wall(0, 0, 10, 1, this),
//                            new Wall(0, 0, 1, 10, this),
//                            new Wall(9, 0, 1, 10, this),
//                            new Wall(0, 9, 10, 1, this),
//                            new Wall(1, 3, 2, 1, this),
//                            new Wall(5, 1, 1, 8, this),
//                            new Wall(6, 3, 2, 1, this)
//                    },
//
//                    //Squares
//                    new Square[]{
//                            new Square(1, 1, 1, 8, redSquare, this),
//                            new Square(6, 1, 6, 8, yellowSquare, this),
//                            //new Square(3, 6, 0, 0, redSquare, this),
//                            //new Square(6, 4, 0, 0, redSquare, this)
//                    },
//
//                    //Size
//                    10,
//
//                    //Context
//                    this
//            ),
//            //Level 1
//            new Level(
//                    //Walls
//                    new Wall[]
//                    {
//                        new Wall (0, 0, 6, 1, this),
//                        new Wall (0, 1, 1, 4, this),
//                        new Wall (2, 1, 2, 3, this),
//                        new Wall (5, 1, 1, 5, this),
//                        new Wall (0, 5, 5, 1, this),
//                    },
//                    //Squares
//                    new Square[]{
//                        new Square(1, 1, 4, 1, redSquare, this)
//                    },
//                    //Size
//                    6,
//                    //Context
//                    this
//            ),
//
//            //Level 2
//            new Level(
//                    //Walls
//                    new Wall[]
//                    {
//                        new Wall (0, 0, 1, 6, this),
//                        new Wall (1, 0, 5, 1, this),
//                        new Wall (5, 1, 1, 5, this),
//                        new Wall (1, 3, 1, 1, this),
//                        new Wall (4, 4, 1, 1, this),
//                        new Wall (1, 5, 4, 1, this)
//                    },
//                    //Squares
//                    new Square[]{
//                            new Square(1, 1, 1, 4, redSquare, this)
//                    },
//                    //Size
//                    6,
//                    //Context
//                    this
//            ),
//
//            //Level 3
//            new Level(
//                    //Walls
//                    new Wall[]
//                            {
//                                    new Wall (0, 0, 1, 6, this),
//                                    new Wall (1, 0, 5, 1, this),
//                                    new Wall (5, 1, 1, 5, this),
//                                    new Wall (1, 5, 4, 1, this),
//                                    new Wall (2, 1, 1, 3, this),
//                                    new Wall (3, 3, 1, 1, this)
//                            },
//                    //Squares
//                    new Square[]{
//                            new Square(1, 1, 3, 2, redSquare, this)
//                    },
//                    //Size
//                    6,
//                    //Context
//                    this
//            ),
//
//            //Level 4
//            new Level(
//                    //Walls
//                    new Wall[]
//                            {
//                                    new Wall (0, 0, 1, 6, this),
//                                    new Wall (1, 0, 5, 1, this),
//                                    new Wall (5, 1, 1, 5, this),
//                                    new Wall (1, 5, 4, 1, this),
//                                    new Wall (1, 1, 2, 1, this),
//                                    new Wall (1, 3, 1, 1, this),
//                                    new Wall (4, 2, 1, 1, this)
//                            },
//                    //Squares
//                    new Square[]{
//                            new Square(1, 4, 4, 1, redSquare, this)
//                    },
//                    //Size
//                    6,
//                    //Context
//                    this
//            ),
//
//            //Level 5
//            new Level(
//                    //Walls
//                    new Wall[]
//                            {
//                                    new Wall (0, 0, 1, 6, this),
//                                    new Wall (1, 0, 5, 1, this),
//                                    new Wall (5, 1, 1, 5, this),
//                                    new Wall (1, 5, 4, 1, this),
//                                    new Wall (1, 2, 1, 1, this),
//                                    new Wall (2, 3, 1, 1, this),
//                                    new Wall (4, 4, 1, 1, this)
//                            },
//                    //Squares
//                    new Square[]{
//                            new Square(1, 1, 1, 3, redSquare, this)
//                    },
//                    //Size
//                    6,
//                    //Context
//                    this
//            ),
//
//            //Level 6
//            new Level(
//                    //Walls
//                    new Wall[]
//                            {
//                                    new Wall (0, 0, 10, 1, this),
//                                    new Wall (0, 1, 1, 8, this),
//                                    new Wall (0, 9, 10, 1, this),
//                                    new Wall (9, 1, 1, 8, this),
//                                    new Wall (1, 2, 1, 1, this),
//                                    new Wall (4, 2, 3, 1, this),
//                                    new Wall (3, 3, 1, 1, this),
//                                    new Wall (7, 3, 1, 1, this),
//                                    new Wall (1, 5, 1, 1, this),
//                                    new Wall (3, 5, 1, 2, this),
//                                    new Wall (6, 6, 1, 1, this),
//                                    new Wall (8, 6, 1, 1, this),
//                                    new Wall (2, 7, 1, 2, this),
//                                    new Wall (8, 8, 1, 1, this)
//                            },
//                    //Squares
//                    new Square[]{
//                            new Square(1, 1, 1, 8, redSquare, this)
//                    },
//                    //Size
//                    10,
//                    //Context
//                    this
//            ),
//
//            //Level 7
//            new Level(
//                    //Walls
//                    new Wall[]
//                            {
//                                    new Wall (0, 0, 10, 1, this),
//                                    new Wall (0, 1, 1, 8, this),
//                                    new Wall (0, 9, 10, 1, this),
//                                    new Wall (9, 1, 1, 8, this),
//                                    new Wall (2, 2, 2, 1, this),
//                                    new Wall (7, 1, 2, 1, this),
//                                    new Wall (6, 2, 1, 1, this),
//                                    new Wall (8, 2, 1, 1, this),
//                                    new Wall (5, 3, 1, 1, this),
//                                    new Wall (1, 5, 1, 1, this),
//                                    new Wall (4, 6, 2, 1, this),
//                                    new Wall (5, 5, 1, 1, this),
//                                    new Wall (8, 7, 1, 1, this),
//                                    new Wall (2, 8, 1, 1, this),
//                                    new Wall (8, 5, 1, 1, this)
//                            },
//                    //Squares
//                    new Square[]{
//                            new Square(5, 4, 7, 2, redSquare, this)
//                    },
//                    //Size
//                    10,
//                    //Context
//                    this
//            ),
//
//            //Level 8
//            new Level(
//                    //Walls
//                    new Wall[]
//                            {
//                                    new Wall (0, 0, 10, 1, this),
//                                    new Wall (0, 1, 1, 8, this),
//                                    new Wall (0, 9, 10, 1, this),
//                                    new Wall (9, 1, 1, 8, this),
//                                    new Wall (2, 1, 1, 2, this),
//                                    new Wall (5, 1, 1, 1, this),
//                                    new Wall (8, 2, 1, 1, this),
//                                    new Wall (4, 3, 1, 1, this),
//                                    new Wall (5, 5, 1, 3, this),
//                                    new Wall (2, 6, 1, 1, this),
//                                    new Wall (6, 6, 1, 1, this),
//                                    new Wall (8, 6, 1, 1, this),
//                                    new Wall (2, 8, 1, 1, this)
//                            },
//                    //Squares
//                    new Square[]{
//                            new Square(8, 8, 1, 1, redSquare, this)
//                    },
//                    //Size
//                    10,
//                    //Context
//                    this
//            ),
//
//            //Level 9
//            new Level(
//                    //Walls
//                    new Wall[]
//                            {
//                                    new Wall (0, 0, 10, 1, this),
//                                    new Wall (0, 1, 1, 8, this),
//                                    new Wall (0, 9, 10, 1, this),
//                                    new Wall (9, 1, 1, 8, this),
//                                    new Wall (3, 1, 1, 1, this),
//                                    new Wall (6, 1, 1, 1, this),
//                                    new Wall (1, 4, 1, 1, this),
//                                    new Wall (4, 5, 1, 1, this),
//                                    new Wall (3, 6, 1, 1, this),
//                                    new Wall (8, 6, 1, 1, this),
//                                    new Wall (5, 7, 1, 1, this),
//                                    new Wall (3, 8, 1, 1, this),
//                                    new Wall (3, 4, 1, 1, this)
//                            },
//                    //Squares
//                    new Square[]{
//                            new Square(4, 4, 3, 5, redSquare, this)
//                    },
//                    //Size
//                    10,
//                    //Context
//                    this
//            ),
//
//
//    };


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

        homeButton = (ImageView) findViewById(R.id.chooseLevelHomeButton);
        restartButton = (ImageView) findViewById(R.id.restartLevelButton);

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

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRestartDialog();
            }
        });

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
