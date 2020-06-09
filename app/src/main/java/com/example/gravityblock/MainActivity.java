package com.example.gravityblock;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchPlayActivity(0);
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
