package battleship.view;

import battleship.model.Constants.*;

public class CarrierImageView extends ShipImageView {
    
    public  static final int CELLS = 5;

    public CarrierImageView() {
        super("Carrier", ShipType.CARRIER, CELLS,"carrier.png","carrier_vert.png");
    }
}
