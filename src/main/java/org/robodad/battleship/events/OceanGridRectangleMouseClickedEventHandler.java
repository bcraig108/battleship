package org.robodad.battleship.events;

import org.robodad.battleship.controller.GameState;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Shot;
import org.robodad.battleship.view.OceanGridRectangle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class OceanGridRectangleMouseClickedEventHandler implements EventHandler<MouseEvent> {
    
    private OceanGridRectangle rectangle;
    private Player player;
    private GameState gameState;

    public OceanGridRectangleMouseClickedEventHandler(OceanGridRectangle rectangle, Player player, GameState gameState) {
        this.rectangle = rectangle;
        this.player = player;
        this.gameState = gameState;
    }

    public void handle(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && gameState.isReady()) {
            if (player.isHit(new Shot(getRow(), getCol()))) {
                System.out.println("Hit! ROW " + getRow() + " COL " + getCol());
                rectangle.addExplosion();
            }
            else {
                System.out.println("Miss! ROW " + getRow() + " COL " + getCol());
                rectangle.addPlop();
            }
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
