package com.example.gravityblock;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;

public class Square extends Fallable {


    public int goalX;
    public int goalY;

    
    public View goal;

    private SquareColor color;

    public Square(int sx, int sy, int gx, int gy, SquareColor col){
        startX = sx;
        startY = sy;
        X = sx;
        Y = sy;
        goalX = gx;
        goalY = gy;
        Width = 1;
        Height = 1;

        color = col;

        hasBackView = true;
    }

    public Square(Square s){
        this.startX = s.startX;
        this.startY = s.startY;
        this.X = s.X;
        this.Y = s.Y;
        this.Width = 1;
        this.Height = 1;
        this.goalX = s.goalX;
        this.goalY = s.goalY;
        this.color = s.color;

        hasBackView = true;
    }

    public void setSquareView(RelativeLayout container){
        float dpValue = context.getResources().getDisplayMetrics().density;

        view = new View(context);

        RelativeLayout.LayoutParams squareLayout = new RelativeLayout.LayoutParams((int) (Level.squareSize * dpValue), (int) (Level.squareSize * dpValue));
        squareLayout.setMargins((int) (X * dpValue * Level.squareSize), (int) (Y * dpValue * Level.squareSize), 0, 0);
        view.setLayoutParams(squareLayout);

        view.setBackground(context.getResources().getDrawable(color.squareBackground));

        container.addView(view);
    }
    public void setSquareBackView(RelativeLayout container){
        float dpValue = context.getResources().getDisplayMetrics().density;

        backView = new View(context);

        RelativeLayout.LayoutParams squareLayout = new RelativeLayout.LayoutParams((int) (Level.squareSize * dpValue), (int) (Level.squareSize * dpValue));
        squareLayout.setMargins((int) (X * dpValue * Level.squareSize), (int) (Y * dpValue * Level.squareSize), 0, 0);
        backView.setLayoutParams(squareLayout);

        backView.setBackgroundColor(context.getResources().getColor(R.color.squareBackColor));

        container.addView(backView);
    }
    public void setGoalView(RelativeLayout container){
        float dpValue = context.getResources().getDisplayMetrics().density;

        goal = new View(context);

        RelativeLayout.LayoutParams goalLayout = new RelativeLayout.LayoutParams((int) (Level.squareSize * dpValue), (int) (Level.squareSize * dpValue));
        goalLayout.setMargins((int) (goalX * dpValue * Level.squareSize), (int) (goalY * dpValue * Level.squareSize), 0, 0);

        goal.setLayoutParams(goalLayout);
        goal.setBackgroundColor(context.getResources().getColor(color.colorInt));

        container.addView(goal);
    }

    public boolean onGoal(){
        if(X == goalX && Y == goalY){
            return true;
        }
        else{
            return false;
        }
    }

}
