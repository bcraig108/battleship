package org.robodad.battleship.events;

import org.robodad.battleship.view.GameGridRectangle;
import org.robodad.battleship.view.GamePane;
import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;

public class DragEnteredEventHandler implements EventHandler<DragEvent> {
    
    GamePane pane;
    GameGridRectangle rectangle;

    public DragEnteredEventHandler(GamePane pane, GameGridRectangle rectangle) {
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
