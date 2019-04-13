package com.example.nicholasbaldwin.mockupgui;

import com.example.nicholasbaldwin.mockupgui.game.actionMsg.GameAction;
import com.example.nicholasbaldwin.mockupgui.game.util.GamePlayer;
import com.example.nicholasbaldwin.mockupgui.game.util.LocalGame;

import java.util.ArrayList;

/**
 * <!-- class BlokusLocalGame-->
 * <p>
 * This class defines and enforces
 * the game rules; handles interactions with players.
 *
 * @author <Justin Cao>
 * @author <Dylan Pascua>
 * @author <Nicholas Baldwin>
 */

public class BlokusLocalGame extends LocalGame {

    // the game's state
    private BlokusGameState mainState;

    /**
     * Constructor for the BlokusLocalGame.
     */
    public BlokusLocalGame() {
        // perform superclass initialization
        super();

        // create a new, unfilled-in BlokusGameState object
        mainState = new BlokusGameState();
    }

    /**
     * Notify the given player that its state has changed. This should involve sending
     * a GameInfo object to the player. If the game is not a perfect-information game
     * this method should remove any information from the game that the player is not
     * allowed to know.
     *
     * @param p the player to notify
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        // make a copy of the state, and send it to the player
        p.sendInfo(new BlokusGameState(mainState, mainState.getPlayerTurn()));
    }

    /**
     * Tell whether the given player is allowed to make a move at the
     * present point in the game.
     *
     * @param playerIdx the player's player-number (ID)
     * @return true iff the player is allowed to move
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return playerIdx == mainState.getPlayerTurn();
    }

    /**
     * Check if the game is over. It is over, return a string that tells
     * who the winner(s), if any, are. If the game is not over, return null;
     *
     * @return a message that tells who has won the game, or null if the
     * game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO check who has the highest score if no one can move
        //TODO check who has pieceRemaining = 0 and win the game

        //this will store all of the current pieces that have not been played by
        //any of the players
       ArrayList<Piece> piecesInInventory = null;
       for(int i = 0; i < BlokusGameState.TOTAL_NUM_PLAYERS; i++){
           for(int j = 0 ; j < BlokusGameState.TOTAL_NUM_PIECES; j++){
               if(mainState.getAllPieceInventory().get(i).get(j).isOnBoard == false){
                   piecesInInventory.add(mainState.getAllPieceInventory().get(i).get(j));
               }
           }
       }

       //TODO finish the algorythm that checks to see if there are still moves to be made, need to figure out how to flip
        //checks every possible combination of each players remaining pieces
        //to see if they can still place a piece
       int[][] currentBoard = mainState.getBoard();
       PlacePiece pp = null;
       int flipCount = 0;//used to see how many times the piece has been flipped
        for(int i = 0; i < piecesInInventory.size(); i++){
            for(int j = 0 ; j < currentBoard.length; j++){
                for(int k = 0; k < currentBoard.length; k++){
                    pp = new PlacePiece(null, j, k, piecesInInventory.get(i));
                    if(pp.checkForValidMove(piecesInInventory.get(i).getColorNum())){
                        return null; //this means that piece can be placed
                    }
                }
            }
        }

        int winner = -1;
//        for (int i = 0; i < players.length; i++) {
//            if(mainState.getAllPiecesRemaining()[i] == 0){
//                winner = i;
//                break;
//            }
//        }
        if (winner == -1) {
            return null;
        }
        return playerNames[winner] + " is the winner.";
    }


    /**
     * Makes a move on behalf of a player.
     *
     * @param action The move that the player has sent to the game
     * @return Tells whether the move was a legal one.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        PlacePiece pp = (PlacePiece) action;
        int y = pp.getY();
        int x = pp.getX();
        pp.setBoard(mainState.getBoard());

        if(!pp.checkForValidMove(mainState.getPlayerTurn())){
            return false;
        }

        mainState.placePiece(x, y, pp.getCurrentPiece());
        mainState.updatePiecesRemaining();
        mainState.updatePlayerScores(pp.getCurrentPiece());
        //mainState.setPlayerTurn(mainState.getPlayerTurn());

        return true;
    }
}
