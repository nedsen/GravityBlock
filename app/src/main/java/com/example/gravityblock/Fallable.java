package com.example.gravityblock;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;

public abstract class Fallable {

    public int startX;
    public int startY;
    public int X;
    public int Y;
    public int Width;
    public int Height;

    public View view;

    Context context;

    public long fallTime;

    public abstract  void setView(RelativeLayout container);

    public void setX(int newx, int delay){
        int g = 6000 * Level.squareSize;  //larger g = less gravity
        int s = Math.abs(newx - X);
        fallTime = (long) Math.sqrt( g * s);



        this.X = newx;
        float dpValue = context.getResources().getDisplayMetrics().density;
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", (newx - startX) * dpValue * Level.squareSize);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setStartDelay(delay);
        animator.setDuration(fallTime);
        animator.start();
    }
    public void setY(int newy, int delay){
        int g = 6000 * Level.squareSize;  //larger g = less gravity
        int s = Math.abs(newy - Y);
        fallTime = (long) Math.sqrt( g * s);


        this.Y = newy;
        float dpValue = context.getResources().getDisplayMetrics().density;
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", (newy - startY) * dpValue * Level.squareSize);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setStartDelay(delay);
        animator.setDuration(fallTime);
        animator.start();
    }

    public void setContext(Context c) {
        this.context = c;
    }


}
