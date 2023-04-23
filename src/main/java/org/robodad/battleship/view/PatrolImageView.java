package org.robodad.battleship.view;

import org.robodad.battleship.Constants.*;

public class PatrolImageView extends ShipImageView {
    
    public  static final int CELLS = 2;

    public PatrolImageView() {
        super("Patrol Boat", ShipType.PATROL_BOAT, CELLS,"patrol.png","patrol_vert.png");
    }
}
