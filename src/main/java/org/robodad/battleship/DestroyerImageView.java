package org.robodad.battleship;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DestroyerImageView extends ImageView {
    
    private static final double SIZE = 50;
    public  static final int CELLS = 3;

    public DestroyerImageView() {

        //creating the image object
        Image image = new Image(getClass().getResourceAsStream("destroyer.png"));

        //Setting image to the image view
        this.setImage(image);
        this.setFitHeight(SIZE);
        this.setFitWidth(SIZE * CELLS);
    }
}
