package org.robodad.battleship.events;

import org.robodad.battleship.controller.GameRules;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Player.PlayerState;
import org.robodad.battleship.view.FleetPane;
import org.robodad.battleship.view.PlayerBoard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ReadyButtonActionEventHandler implements EventHandler<ActionEvent> {

    private Player player;
    private GameRules rules;
    private Button button;
    private FleetPane pane;

    public ReadyButtonActionEventHandler(Player player, GameRules rules, Button button, FleetPane pane) {
        this.player = player;
        this.rules = rules;
        this.button = button;
        this.pane = pane;
    }

    @Override
    public void handle(ActionEvent event) {
        player.setState(PlayerState.READY);
        if (this.rules.isReady()) {
            rules.start();
        }
        pane.updateNumShips(5);  // TODO - find a better way
        button.setDisable(true);
    }
}
