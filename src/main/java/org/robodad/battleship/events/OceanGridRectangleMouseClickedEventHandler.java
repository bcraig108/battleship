package org.robodad.battleship.events;

import org.robodad.battleship.controller.GameRules;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Shot;
import org.robodad.battleship.view.OceanGridRectangle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class OceanGridRectangleMouseClickedEventHandler implements EventHandler<MouseEvent> {
    
    private OceanGridRectangle rectangle;
    private Player player;
    private GameRules gameState;

    public OceanGridRectangleMouseClickedEventHandler(OceanGridRectangle rectangle, Player player, GameRules gameState) {
        this.rectangle = rectangle;
        this.player = player;
        this.gameState = gameState;
    }

    public void handle(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && gameState.isReady()) {
            player.handleShot(new Shot(getRow(), getCol()));
        }
        event.consume();
    }

    private int getRow() {
        return rectangle.getRow();
    }

    private int getCol() {
        return rectangle.getCol();
    }
}
