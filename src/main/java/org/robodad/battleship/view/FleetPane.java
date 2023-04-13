package org.robodad.battleship.view;

import org.robodad.battleship.controller.GameRules;
import org.robodad.battleship.events.ReadyButtonActionEventHandler;
import org.robodad.battleship.model.Player;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class FleetPane extends VBox {
    
    private Player player;
    private GameRules gameState;

    public FleetPane(Player player, GameRules gameState) {
        this.player = player;
        this.gameState = gameState;

        setAlignment(Pos.CENTER);

        CarrierImageView carrier = new CarrierImageView();
        this.getChildren().add(carrier);
        player.addShip(carrier);

        BattleshipImageView battleship = new BattleshipImageView();
        this.getChildren().add(battleship);
        player.addShip(battleship);

        DestroyerImageView detroyer = new DestroyerImageView();
        this.getChildren().add(detroyer);
        player.addShip(detroyer);

        SubmarineImageView submarine = new SubmarineImageView();
        this.getChildren().add(submarine);
        player.addShip(submarine);

        PatrolImageView patrol = new PatrolImageView();
        this.getChildren().add(patrol);
        player.addShip(patrol);

        Button button = new Button();
        button.setText("READY!");
        button.setOnAction(new ReadyButtonActionEventHandler(player, button, gameState));
        this.getChildren().add(button);
    }
}
