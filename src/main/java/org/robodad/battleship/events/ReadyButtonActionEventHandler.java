package org.robodad.battleship.events;

import org.robodad.battleship.controller.GameRules;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Player.PlayerState;
import org.robodad.battleship.view.FleetPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * This class handles a click of the player ready button
 */
public class ReadyButtonActionEventHandler implements EventHandler<ActionEvent> {

    /** 
     * the {@link org.robodad.battleship.model.Player} that owns the button
     */
    private Player player;

    /**
     * the {@link org.robodad.battleship.controller.GameRules} for the game
     */
    private GameRules rules;

    /**
     * the associated Button
     */
    private Button button;

    /**
     * the {@link org.robodad.battleship.view.FleetPane} for the player
     */
    private FleetPane pane;

    /**
     * The constructor
     * @param player - the {@link org.robodad.battleship.model.Player} that owns the button
     * @param rules - the {@link org.robodad.battleship.controller.GameRules} for the game
     * @param button - the associated Button
     * @param pane - the {@link org.robodad.battleship.view.FleetPane} for the player
     */
    public ReadyButtonActionEventHandler(Player player, GameRules rules, Button button, FleetPane pane) {
        this.player = player;
        this.rules = rules;
        this.button = button;
        this.pane = pane;
    }

    /**
     * Handles the button event
     * @param event - the event to hanle
     */
    @Override
    public void handle(ActionEvent event) {
        // set the player state to ready
        player.setState(PlayerState.READY);

        // if both players are ready, start the game
        if (this.rules.isReady()) {
            rules.start();
        }
        pane.updateNumShips(5);  // TODO - find a better way

        // disable the button
        button.setDisable(true);
    }
}
