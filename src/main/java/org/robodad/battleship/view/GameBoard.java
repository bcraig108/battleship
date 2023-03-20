package org.robodad.battleship.view;

import javafx.scene.layout.HBox;

public class GameBoard extends HBox {
    
    public GameBoard() {

        PlayerBoard player1 = new PlayerBoard("Player 1");
        this.getChildren().add(player1);

        PlayerBoard player2 = new PlayerBoard("Player 2");
        this.getChildren().add(player2);
    }
}
