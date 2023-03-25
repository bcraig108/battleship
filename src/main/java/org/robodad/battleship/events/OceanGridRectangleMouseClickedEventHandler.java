package org.robodad.battleship.events;

import org.robodad.battleship.view.ExplosionImageView;
import org.robodad.battleship.view.OceanGridRectangle;
import org.robodad.battleship.view.OceanPane;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class OceanGridRectangleMouseClickedEventHandler implements EventHandler<MouseEvent> {
    
    OceanPane pane;
    OceanGridRectangle rectangle;

    public OceanGridRectangleMouseClickedEventHandler(OceanPane pane, OceanGridRectangle rectangle) {
        this.pane = pane;
        this.rectangle = rectangle;
    }

    public void handle(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            System.out.println("BOOM! ROW " + this.rectangle.getRow() + " COL " + this.rectangle.getCol());
            rectangle.addExplosion();
        }
        event.consume();
    }
}
