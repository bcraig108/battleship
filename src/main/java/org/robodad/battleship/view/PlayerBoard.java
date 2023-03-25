package org.robodad.battleship.view;

import org.robodad.battleship.model.Player;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PlayerBoard extends BorderPane {

    private Player player;

    public PlayerBoard(Player player) {
        this.player = player;

        Label label = new Label(player.getName());
        label.setAlignment(Pos.CENTER);
        this.setTop(label);

        OceanPane game = new OceanPane(player);
        this.setCenter(game);

        FleetPane fleet = new FleetPane(player);
        this.setBottom(fleet);
    }

    public Player getPlayer() {
        return this.player;
    }
}
