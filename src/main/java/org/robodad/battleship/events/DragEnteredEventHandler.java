package org.robodad.battleship.events;

import org.robodad.battleship.view.GameGridRectangle;
import org.robodad.battleship.view.GamePane;
import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;

public class DragEnteredEventHandler implements EventHandler<DragEvent> {
    
    GamePane parent;
    GameGridRectangle rectangle;

    public DragEnteredEventHandler(GamePane parent, GameGridRectangle rectangle) {
        this.parent = parent;
        this.rectangle = rectangle;
    }

    public void handle(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
        if (event.getGestureSource() instanceof ShipImageView) {
            ShipImageView ship = (ShipImageView)event.getGestureSource();
            
            parent.add(
                ship, 
                ship.getColStart(rectangle.getCol()), 
                ship.getRowStart(rectangle.getRow()), 
                ship.getCols(), 
                ship.getRows());
        }
                       
         event.consume();
         System.out.println("DragEnteredEventHandler.handle()");
    }
}
