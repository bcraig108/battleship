package org.robodad.battleship.events;

import org.robodad.battleship.view.OceanGridRectangle;
import org.robodad.battleship.view.OceanPane;
import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.input.DragEvent;

public class OceanGridRectangleDragDroppedEventHandler implements EventHandler<DragEvent> {

    OceanPane pane;
    OceanGridRectangle rectangle;

    public OceanGridRectangleDragDroppedEventHandler(OceanPane pane, OceanGridRectangle rectangle) {
        this.pane = pane;
        this.rectangle = rectangle;
    }
    
    public void handle(DragEvent event) {
        boolean success = false;

        if (event.getGestureSource() instanceof ShipImageView) {
            ShipImageView ship = (ShipImageView)event.getGestureSource();

            ship.setColStart(rectangle.getCol());
            ship.setRowStart(rectangle.getRow());
            ship.update(pane);

            success = true;
        }

        event.setDropCompleted(success);        
        event.consume();
     }
}
