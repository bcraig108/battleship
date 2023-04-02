package org.robodad.battleship.controller;

import org.robodad.battleship.model.Player;

public class GameState {

    private Player player1;
    private Player player2;

    public GameState(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean isReady() {
        return player1.isReady() && player2.isReady(); 
    }
}
