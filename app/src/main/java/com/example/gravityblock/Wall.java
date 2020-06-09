package com.example.gravityblock;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

public class Wall {
    public int X;
    public int Y;
    public int Width;
    public int Height;

    //public RelativeLayout Container;
    public View WallView;

    private Context context;

    public Wall(int x, int y, int width, int height){
        X = x;
        Y = y;
        Width = width;
        Height = height;



    }


    public void setWallView(RelativeLayout container) {
        WallView = new View(context);
        float dpValue = context.getResources().getDisplayMetrics().density;

        RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams((int) (Width * dpValue * Level.squareSize), (int) (Height * dpValue * Level.squareSize));
        layout.setMargins((int) (X * dpValue * Level.squareSize), (int) (Y * dpValue * Level.squareSize), 0, 0);
        WallView.setLayoutParams(layout);
        WallView.setBackgroundColor(context.getResources().getColor(R.color.wallColor));
        container.addView(WallView);
    }

    public void setContext(Context c){
        context = c;
    }
}
