package battleship.events;

import battleship.controller.GameRules;
import battleship.model.Player;
import battleship.model.Shot;
import battleship.view.OceanGridRectangle;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * This class handles a MouseClick event on a
 * {@link battleship.view.OceanGridRectangle}
 */
public class OceanGridRectangleMouseClickedEventHandler implements EventHandler<MouseEvent> {
    
    /** 
     * the {@link battleship.view.OceanGridRectangle} within the 
     * {@link battleship.view.OceanPane} 
     */
    private OceanGridRectangle rectangle;

    /** 
     * the {@link battleship.model.Player} that owns the rectangle
     */
    private Player player;

    /**
     * the {@link battleship.controller.GameRules} controlling the
     * game
     */
    private GameRules gameRules;

    /**
     * The constructor
     * @param rectangle - the {@link battleship.view.OceanGridRectangle}
     *                    within the {@link battleship.view.OceanPane}
     * @param player - the {@link battleship.model.Player} that
     *                 owns the rectangle
     * @param gameRules - the {@link battleship.controller.GameRules}
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
