package com.example.gravityblock;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;

public class Movablock extends Fallable{



    public Movablock(int sx, int sy, int w, int h){
        X = sx;
        Y = sy;
        startX = sx;
        startY = sy;
        Height = h;
        Width = w;
    }
    public Movablock(Movablock m){
        this.X = m.X;
        this.Y = m.Y;
        this.startX = m.startX;
        this.startY = m.startY;
        this.Height = m.Height;
        this.Width = m.Width;
    }

    @Override
    public void setView(RelativeLayout container){
        float dpValue = context.getResources().getDisplayMetrics().density;

        view = new View(context);

        RelativeLayout.LayoutParams squareLayout = new RelativeLayout.LayoutParams((int) (Level.squareSize * dpValue * Width), (int) (Level.squareSize * dpValue * Height));
        squareLayout.setMargins((int) (X * dpValue * Level.squareSize), (int) (Y * dpValue * Level.squareSize), 0, 0);
        view.setLayoutParams(squareLayout);
        view.setBackground(context.getResources().getDrawable(R.color.movablockColor));

        container.addView(view);
    }

}
