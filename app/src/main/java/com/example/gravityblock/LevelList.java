package com.example.gravityblock;

import android.content.Context;

public class LevelList {
    Context context;

    public LevelList(Context c){
        context = c;
    }

    private static SquareColor redSquare = new SquareColor(R.color.redSquareColor, R.drawable.red_square_background);
    private static SquareColor yellowSquare = new SquareColor(R.color.yellowSquareColor, R.drawable.yellow_square_background);
    private static SquareColor greenSquare = new SquareColor(R.color.greenSquareColor, R.drawable.green_square_background);

    public static Level[] Levels = new Level[]{
            //Level 0
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall(0, 0, 10, 1),
                            new Wall(0, 0, 1, 10),
                            new Wall(9, 0, 1, 10),
                            new Wall(0, 9, 10, 1),
                            new Wall(1, 6, 2, 1),
                            new Wall(4, 8, 1, 1),
                            new Wall(5, 5, 1, 1),
                            new Wall(6, 4, 1, 1),

                    },

                    //Squares
                    new Square[]{
                            new Square(1, 5, 0, 0, redSquare),
                            new Square(4, 2, 0, 0, redSquare),
                            new Square(6, 2, 0, 0, redSquare),
                            new Square(5, 6, 0, 0, redSquare),
                            new Square(7, 3, 0, 0, redSquare),
                            new Square(3, 3, 0, 0, redSquare),

                    },
                    //movablocks
                    new Movablock[]{
                            new Movablock(1, 2, 2, 2),
                            new Movablock(4, 4, 2, 1),
                            new Movablock(4, 7, 2, 1),
                            new Movablock(6, 3, 1, 1),
                            new Movablock(8, 2, 1, 1),
                            new Movablock(7, 4, 2, 1),
                            new Movablock(7, 6, 1, 2),
                            new Movablock(8, 7, 1, 2),
                            new Movablock(3, 5, 1, 2),
                            new Movablock(2, 8, 2, 1),
                    },

                    //Size
                    10,

                    //Moves
                    100
            ),
            //Level 1
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 6, 1),
                                    new Wall (0, 1, 1, 4),
                                    new Wall (2, 1, 2, 3),
                                    new Wall (5, 1, 1, 5),
                                    new Wall (0, 5, 5, 1),
                            },
                    //Squares
                    new Square[]{
                            new Square(1, 1, 4, 1, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    6,

                    //Moves
                    2,

                    "Get the square to the goal"
            ),

            //Level 2
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 1, 6),
                                    new Wall (1, 0, 5, 1),
                                    new Wall (5, 1, 1, 5),
                                    new Wall (1, 5, 4, 1),
                                    new Wall (2, 1, 1, 3),
                                    new Wall (3, 3, 1, 1)
                            },
                    //Squares
                    new Square[]{
                            new Square(1, 1, 3, 2, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    6,

                    //Moves
                    4,

                    "Easy right?"
            ),

            //Level 3
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 1, 6),
                                    new Wall (1, 0, 5, 1),
                                    new Wall (5, 1, 1, 5),
                                    new Wall (1, 3, 1, 1),
                                    new Wall (4, 4, 1, 1),
                                    new Wall (1, 5, 4, 1)
                            },
                    //Squares
                    new Square[]{
                            new Square(1, 1, 1, 4, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    6,

                    //Moves
                    5,
                    "Don't worry"
            ),


            //Level 4
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 1, 6),
                                    new Wall (1, 0, 5, 1),
                                    new Wall (5, 1, 1, 5),
                                    new Wall (1, 5, 4, 1),
                                    new Wall (1, 2, 1, 1),
                                    new Wall (2, 3, 1, 1),
                                    new Wall (4, 4, 1, 1)
                            },
                    //Squares
                    new Square[]{
                            new Square(1, 1, 1, 3, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    6,

                    //Moves
                    6,
                    "It gets harder"
            ),

            //Level 5
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 1, 6),
                                    new Wall (1, 0, 5, 1),
                                    new Wall (5, 1, 1, 5),
                                    new Wall (1, 5, 4, 1),
                                    new Wall (1, 1, 2, 1),
                                    new Wall (1, 3, 1, 1),
                                    new Wall (4, 2, 1, 1)
                            },
                    //Squares
                    new Square[]{
                            new Square(1, 4, 4, 1, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    6,

                    //Moves
                    7,

                    "Are you ready?"
            ),
            //Level 6
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 0, 1, 10),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 0, 1, 10),
                                    new Wall (0, 0, 2, 4),
                                    new Wall (5, 0, 1, 2),
                                    new Wall (4, 3, 1, 1),
                                    new Wall (6, 3, 1, 2),
                                    new Wall (8, 3, 2, 1),
                                    new Wall (2, 5, 1, 2),
                                    new Wall (7, 5, 1, 1),
                                    new Wall (3, 7, 1, 1),
                                    new Wall (5, 7, 1, 1),
                                    new Wall (8, 7, 2, 1)
                            },
                    //Squares
                    new Square[]{
                            new Square(8, 6, 8, 8, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    7,

                    "That was just the introduction"
            ),
            //Level 7
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 0, 1, 10),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 0, 1, 10),
                                    new Wall (4, 0, 1, 3),
                                    new Wall (7, 0, 3, 2),
                                    new Wall (0, 6, 2, 1),
                                    new Wall (2, 5, 1, 1),
                                    new Wall (7, 4, 3, 1),
                                    new Wall (6, 6, 1, 1),
                                    new Wall (8, 6, 2, 1),
                                    new Wall (5, 8, 1, 2)
                            },
                    //Squares
                    new Square[]{
                            new Square(8, 5, 5, 1, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    8,
                    "Can you get to the end?"
            ),
            //Level 8
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 0, 1, 10),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 0, 1, 10),
                                    new Wall (0, 0, 2, 2),
                                    new Wall (4, 0, 1, 2),
                                    new Wall (7, 0, 1, 2),
                                    new Wall (2, 3, 1, 1),
                                    new Wall (8, 4, 2, 1),
                                    new Wall (0, 5, 2, 1),
                                    new Wall (6, 6, 1, 1),
                                    new Wall (3, 7, 1, 3),
                                    new Wall (5, 8, 2, 2),
                            },
                    //Squares
                    new Square[]{
                            new Square(8, 8, 5, 1, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    8
            ),
            //Level 9
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 0, 1, 10),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 0, 1, 10),
                                    new Wall (0, 2, 2, 1),
                                    new Wall (4, 2, 2, 2),
                                    new Wall (8, 4, 2, 1),
                                    new Wall (0, 5, 2, 1),
                                    new Wall (4, 5, 1, 2),
                                    new Wall (2, 6, 1, 1),
                                    new Wall (4, 6, 4, 1),
                                    new Wall (0, 8, 2, 2),
                                    new Wall (5, 8, 1, 2)
                            },
                    //Squares
                    new Square[]{
                            new Square(4, 1, 4, 8, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    11
            ),
            //Level 10
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 0, 1, 10),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 0, 1, 10),
                                    new Wall (0, 2, 2, 1),
                                    new Wall (4, 2, 1, 1),
                                    new Wall (2, 3, 1, 1),
                                    new Wall (7, 3, 1, 1),
                                    new Wall (3, 4, 1, 1),
                                    new Wall (8, 5, 2, 1),
                                    new Wall (5, 5, 1, 2),
                                    new Wall (0, 6, 3, 1),
                                    new Wall (4, 6, 2, 1),
                                    new Wall (6, 7, 1, 1),
                                    new Wall (4, 8, 1, 2)
                            },
                    //Squares
                    new Square[]{
                            new Square(1, 1, 1, 8, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    12
            ),
            //Level 11
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 1, 1, 8),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 1, 1, 8),
                                    new Wall (1, 2, 1, 1),
                                    new Wall (4, 2, 3, 1),
                                    new Wall (3, 3, 1, 1),
                                    new Wall (7, 3, 1, 1),
                                    new Wall (1, 5, 1, 1),
                                    new Wall (3, 5, 1, 2),
                                    new Wall (6, 6, 1, 1),
                                    new Wall (8, 6, 1, 1),
                                    new Wall (2, 7, 1, 2),
                                    new Wall (8, 8, 1, 1)
                            },
                    //Squares
                    new Square[]{
                            new Square(1, 1, 1, 8, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    12
            ),

            //Level 12
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 1, 1, 8),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 1, 1, 8),
                                    new Wall (2, 2, 2, 1),
                                    new Wall (7, 1, 2, 1),
                                    new Wall (6, 2, 1, 1),
                                    new Wall (8, 2, 1, 1),
                                    new Wall (5, 3, 1, 1),
                                    new Wall (1, 5, 1, 1),
                                    new Wall (4, 6, 2, 1),
                                    new Wall (5, 5, 1, 1),
                                    new Wall (8, 7, 1, 1),
                                    new Wall (2, 8, 1, 1),
                                    new Wall (8, 5, 1, 1)
                            },
                    //Squares
                    new Square[]{
                            new Square(5, 4, 7, 2, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    12
            ),
            //Level 13
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 0, 1, 10),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 0, 1, 10),
                                    new Wall (0, 0, 2, 2),
                                    new Wall (8, 0, 2, 2),
                                    new Wall (2, 2, 2, 2),
                                    new Wall (5, 2, 1, 1),
                                    new Wall (7, 2, 1, 3),
                                    new Wall (6, 4, 2, 1),
                                    new Wall (2, 5, 1, 1),
                                    new Wall (4, 6, 1, 2),
                                    new Wall (7, 6, 1, 2),
                                    new Wall (2, 7, 4, 1),
                                    new Wall (0, 8, 2, 2),
                                    new Wall (8, 8, 2, 2)
                            },
                    //Squares
                    new Square[]{
                            new Square(3, 6, 8, 2, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    8
            ),

            //Level 14
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 1, 1, 8),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 1, 1, 8),
                                    new Wall (2, 1, 1, 2),
                                    new Wall (5, 1, 1, 1),
                                    new Wall (8, 2, 1, 1),
                                    new Wall (4, 3, 1, 1),
                                    new Wall (5, 5, 1, 3),
                                    new Wall (2, 6, 1, 1),
                                    new Wall (6, 6, 1, 1),
                                    new Wall (8, 6, 1, 1),
                                    new Wall (2, 8, 1, 1)
                            },
                    //Squares
                    new Square[]{
                            new Square(8, 8, 1, 1, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    14
            ),

            //Level 15
            new Level(
                    //Walls
                    new Wall[]
                            {
                                    new Wall (0, 0, 10, 1),
                                    new Wall (0, 1, 1, 8),
                                    new Wall (0, 9, 10, 1),
                                    new Wall (9, 1, 1, 8),
                                    new Wall (3, 1, 1, 1),
                                    new Wall (6, 1, 1, 1),
                                    new Wall (1, 4, 1, 1),
                                    new Wall (4, 5, 1, 1),
                                    new Wall (3, 6, 1, 1),
                                    new Wall (8, 6, 1, 1),
                                    new Wall (5, 7, 1, 1),
                                    new Wall (3, 8, 1, 1),
                                    new Wall (3, 4, 1, 1)
                            },
                    //Squares
                    new Square[]{
                            new Square(4, 4, 3, 5, redSquare)
                    },
                    new Movablock[0],
                    //Size
                    10,

                    //Moves
                    15
            ),

            //Level 16
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 1, 1, 8),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 1, 1, 8),
                            new Wall (1, 3, 1, 3),
                            new Wall (4, 3, 1, 1),
                            new Wall (8, 4, 1, 1),
                            new Wall (4, 6, 1, 1),
                            new Wall (2, 5, 1, 1),
                            new Wall (6, 6, 1, 1),
                            new Wall (7, 7, 2, 2),
                            new Wall (2, 8, 1, 1),
                            new Wall (6, 8, 1, 1)
                    },

                    //Squares
                    new Square[]{
                            new Square(2, 2, 1, 8, redSquare),
                    },
                    //movablocks
                    new Movablock[]{
                        new Movablock(2, 3, 2, 2)
                    },

                    //Size
                    10,

                    //Moves
                    10,
                    "Grey blocks will also fall"
            ),
            //Level 17
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (4, 0, 1, 2),
                            new Wall (3, 2, 1, 1),
                            new Wall (5, 2, 1, 2),
                            new Wall (8, 2, 2, 1),
                            new Wall (7, 3, 1, 1),
                            new Wall (3, 4, 1, 1),
                            new Wall (2, 5, 1, 1),
                            new Wall (8, 5, 2, 1),
                            new Wall (7, 6, 1, 1),
                            new Wall (3, 7, 2, 1),
                    },

                    //Squares
                    new Square[]{
                            new Square(1, 8, 4, 2, redSquare),
                    },
                    //movablocks
                    new Movablock[]{
                            new Movablock(2, 4, 1, 1)
                    },

                    //Size
                    10,

                    //Moves
                    12
            ),
            //Level 18
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 1, 1, 8),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 1, 1, 8),
                            new Wall (8, 2, 1, 1),
                            new Wall (1, 3, 1, 1),
                            new Wall (5, 4, 1, 1),
                            new Wall (7, 5, 1, 1),
                            new Wall (1, 7, 1, 1),
                            new Wall (5, 7, 2, 1),
                            new Wall (8, 7, 1, 1)
                    },

                    //Squares
                    new Square[]{
                            new Square(4, 8, 6, 4, redSquare),
                    },
                    //movablocks
                    new Movablock[]{
                        new Movablock(8, 1, 1, 1)
                    },

                    //Size
                    10,

                    //Moves
                    19
            ),
            //Level 19
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (5, 0, 1, 2),
                            new Wall (7, 0, 3, 2),
                            new Wall (2, 3, 1, 1),
                            new Wall (4, 3, 1, 2),
                            new Wall (4, 6, 1, 1),
                            new Wall (0, 7, 2, 1),
                            new Wall (6, 7, 1, 1),
                            new Wall (3, 8, 2, 2)
                    },

                    //Squares
                    new Square[]{
                            new Square(1, 8, 6, 1, redSquare),
                    },
                    //movablocks
                    new Movablock[]{
                            new Movablock(4, 2, 1, 1),
                            new Movablock(1, 6, 1, 1)
                    },

                    //Size
                    10,

                    //Moves
                    10
            ),
            //Level 20
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (2, 0, 1, 2),
                            new Wall (0, 3, 2, 3),
                            new Wall (3, 4, 1, 1),
                            new Wall (5, 4, 2, 1),
                            new Wall (7, 5, 2, 1),
                            new Wall (0, 7, 2, 1),
                            new Wall (3, 7, 2, 1),
                            new Wall (7, 7, 3, 1)
                    },

                    //Squares
                    new Square[]{
                            new Square(6, 3, 8, 8, redSquare),
                    },
                    //movablocks
                    new Movablock[]{
                            new Movablock(8, 2, 1, 3),
                            new Movablock(5, 6, 4, 1)
                    },

                    //Size
                    10,

                    //Moves
                    9,
                    "Block the block"
            ),

            //Level 21
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (0, 2, 2, 1),
                            new Wall (7, 0, 3, 2),
                            new Wall (3, 4, 1, 1),
                            new Wall (2, 5, 1, 1),
                            new Wall (6, 5, 1, 1),
                            new Wall (3, 6, 1, 1),
                            new Wall (0, 8, 3, 2),
                            new Wall (7, 8, 1, 2),
                    },

                    //Squares
                    new Square[]{
                            new Square(1, 1, 1, 7, redSquare),
                            new Square(3, 5, 3, 8, yellowSquare),
                    },
                    //movablocks
                    new Movablock[0],

                    //Size
                    10,

                    //Moves
                    8
            ),
            //Level 22
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (0, 0, 4, 2),
                            new Wall (0, 3, 2, 1),
                            new Wall (8, 2, 2, 1),
                            new Wall (4, 3, 1, 1),
                            new Wall (8, 4, 2, 1),
                            new Wall (8, 6, 2, 1),
                            new Wall (7, 7, 1, 1),
                            new Wall (3, 8, 1, 2),
                    },

                    //Squares
                    new Square[]{
                            new Square(1, 8, 8, 5, redSquare),
                            new Square(8, 8, 8, 1, yellowSquare),
                    },
                    //movablocks
                    new Movablock[0],

                    //Size
                    10,

                    //Moves
                    11
            ),
            //Level 23
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (4, 0, 3, 2),
                            new Wall (4, 1, 2, 2),
                            new Wall (4, 2, 1, 2),
                            new Wall (3, 3, 2, 1),
                            new Wall (0, 3, 2, 2),
                            new Wall (6, 3, 1, 2),
                            new Wall (8, 3, 2, 1),
                            new Wall (4, 5, 1, 2),
                            new Wall (2, 6, 3, 1),
                            new Wall (2, 8, 2, 2),
                            new Wall (7, 7, 1, 3),
                    },

                    //Squares
                    new Square[]{
                            new Square(3, 2, 6, 2, redSquare),
                            new Square(8, 2, 1, 2, yellowSquare),
                    },
                    //movablocks
                    new Movablock[0],

                    //Size
                    10,

                    //Moves
                    29
            ),
            //Level 24
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (0, 3, 3, 1),
                            new Wall (7, 3, 1, 1),
                            new Wall (4, 4, 1, 1),
                            new Wall (0, 5, 2, 1),
                            new Wall (3, 5, 1, 1),
                            new Wall (7, 5, 1, 2),
                            new Wall (0, 7, 2, 1),
                            new Wall (5, 8, 1, 2),
                            new Wall (8, 8, 2, 2),
                    },

                    //Squares
                    new Square[]{
                            new Square(3, 4, 2, 7, redSquare),
                            new Square(6, 8, 1, 8, yellowSquare),
                    },
                    //movablocks
                    new Movablock[]{
                            new Movablock(1, 1, 1, 2)
                    },

                    //Size
                    10,

                    //Moves
                    9
            ),
            //Level 25
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (2, 0, 1, 2),
                            new Wall (7, 0, 1, 2),
                            new Wall (4, 4, 2, 2),
                            new Wall (3, 5, 4, 1),
                            new Wall (0, 7, 2, 1),
                            new Wall (3, 7, 1, 1),
                            new Wall (6, 7, 1, 1),
                            new Wall (8, 7, 2, 1),
                            new Wall (4, 8, 2, 2),
                    },

                    //Squares
                    new Square[]{
                            new Square(3, 4, 5, 7, redSquare),
                            new Square(6, 4, 4, 7, yellowSquare),
                    },
                    //movablocks
                    new Movablock[]{
                            new Movablock(3, 6, 4, 1)
                    },

                    //Size
                    10,

                    //Moves
                    14
            ),
            //Level 26
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (0, 2, 2, 2),
                            new Wall (7, 3, 3, 1),
                            new Wall (3, 4, 1, 1),
                            new Wall (4, 5, 1, 1),
                            new Wall (6, 6, 1, 1),
                            new Wall (2, 7, 1, 3),
                            new Wall (5, 8, 1, 2)
                    },

                    //Squares
                    new Square[]{
                            new Square(3, 3, 3, 5, redSquare),
                            new Square(4, 4, 6, 7, yellowSquare),
                            new Square(1, 1, 1, 4, greenSquare),
                    },
                    //movablocks
                    new Movablock[0],

                    //Size
                    10,

                    //Moves
                    6
            ),
            //Level 27
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (4, 0, 1, 2),
                            new Wall (7, 0, 1, 2),
                            new Wall (0, 2, 2, 1),
                            new Wall (6, 2, 1, 1),
                            new Wall (2, 4, 1, 2),
                            new Wall (7, 5, 1, 3),
                            new Wall (3, 6, 1, 1),
                            new Wall (5, 6, 3, 1)
                    },

                    //Squares
                    new Square[]{
                            new Square(2, 3, 7, 8, redSquare),
                            new Square(6, 1, 8, 1, yellowSquare),
                            new Square(1, 1, 6, 3, greenSquare),
                    },
                    //movablocks
                    new Movablock[0],

                    //Size
                    10,

                    //Moves
                    8
            ),


            //Later???asldkfjhasdkljfh
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (5, 0, 1, 2),
                            new Wall (7, 0, 1, 2),
                            new Wall (2, 2, 1, 2),
                            new Wall (7, 3, 1, 4),
                            new Wall (5, 4, 3, 1),
                            new Wall (3, 6, 3, 1),
                            new Wall (8, 8, 2, 2),
                            new Wall (3, 6, 1, 2),
                            new Wall (2, 3, 2, 1),
                    },

                    //Squares
                    new Square[]{
                            new Square(3, 5, 1, 1, redSquare),
                            new Square(1, 8, 4, 7, yellowSquare),
                            new Square(6, 3, 4, 1, greenSquare),
                    },
                    //movablocks
                    new Movablock[0],

                    //Size
                    10,

                    //Moves
                    8
            ),
            //Level 27?
            new Level(
                    //Walls
                    new Wall[]{
                            new Wall (0, 0, 10, 1),
                            new Wall (0, 0, 1, 10),
                            new Wall (0, 9, 10, 1),
                            new Wall (9, 0, 1, 10),
                            new Wall (2, 2, 2, 1),
                            new Wall (2, 2, 1, 2),
                            new Wall (6, 2, 2, 1),
                            new Wall (7, 2, 1, 2),
                            new Wall (4, 4, 2, 2),
                            new Wall (2, 6, 1, 2),
                            new Wall (2, 7, 2, 1),
                            new Wall (7, 6, 1, 2),
                            new Wall (6, 7, 2, 1),
                    },

                    //Squares
                    new Square[]{
                            new Square(1, 8, 6, 3, redSquare),
                            new Square(3, 6, 1, 1, yellowSquare),
                            new Square(6, 6, 3, 3, greenSquare),
                    },
                    //movablocks
                    new Movablock[]{
                            new Movablock(8, 8, 1, 1)
                    },

                    //Size
                    10,

                    //Moves
                    100
            ),

    };
}
