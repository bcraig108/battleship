package battleship.view;

import battleship.model.Constants.*;

public class SubmarineImageView extends ShipImageView {
    
    public  static final int CELLS = 3;

    public SubmarineImageView() {
        super("Submarine", ShipType.SUBMARINE, CELLS,"submarine.png","submarine_vert.png");
    }
}
