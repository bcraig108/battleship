package org.robodad.battleship.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class FleetPane extends VBox {
    
    public FleetPane() {

        setAlignment(Pos.CENTER);

        CarrierImageView carrier = new CarrierImageView();
        this.getChildren().add(carrier);

        BattleshipImageView battleship = new BattleshipImageView();
        this.getChildren().add(battleship);

        DestroyerImageView detroyer = new DestroyerImageView();
        this.getChildren().add(detroyer);

        SubmarineImageView submarine = new SubmarineImageView();
        this.getChildren().add(submarine);

        PatrolImageView patrol = new PatrolImageView();
        this.getChildren().add(patrol);

        Button button = new Button();
        button.setText("READY!");
        this.getChildren().add(button);
    }
}
