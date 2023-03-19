package org.robodad.battleship.events;

import org.robodad.battleship.view.GameGridRectangle;
import org.robodad.battleship.view.GamePane;
import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.input.DragEvent;

public class DragDroppedEventHandler implements EventHandler<DragEvent> {

    GamePane pane;
    GameGridRectangle rectangle;

    public DragDroppedEventHandler(GamePane pane, GameGridRectangle rectangle) {
        this.pane = pane;
        this.rectangle = rectangle;
    }
    
    public void handle(DragEvent event) {
        boolean success = false;

        if (event.getGestureSource() instanceof ShipImageView) {
            ShipImageView ship = (ShipImageView)event.getGestureSource();
            
            pane.add(
                ship, 
                ship.getColStart(rectangle.getCol()), 
                ship.getRowStart(rectangle.getRow()), 
                ship.getCols(), 
                ship.getRows());
            success = true;
        }

        event.setDropCompleted(success);
        System.out.println("DragDroppedEventHandler.handle()");
        
        event.consume();
     }
}
