package battleship.view;

import battleship.model.Constants.*;

public class DestroyerImageView extends ShipImageView {
    
    public static final int CELLS = 3;

    public DestroyerImageView() {
        super("Destroyer", ShipType.DESTROYER, CELLS,"destroyer.png","destroyer_vert.png");
    }
}
