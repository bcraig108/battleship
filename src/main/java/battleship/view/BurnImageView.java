package battleship.view;

import battleship.model.Constants;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BurnImageView extends ImageView {
    
    private Image image;

    public BurnImageView() {

        this.image = new Image(
            getClass().getResourceAsStream("burn.png"),
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
