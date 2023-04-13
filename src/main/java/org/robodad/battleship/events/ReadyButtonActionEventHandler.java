package org.robodad.battleship.events;

import org.robodad.battleship.controller.GameRules;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Player.PlayerState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ReadyButtonActionEventHandler implements EventHandler<ActionEvent> {

    private Player player;
    private Button button;
    private GameRules gameRules;

    public ReadyButtonActionEventHandler(Player player, Button button, GameRules gameRules) {
        this.player = player;
        this.button = button;
        this.gameRules = gameRules;
    }

    @Override
    public void handle(ActionEvent event) {
        player.setState(PlayerState.READY);

        System.out.println(button.getText() + " " + player.getName());
        if (this.gameRules.isReady()) {
            gameRules.start();
        }
    }
}
