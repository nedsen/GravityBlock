package com.example.gravityblock;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.util.Size;
import android.widget.RelativeLayout;

public class Level {

    public static int squareSize = 30;

    public int size;

    public Context context;

    public Wall[] walls;
    public Square[] squares;

    public Movablock[] movablocks;

    public RelativeLayout layout;

    public int currentRotation;

    public int rotationDuration = 1000;
    public long maxFallDuration;

    public boolean[][] occupied;

    /*public Level(Wall[] w, Square[] s, int sz){
        walls = w;
        squares = s;
        movablocks = new Movablock[]{};

        size = sz;

        currentRotation = 0;

        occupied = new boolean[sz][sz];
        for(int i = 0; i < sz; i ++){
            for(int j = 0; j < sz; j ++){
                occupied[i][j] =false;
            }
        }
        for(Wall wall : walls){
            for(int i = wall.X; i < wall.X + wall.Width; i ++){
                for(int j = wall.Y; j < wall.Y + wall.Height; j++){
                    occupied[i][j] = true;
                }
            }
        }
    }*/

    public Level(Wall[] w, Square[] s, Movablock[] m, int sz){
        walls = w;
        squares = s;
        movablocks = m;

        size = sz;

        currentRotation = 0;

        occupied = new boolean[sz][sz];
        for(int i = 0; i < sz; i ++){
            for(int j = 0; j < sz; j ++){
                occupied[i][j] =false;
            }
        }
        for(Wall wall : walls){
            for(int i = wall.X; i < wall.X + wall.Width; i ++){
                for(int j = wall.Y; j < wall.Y + wall.Height; j++){
                    occupied[i][j] = true;
                }
            }
        }
    }

    public Level(Level l){
        this.walls = l.walls;
        this.squares = new Square[l.squares.length];
        this.movablocks = new Movablock[l.movablocks.length];
        for(int i = 0; i < l.squares.length; i++) {
            this.squares[i] = new Square(l.squares[i]);
        }
        for(int i = 0; i < movablocks.length; i++){
            this.movablocks[i] = new Movablock(l.movablocks[i]);
        }

        this.size = l.size;

        occupied = new boolean[size][size];
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size; j ++){
                occupied[i][j] =false;
            }
        }
        for(Wall wall : walls){
            for(int i = wall.X; i < wall.X + wall.Width; i ++){
                for(int j = wall.Y; j < wall.Y + wall.Height; j++){
                    occupied[i][j] = true;
                }
            }
        }

    }

    public void setLayout(RelativeLayout l) {
        layout = l;

        float dpValue = context.getResources().getDisplayMetrics().density;

        layout.getLayoutParams().height = (int)(size * dpValue * squareSize);
        layout.getLayoutParams().width = (int) (size * dpValue * squareSize);

        for(Wall w : walls){
            w.setWallView(l);
        }

        for(Square s : squares){
            s.setView(l);
        }
        for(Movablock m : movablocks){
            m.setView(l);
        }
    }

    public void rotateLeft(){
        ObjectAnimator rotate;

        if(currentRotation == 0){
            currentRotation = 270;
            layout.setRotation(360);
        }
        else {
            currentRotation -= 90;
        }
        rotate = ObjectAnimator.ofFloat(layout, "Rotation", currentRotation);
        rotate.setDuration(rotationDuration);
        rotate.start();
    }
    public void rotateRight(){
        ObjectAnimator rotate;

        if(currentRotation == 270){
            currentRotation = 0;
            layout.setRotation(-90);
        }
        else{
            currentRotation += 90;
        }
        rotate = ObjectAnimator.ofFloat(layout, "Rotation", currentRotation);
        rotate.setDuration(rotationDuration);
        rotate.start();
    }

    public void fall(int delay){
        maxFallDuration = 0;

        //Reset occupied to only the walls
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size; j ++){
                occupied[i][j] =false;
            }
        }
        for(Wall wall : walls){
            for(int i = wall.X; i < wall.X + wall.Width; i ++){
                for(int j = wall.Y; j < wall.Y + wall.Height; j++){
                    occupied[i][j] = true;
                }
            }
        }

        //Create an array with all squares and movablocks
        Fallable[] allBlocks = new Fallable[squares.length + movablocks.length];
        for(int i = 0; i < squares.length; i ++){
            allBlocks[i] = squares[i];
        }
        for(int i = 0; i < movablocks.length; i++){
            allBlocks[i+squares.length] = movablocks[i];
        }
        int[] blockFallPositions = new int[squares.length + movablocks.length];
        if(currentRotation == 0) {
            //Go from the block with the greatest to the lowest y value and check where it should fal to
            for (int y = size - 1; y > 0; y --){
                for (int b = 0; b < allBlocks.length; b++){
                    if(allBlocks[b].Y == y){
                        nextBlock:
                        for (int i = allBlocks[b].Y; i < size; i++) {
                            for(int j = 0; j < allBlocks[b].Width; j++){
                                if (occupied[allBlocks[b].X + j][i]) {
                                    blockFallPositions[b] = i - allBlocks[b].Height;
                                    break nextBlock;
                                }
                            }
                        }
                        //Set the place where it will fall to occupied
                        for (int i = 0; i < allBlocks[b].Width; i++){
                            for (int j = 0; j < allBlocks[b].Height; j++){
                                occupied[allBlocks[b].X + i][blockFallPositions[b] + j] = true;
                            }
                        }

                    }
                }
            }

            //Make each of them fall
            for(int s = 0; s < allBlocks.length; s++){
                allBlocks[s].setY(blockFallPositions[s], delay);
                if (allBlocks[s].fallTime > maxFallDuration) {
                    maxFallDuration = allBlocks[s].fallTime;
                }
            }

            /*
            for (int s = 0; s < allBlocks.length; s++) {
                nextBlock:
                for (int i = allBlocks[s].Y; i < size; i++) {
                    for(int j = 0; j < allBlocks[s].Width; j++){
                        if (occupied[allBlocks[s].X + j][i]) {
                            blockFallPositions[s] = i - allBlocks[s].Height;
                            break nextBlock;
                        }
                    }
                }
            }*/

/*
            //If squares will fall to the same place, adjust the square fall positions
            int[] squareFallAdj = new int[allBlocks.length];
            //int[] movablocksBelow = new int[movablocks.length];

            for(int s1 = 0; s1 < allBlocks.length; s1 ++){
                for (int s2 = s1 + 1; s2 < allBlocks.length; s2++) {
                    nextBlock:
                    for (int x1 = allBlocks[s1].X; x1 < allBlocks[s1].Width + allBlocks[s1].X; x1++){
                        for (int x2 = allBlocks[s2].X; x2 < allBlocks[s2].Width + allBlocks[s2].X; x2++){
                            if(x1 == x2){
                                if (blockFallPositions[s1] + allBlocks[s1].Height == blockFallPositions[s2] + allBlocks[s2].Height){
                                    if(allBlocks[s1].Y > allBlocks[s2].Y){
                                        squareFallAdj[s2] += allBlocks[s1].Height;
                                    }
                                    else{
                                        squareFallAdj[s1] += allBlocks[s2].Height;
                                    }
                                }
                                break nextBlock;
                            }
                        }
                    }
                }
            }
*/


        }
        if(currentRotation == 90){


            for (int x = size - 1; x > 0; x --){
                for (int s = 0; s < allBlocks.length; s++){
                    if(allBlocks[s].X == x){
                        nextBlock:
                        for (int i = allBlocks[s].X; i < size; i++) {
                            for(int j = 0; j < allBlocks[s].Height; j++) {
                                if (occupied[i][allBlocks[s].Y + j]) {
                                    blockFallPositions[s] = i - allBlocks[s].Width;
                                    break nextBlock;

                                }
                            }
                        }
                        //Set the place where it will fall to occupied
                        for (int i = 0; i < allBlocks[s].Width; i++){
                            for (int j = 0; j < allBlocks[s].Height; j++){
                                occupied[blockFallPositions[s] + i][allBlocks[s].Y + j] = true;
                            }
                        }

                    }
                }
            }
            /*
            for (int s = 0; s < allBlocks.length; s ++) {
                nextBlock:
                for (int i = allBlocks[s].X; i < size; i++) {
                    for(int j = 0; j < allBlocks[s].Height; j++) {
                        if (occupied[i][allBlocks[s].Y + j]) {
                            blockFallPositions[s] = i - allBlocks[s].Width;
                            break nextBlock;

                        }
                    }
                }
            }

            //Check where the movablocks should fall based on walls
            //int[] movablockFallPositions = new int[movablocks.length];sfhf

            //If squares will fall to the same place, adjust the square fall positions
            int[] squaresBelow = new int[allBlocks.length];
            for(int s1 = 0; s1 < allBlocks.length; s1 ++){
               for (int s2 = s1 + 1; s2 < allBlocks.length; s2++) {
                     if (allBlocks[s1].Y == allBlocks[s2].Y && blockFallPositions[s1]== blockFallPositions[s2]) {
                            if (allBlocks[s1].X > allBlocks[s2].X) {
                                squaresBelow[s2] += allBlocks[s1].Width;
                            } else {
                                squaresBelow[s1] += allBlocks[s2].Width;
                            }
                        }
                    }

            }*/

            //Make each of them fall
            for(int s = 0; s < allBlocks.length; s++){
                allBlocks[s].setX(blockFallPositions[s], delay);
                if (allBlocks[s].fallTime > maxFallDuration) {
                    maxFallDuration = allBlocks[s].fallTime;
                }
            }
        }
        if(currentRotation == 180){
            for (int y = 0; y < size - 1; y ++){
                for (int b = 0; b < allBlocks.length; b++){
                    if(allBlocks[b].Y == y){
                        nextBlock:
                        for (int i = allBlocks[b].Y - 1; i >= 0; i--) {
                            for(int j = 0; j < allBlocks[b].Width; j++) {
                                if (occupied[allBlocks[b].X + j][i]) {
                                    blockFallPositions[b] = i + 1;
                                    break nextBlock;
                                }
                            }
                        }
                        //Set the place where it will fall to occupied
                        for (int i = 0; i < allBlocks[b].Width; i++){
                            for (int j = 0; j < allBlocks[b].Height; j++){
                                occupied[allBlocks[b].X + i][blockFallPositions[b] + j] = true;
                            }
                        }

                    }
                }
            }

/*            for (int s = 0; s < allBlocks.length; s++) {
                nextBlock:
                for (int i = allBlocks[s].Y - 1; i >= 0; i--) {
                    for(int j = 0; j < allBlocks[s].Width; j++) {
                        if (occupied[allBlocks[s].X + j][i]) {
                            blockFallPositions[s] = i + 1;
                            break nextBlock;
                        }
                    }
                }
            }

            //If squares will fall to the same place, adjust the square fall positions
            int[] squaresBelow = new int[allBlocks.length];
            for(int s1 = 0; s1 < allBlocks.length; s1 ++){
                 for (int s2 = s1 + 1; s2 < allBlocks.length; s2++) {
                     if (allBlocks[s1].X == allBlocks[s2].X && blockFallPositions[s1] == blockFallPositions[s2]) {
                        if (allBlocks[s1].Y > allBlocks[s2].Y) {
                            squaresBelow[s1] += allBlocks[s2].Height;
                        } else {
                            squaresBelow[s2] += allBlocks[s1].Height;
                        }
                     }
                 }

            }
*/
            //Make each of them fall
            for(int s = 0; s < allBlocks.length; s++){
                allBlocks[s].setY(blockFallPositions[s], delay);
                if (allBlocks[s].fallTime > maxFallDuration) {
                    maxFallDuration = allBlocks[s].fallTime;
                }
            }
        }
        if(currentRotation == 270){

            for (int x = 0; x < size - 1; x ++){
                for (int s = 0; s < allBlocks.length; s++){
                    if(allBlocks[s].X == x){
                        nextBlock:
                        for (int i = allBlocks[s].X - 1; i >= 0; i--) {
                            for(int j = 0; j < allBlocks[s].Height; j++) {
                                if (occupied[i][allBlocks[s].Y + j]) {
                                    blockFallPositions[s] = i + 1;
                                    break nextBlock;
                                }
                            }
                        }
                        //Set the place where it will fall to occupied
                        for (int i = 0; i < allBlocks[s].Width; i++){
                            for (int j = 0; j < allBlocks[s].Height; j++){
                                occupied[blockFallPositions[s] + i][allBlocks[s].Y + j] = true;
                            }
                        }

                    }
                }
            }
            /*
            for (int s = 0; s < allBlocks.length; s++) {
                nextBlock:
                for (int i = allBlocks[s].X - 1; i >= 0; i--) {
                    for(int j = 0; j < allBlocks[s].Height; j++) {
                        if (occupied[i][allBlocks[s].Y + j]) {
                            blockFallPositions[s] = i + 1;
                            break nextBlock;
                        }
                    }
                }
            }

            //If squares will fall to the same place, adjust the square fall positions
            int[] squaresBelow = new int[allBlocks.length];
            for(int s1 = 0; s1 < allBlocks.length; s1 ++){
                nextBlock:
                for (int s2 = s1 + 1; s2 < allBlocks.length; s2++) {
                    if (allBlocks[s1].Y == allBlocks[s2].Y && blockFallPositions[s1] == blockFallPositions[s2]) {
                        if (allBlocks[s1].X > allBlocks[s2].X) {
                            squaresBelow[s1] += allBlocks[s2].Width;
                        } else {
                            squaresBelow[s2] += allBlocks[s1].Width;
                        }
                    }
                }
            }
*/
            //Make each of them fall
            for(int s = 0; s < allBlocks.length; s++){
                allBlocks[s].setX(blockFallPositions[s], delay);
                if (allBlocks[s].fallTime > maxFallDuration) {
                    maxFallDuration = allBlocks[s].fallTime;
                }
            }

        }
    }

    public boolean passed(){
        boolean allPassed = true;
        for(Square s : squares){
            if(!s.onGoal()){
                allPassed = false;
                break;
            }
        }

        return allPassed;
    }

    public static Level setLevelContext(Level l, Context c){
        Level level = new Level(l);
        level.setContext(c);
        return level;
    }
    public void setContext(Context c) {
        context = c;

        for(Wall w : walls){
            w.setContext(c);
        }
        for(Square s : squares){
            s.setContext(c);
        }
        for(Movablock m : movablocks){
            m.setContext(c);
        }
    }
}
