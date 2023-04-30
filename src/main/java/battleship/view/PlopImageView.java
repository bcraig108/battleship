package battleship.view;

import battleship.model.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlopImageView extends ImageView {
    
    private Image image;

    public PlopImageView() {

        this.image = new Image(
            getClass().getResourceAsStream("drop.gif"),
            Constants.SIZE,
            Constants.SIZE,
            false,
            false);

        // setting image to the image view
        this.setImage(this.image);
        this.setFitHeight(Constants.SIZE);
        this.setFitWidth(Constants.SIZE);
    }
}
