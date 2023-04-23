package org.robodad.battleship.view;

import org.robodad.battleship.Constants.*;

public class DestroyerImageView extends ShipImageView {
    
    public static final int CELLS = 3;

    public DestroyerImageView() {
        super("Destroyer", ShipType.DESTROYER, CELLS,"destroyer.png","destroyer_vert.png");
    }
}
