package org.robodad.battleship.view;

import org.robodad.battleship.Constants;
import org.robodad.battleship.controller.GameRules;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Shot;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class OceanPane extends GridPane {

    Player player;
    ImageView image; 
    Shot lastShot;

    public OceanPane(Player player, GameRules gameState) {
        this.player = player;
        player.setPane(this);

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

    public void addExplosion(Shot shot) {
        removeLast();

        image = new ExplosionImageView();
        this.add(image, shot.getCol(), shot.getRow());

        lastShot = shot;
    }

    public void addPlop(Shot shot) {
        removeLast();

        image = new PlopImageView();
        this.add(image, shot.getCol(), shot.getRow());

        lastShot = shot;
    }

    public void removeLast() {
        if (image != null && lastShot != null) {
            this.getChildren().remove(image);

            BurnImageView burn = new BurnImageView();
            this.add(burn, lastShot.getCol(), lastShot.getRow());
        }
    }
}
