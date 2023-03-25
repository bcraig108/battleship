package org.robodad.battleship.view;

import org.robodad.battleship.model.Player;

import javafx.scene.layout.HBox;

public class GameBoard extends HBox {
    
    Player player1;
    Player player2;

    PlayerBoard playerBoard1;
    PlayerBoard playerBoard2;

    public GameBoard(Player player1, Player player2) {

        playerBoard1 = new PlayerBoard(player1);
        this.getChildren().add(playerBoard1);

        playerBoard2 = new PlayerBoard(player2);
        this.getChildren().add(playerBoard2);
    }
}
