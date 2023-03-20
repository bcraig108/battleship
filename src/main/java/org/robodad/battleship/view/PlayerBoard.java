package org.robodad.battleship.view;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class PlayerBoard extends BorderPane {

    public PlayerBoard(String player) {

        Label label = new Label(player);
        label.setAlignment(Pos.CENTER);
        this.setTop(label);

        OceanPane game = new OceanPane();
        this.setCenter(game);

        FleetPane fleet = new FleetPane();
        this.setBottom(fleet);
    }
}
