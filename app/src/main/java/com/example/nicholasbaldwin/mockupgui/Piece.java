package com.example.nicholasbaldwin.mockupgui;

import android.graphics.Color;
import java.io.Serializable;

/**
 * <!-- class Piece -->
 * <p>
 * This class controls the attributes of the pieces used in Blokus.
 * Each player is to have 21 pieces in their inventories each with
 * different shapes and point values.
 *
 * @author <Justin Cao, Dylan Pascua, Nicholas Baldwin>
 * @version <Spring 2019>
 */
public class Piece implements Serializable {

    public static final int PIECE_LAYOUT_SIZE = 5;

    //Constants that represent the player index
    public static final int EMPTY = -1;
    public static final int RED = 0;
    public static final int BLUE = 1;
    public static final int GREEN = 2;
    public static final int YELLOW = 3;
    //This will be used to identify the type of piece created
    //for this instance
    private String pieceName;

    //How much the piece is worth in terms of points
    private int pieceValue, pieceColor, colorNum;
    protected int xPosition = 9, yPosition = 9;

    //how the pieces are arranged in terms of ints
    protected int[][] pieceLayout = new int[PIECE_LAYOUT_SIZE][PIECE_LAYOUT_SIZE];

    //if true, remove from a player's inventory user interface
    protected boolean isOnBoard = false;

    /**
     * Constructor for the Piece class
     * <p>
     * Initializes a piece with its type, score value, and color.
     * This instance will be stored in each player's inventory.
     *
     * @param initName  Name of the player
     * @param initScore Type of player (Human, AI, or Network)
     * @param initColor Chosen color of a player
     */
    public Piece(String initName, int initScore, int initColor) {
        pieceName = initName;
        pieceValue = initScore;
        pieceColor = initColor;

        //setting up a blank piece layout
        for (int i = 0; i < pieceLayout.length; i++) {
            for (int j = 0; j < pieceLayout.length; j++) {
                pieceLayout[i][j] = Piece.EMPTY;
            }
        }

        //sets the pieces color
        if (pieceColor == Color.RED) {
            colorNum = RED;
        } else if (pieceColor == Color.BLUE) {
            colorNum = BLUE;
        } else if (pieceColor == Color.GREEN) {
            colorNum = GREEN;
        } else if (pieceColor == Color.YELLOW) {
            colorNum = YELLOW;
        }

        //the setups for each piece
        if (pieceName.equals("one")) {
            pieceLayout[0][0] = colorNum;
        } else if (pieceName.equals("two")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[1][0] = colorNum;
        } else if (pieceName.equals("S")) {
            pieceLayout[1][0] = colorNum;
            pieceLayout[2][0] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[0][1] = colorNum;
        } else if (pieceName.equals("three")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[1][0] = colorNum;
            pieceLayout[2][0] = colorNum;
        } else if (pieceName.equals("smallT")) {
            pieceLayout[1][0] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[2][1] = colorNum;
        } else if (pieceName.equals("four")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[1][0] = colorNum;
            pieceLayout[2][0] = colorNum;
            pieceLayout[3][0] = colorNum;
        } else if (pieceName.equals("fourL")) {
            pieceLayout[2][0] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[2][1] = colorNum;
        } else if (pieceName.equals("five")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[1][0] = colorNum;
            pieceLayout[2][0] = colorNum;
            pieceLayout[3][0] = colorNum;
            pieceLayout[4][0] = colorNum;
        } else if (pieceName.equals("fiveL")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[2][1] = colorNum;
            pieceLayout[3][1] = colorNum;
        } else if (pieceName.equals("N")) {
            pieceLayout[0][1] = colorNum;
            pieceLayout[1][0] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[2][0] = colorNum;
            pieceLayout[3][0] = colorNum;
        } else if (pieceName.equals("Y")) {
            pieceLayout[0][1] = colorNum;
            pieceLayout[1][0] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[2][1] = colorNum;
            pieceLayout[3][1] = colorNum;
        } else if (pieceName.equals("v3")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[1][0] = colorNum;
            pieceLayout[1][1] = colorNum;
        } else if (pieceName.equals("cube")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[1][0] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[1][1] = colorNum;
        } else if (pieceName.equals("C")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[0][2] = colorNum;
            pieceLayout[1][0] = colorNum;
            pieceLayout[1][2] = colorNum;
        } else if (pieceName.equals("B")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[0][2] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[1][2] = colorNum;
        } else if (pieceName.equals("Z")) {
            pieceLayout[2][0] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[2][1] = colorNum;
            pieceLayout[0][2] = colorNum;
        } else if (pieceName.equals("M")) {
            pieceLayout[1][0] = colorNum;
            pieceLayout[2][0] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[0][2] = colorNum;
        } else if (pieceName.equals("X")) {
            pieceLayout[1][0] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[2][1] = colorNum;
            pieceLayout[1][2] = colorNum;
        } else if (pieceName.equals("F")) {
            pieceLayout[1][0] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[1][2] = colorNum;
            pieceLayout[2][0] = colorNum;
        } else if (pieceName.equals("bigT")) {
            pieceLayout[1][0] = colorNum;
            pieceLayout[1][1] = colorNum;
            pieceLayout[1][2] = colorNum;
            pieceLayout[0][2] = colorNum;
            pieceLayout[2][2] = colorNum;
        } else if (pieceName.equals("corner")) {
            pieceLayout[0][0] = colorNum;
            pieceLayout[0][1] = colorNum;
            pieceLayout[0][2] = colorNum;
            pieceLayout[1][2] = colorNum;
            pieceLayout[2][2] = colorNum;
        }

    }

    /**
     * method that horizontally flips a pieces
     * int array and makes sure that the
     * anchor is at the top left
     *
     * @return the pieces new int array
     */
    public int[][] flip() {
        //checks to see if this can be flipped. if not return original
        if (!this.canBeFlipped()) {
            return this.getPieceLayout();
        }
        int[][] currentLayout = this.getPieceLayout();
        int yOffset = 5;
        //flips the piece horizontally at the middle
        for (int i = 0; i < PIECE_LAYOUT_SIZE; i++) {
            for (int j = 0; j < PIECE_LAYOUT_SIZE / 2; j++) {
                //swaps values across the center line
                int temp = currentLayout[i][j];
                currentLayout[i][j] = currentLayout[i][PIECE_LAYOUT_SIZE - j - 1];
                currentLayout[i][PIECE_LAYOUT_SIZE - j - 1] = temp;
            }
        }

        //counts the y offset when rotating
        for (int i = 0; i < PIECE_LAYOUT_SIZE; i++) {
            for (int j = 0; j < PIECE_LAYOUT_SIZE; j++) {
                if (currentLayout[i][j] != Piece.EMPTY && j < yOffset) {
                    yOffset = j;
                    break;
                }
            }
        }
        // if there is no change in y
        if (yOffset == 5) {
            yOffset = 0;
        }
        //this moves the piece back up to the top
        for (int i = 0; i < PIECE_LAYOUT_SIZE; i++) {
            for (int j = 0; j < PIECE_LAYOUT_SIZE; j++) {
                if (currentLayout[i][j] != Piece.EMPTY) {
                    int temp = currentLayout[i][j - yOffset];
                    currentLayout[i][j - yOffset] = currentLayout[i][j];
                    currentLayout[i][j] = temp;
                }
            }
        }
        return currentLayout;
    }
    /**
     * method that rotates a pieces int array
     * by 90 degrees and makes sure that the
     * anchor is at the top left
     *
     * @return the pieces new int array
     */
    public int[][] rotate90() {
        /**
         * External Citation:
         * Date: 30 March 2019
         * Problem: I didn't know the algorythm for rotating things in
         * a 2D array
         * Source:https://stackoverflow.com/questions/53110374/how-to-rotate-2-d-array-in-java
         */
        int[][] currentLayout = this.getPieceLayout();
        int[][] newLayout = new int[PIECE_LAYOUT_SIZE][PIECE_LAYOUT_SIZE];
        int xOffset = 5;
        int yOffset = 5;
        //this rotates the entire layout clockwise 90
        for (int i = 0; i < PIECE_LAYOUT_SIZE; i++) {
            for (int j = 0; j < PIECE_LAYOUT_SIZE; j++) {
                newLayout[i][j] = currentLayout[j][PIECE_LAYOUT_SIZE - i - 1];
            }
        }
        //counts the y offset when rotating
        for (int i = 0; i < PIECE_LAYOUT_SIZE; i++) {
            for (int j = 0; j < PIECE_LAYOUT_SIZE; j++) {
                if (newLayout[i][j] != Piece.EMPTY && j < yOffset) {
                    yOffset = j;
                    break;
                }
            }
        }
        //counts the x offset when rotating
        for (int i = 0; i < PIECE_LAYOUT_SIZE; i++) {
            for (int j = 0; j < PIECE_LAYOUT_SIZE; j++) {
                if (newLayout[i][j] != Piece.EMPTY && i < xOffset) {
                    xOffset = i;
                    break;
                }
            }
        }
        //if there is no offset, which means the original values are the same
        if (xOffset == 5) {
            xOffset = 0;
        }
        if (yOffset == 5) {
            yOffset = 0;
        }
        //puts the value back into the left corner
        //counts the y offset when rotating
        for (int i = 0; i < PIECE_LAYOUT_SIZE; i++) {
            for (int j = 0; j < PIECE_LAYOUT_SIZE; j++) {
                if (newLayout[i][j] != Piece.EMPTY) {
                    int temp = newLayout[i - xOffset][j - yOffset];
                    newLayout[i - xOffset][j - yOffset] = newLayout[i][j];
                    newLayout[i][j] = temp;
                }
            }
        }
        return newLayout;
    }

    /**
     * method that checks to see if a piece can
     * be flipped or not based on the name
     *
     * @return false if it is a special piece that
     * cannot be flipped
     */
    public boolean canBeFlipped() {
        String pName = this.getName();
        if (pName.equals("one") || pName.equals("two") || pName.equals("three")
                || pName.equals("four") || pName.equals("five") || pName.equals("cube")
                || pName.equals("X")) {
            return false;
        }
        return true;
    }

    /**
     * special getter methods for the lengths and
     * width used to help draw the pieces in the
     * BlokusBoard class.
     *
     * @return the lengths and widths respectively
     */
    public int getPieceLength() {
        int length = 1;
        for (int i = 0; i < pieceLayout.length; i++) {
            for (int j = 0; j < pieceLayout.length; j++) {
                //makes sure its not an empty part of the
                //piece layout
                if (pieceLayout[i][j] != Piece.EMPTY && j >= length) {
                    length = j + 1;// +1 since it starts at zero
                }
            }
        }
        return length;
    }

    public int getPieceWidth() {
        int width = 1;
        for (int i = 0; i < pieceLayout.length; i++) {
            for (int j = 0; j < pieceLayout.length; j++) {
                //makes sure its not an empty part of the
                //piece layout
                if (pieceLayout[i][j] != Piece.EMPTY && i >= width) {
                    width = i + 1;// +1 since it starts at zero
                }
            }
        }
        return width;
    }


    //Setters and Getters
    public void setName(String name) {
        pieceName = name;
    }

    public String getName() {
        return pieceName;
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public int getPieceColor() {
        return pieceColor;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int[][] getPieceLayout() {
        return pieceLayout;
    }

    public void setPieceLayout(int[][] layout) {
        this.pieceLayout = layout;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setOnBoard(boolean init) {
        this.isOnBoard = init;
    }

    public int getYPosition() {
        return yPosition;
    }

}

