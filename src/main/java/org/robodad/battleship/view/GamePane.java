package org.robodad.battleship.view;

import org.robodad.battleship.Constants;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

public class GamePane extends GridPane {

    public GamePane() {
        
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

                // GameButton btn = new GameButton();
                // this.add(btn,col,row);
            }
        }

        GameBoard board = new GameBoard();
        this.add(board,1,1,10,10);
        
        Label fleetLabel = new Label();
        fleetLabel.setText("FLEET");
        fleetLabel.setAlignment(Pos.CENTER);
        this.add(fleetLabel,2,13,5,1);

        CarrierImageView carrier = new CarrierImageView();
        this.add(carrier, 2, 14, 5, 1);

        BattleshipImageView battleship = new BattleshipImageView();
        this.add(battleship, 2, 15, 4, 1);

        DestroyerImageView detroyer = new DestroyerImageView();
        this.add(detroyer, 2, 16, 3, 1);

        SubmarineImageView submarine = new SubmarineImageView();
        this.add(submarine, 2, 17, 3, 1);

        PatrolImageView patrol = new PatrolImageView();
        this.add(patrol, 2, 18, 2, 1);
    }
}
