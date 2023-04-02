package org.robodad.battleship.view;

public class SubmarineImageView extends ShipImageView {
    
    public  static final int CELLS = 3;

    public SubmarineImageView() {
        super("Submarine", CELLS,"submarine.png","submarine_vert.png");
    }
}
