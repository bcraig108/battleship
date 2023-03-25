package org.robodad.battleship.view;

import org.robodad.battleship.events.ReadyButtonActionEventHandler;
import org.robodad.battleship.model.Player;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class FleetPane extends VBox {
    
    private Player player;

    public FleetPane(Player player) {
        this.player = player;

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
        button.setOnAction(new ReadyButtonActionEventHandler(player, button));
        this.getChildren().add(button);
    }
}
