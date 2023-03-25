package org.robodad.battleship.events;

import org.robodad.battleship.view.OceanGridRectangle;
import org.robodad.battleship.view.OceanPane;
import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;

public class OceanGridRectangeDragEnteredEventHandler implements EventHandler<DragEvent> {
    
    OceanPane pane;
    OceanGridRectangle rectangle;

    public OceanGridRectangeDragEnteredEventHandler(OceanPane pane, OceanGridRectangle rectangle) {
        this.pane = pane;
        this.rectangle = rectangle;
    }

    public void handle(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
        if (event.getGestureSource() instanceof ShipImageView) {
            ShipImageView ship = (ShipImageView)event.getGestureSource();
            
            ship.setColStart(rectangle.getCol());
            ship.setRowStart(rectangle.getRow());
            ship.update(pane);
        }
                       
         event.consume();
    }
}
