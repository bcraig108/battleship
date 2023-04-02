package org.robodad.battleship.view;

import org.robodad.battleship.Constants;
import org.robodad.battleship.controller.GameState;
import org.robodad.battleship.model.Player;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class OceanPane extends GridPane {

    Player player;

    public OceanPane(Player player, GameState gameState) {
        this.player = player;

        for (int row = 1; row <= Constants.NUM_ROWS; row++) {

            Label rowLabel = new Label();
            rowLabel.setText(String.valueOf((char)(row + 64)));
            rowLabel.setAlignment(Pos.CENTER);
            rowLabel.setMinWidth(Constants.SIZE);
            rowLabel.setMinHeight(Constants.SIZE);
            this.add(rowLabel,0,row);

            for (int col = 1; col <= Constants.NUM_COLS; col++) {
            
                Label colLabel = new Label();
                colLabel.setText(Integer.toString(col));
                colLabel.setAlignment(Pos.CENTER);
                colLabel.setMinWidth(Constants.SIZE);
                colLabel.setMinHeight(Constants.SIZE);
                this.add(colLabel,col,0);
                    
                OceanGridRectangle rectangle = new OceanGridRectangle(row, col, this, player, gameState);
    
                this.add(rectangle,col,row,1,1);        
            }
        }
    }
}
