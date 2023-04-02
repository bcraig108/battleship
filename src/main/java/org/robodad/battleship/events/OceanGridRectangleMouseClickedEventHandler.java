package org.robodad.battleship.events;

import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Shot;
import org.robodad.battleship.view.ExplosionImageView;
import org.robodad.battleship.view.OceanGridRectangle;
import org.robodad.battleship.view.OceanPane;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class OceanGridRectangleMouseClickedEventHandler implements EventHandler<MouseEvent> {
    
    private OceanPane pane;
    private OceanGridRectangle rectangle;
    private Player player;

    public OceanGridRectangleMouseClickedEventHandler(OceanPane pane, OceanGridRectangle rectangle, Player player) {
        this.pane = pane;
        this.rectangle = rectangle;
        this.player = player;
    }

    public void handle(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (player.isHit(new Shot(this.rectangle.getRow(), this.rectangle.getCol()))) {
                System.out.println("Hit! ROW " + this.rectangle.getRow() + " COL " + this.rectangle.getCol());
                rectangle.addExplosion();
            }
            else {
                System.out.println("Miss! ROW " + this.rectangle.getRow() + " COL " + this.rectangle.getCol());
                rectangle.addPlop();
            }
        }
        event.consume();
    }
}
