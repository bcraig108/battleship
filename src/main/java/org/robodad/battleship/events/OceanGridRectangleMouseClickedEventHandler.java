package org.robodad.battleship.events;

import org.robodad.battleship.controller.GameRules;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Shot;
import org.robodad.battleship.view.OceanGridRectangle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * This class handles a MouseClick event on a
 * {@link org.robodad.battleship.view.OceanGridRectangle}
 */
public class OceanGridRectangleMouseClickedEventHandler implements EventHandler<MouseEvent> {
    
    /** 
     * the {@link org.robodad.battleship.view.OceanGridRectangle} within the 
     * {@link org.robodad.battleship.view.OceanPane} 
     */
    private OceanGridRectangle rectangle;

    /** 
     * the {@link org.robodad.battleship.model.Player} that owns the rectangle
     */
    private Player player;

    /**
     * the {@link org.robodad.battleship.controller.GameRules} controlling the
     * game
     */
    private GameRules gameRules;

    /**
     * The constructor
     * @param rectangle - the {@link org.robodad.battleship.view.OceanGridRectangle}
     *                    within the {@link org.robodad.battleship.view.OceanPane}
     * @param player - the {@link org.robodad.battleship.model.Player} that
     *                 owns the rectangle
     * @param gameRules - the {@link org.robodad.battleship.controller.GameRules}
     *                    controlling the game
     */
    public OceanGridRectangleMouseClickedEventHandler(OceanGridRectangle rectangle, Player player, GameRules gameRules) {
        this.rectangle = rectangle;
        this.player = player;
        this.gameRules = gameRules;
    }

    /**
     * This method handles the button click event
     * @param event - the MouseEvent
     */
    public void handle(MouseEvent event) {
        // if left-click and game is in progress, place a shot at this grid
        // location
        if (event.getButton() == MouseButton.PRIMARY && gameRules.isReady()) {
            player.handleShot(new Shot(rectangle.getRow(), rectangle.getCol()));
        }
        event.consume();
    }
}
