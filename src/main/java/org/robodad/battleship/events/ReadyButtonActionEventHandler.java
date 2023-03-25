package org.robodad.battleship.events;

import org.robodad.battleship.model.Player;
import org.robodad.battleship.view.FleetPane;
import org.robodad.battleship.view.PlayerBoard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ReadyButtonActionEventHandler implements EventHandler<ActionEvent> {

    private Player player;
    private Button button;

    public ReadyButtonActionEventHandler(Player player, Button button) {
        this.player = player;
        this.button = button;
    }

    @Override
    public void handle(ActionEvent event) {
        // String message;
        // if (playerBoard == null) {
        //     message = "playerBoard = null";
        // }
        // else {
        //     String player = playerBoard.getPlayer();
        //     if (player == null) {
        //         message = "player = null";
        //     }
        //     else {
        //         message = player;
        //     }
        // }
        System.out.println(button.getText() + " " + player.getName());// + playerBoard.getPlayer());
    }
}
