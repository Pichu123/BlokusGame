package com.example.nicholasbaldwin.mockupgui;

import com.example.nicholasbaldwin.mockupgui.game.actionMsg.GameAction;
import com.example.nicholasbaldwin.mockupgui.game.util.GamePlayer;

public class Rotate90 extends GameAction {
    //instance variables
    private int[][] pieceLayout;
    private int row;
    private int col;
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public Rotate90(GamePlayer player) {
        super(player);
    }
}