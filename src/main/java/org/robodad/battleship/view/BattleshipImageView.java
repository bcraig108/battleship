package org.robodad.battleship.view;

import org.robodad.battleship.Constants.*;

public class BattleshipImageView extends ShipImageView {
    
    public  static final int CELLS = 4;

    public BattleshipImageView() {
        super("Battleship", ShipType.BATTLESHIP, CELLS,"battleship.png", "battleship_vert.png");
    }
}
