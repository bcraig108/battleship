package org.robodad.battleship.view;

public class CarrierImageView extends ShipImageView {
    
    public  static final int CELLS = 5;

    public CarrierImageView() {
        super("Carrier", CELLS,"carrier.png","carrier_vert.png");
    }
}
