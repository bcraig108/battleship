package org.robodad.battleship.events;

import org.robodad.battleship.controller.GameState;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Player.PlayerState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ReadyButtonActionEventHandler implements EventHandler<ActionEvent> {

    private Player player;
    private Button button;
    private GameState gameState;

    public ReadyButtonActionEventHandler(Player player, Button button, GameState gameState) {
        this.player = player;
        this.button = button;
        this.gameState = gameState;
    }

    @Override
    public void handle(ActionEvent event) {
        player.setState(PlayerState.READY);

        System.out.println(button.getText() + " " + player.getName());

        if (this.gameState.isReady()) {
            System.out.println("GAME READY!");
        }
    }
}
