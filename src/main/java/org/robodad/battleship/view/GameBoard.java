package org.robodad.battleship.view;

import org.robodad.battleship.Constants;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameBoard extends ImageView {
    public GameBoard() {
        Image image = new Image(getClass().getResourceAsStream("background.jpg"));
        this.setImage(image);
        this.setFitHeight(Constants.SIZE * Constants.NUM_ROWS);
        this.setFitWidth(Constants.SIZE * Constants.NUM_COLS);
    }
}
