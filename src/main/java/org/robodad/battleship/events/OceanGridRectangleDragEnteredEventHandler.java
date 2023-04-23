package org.robodad.battleship.events;

import org.robodad.battleship.view.OceanGridRectangle;
import org.robodad.battleship.view.OceanPane;
import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;

/**
 * This class handles a {@link org.robodad.battleship.view.ShipImageView} being
 * dragged over an {@link org.robodad.battleship.view.OceanGridRectangle}
 */
public class OceanGridRectangleDragEnteredEventHandler 
    implements EventHandler<DragEvent> {
    
    /** the player's {@link org.robodad.battleship.view.OceanPane} */
    OceanPane pane;

    /** 
     * the {@link org.robodad.battleship.view.OceanGridRectangle} within the 
     * {@link org.robodad.battleship.view.OceanPane} 
     */
    OceanGridRectangle rectangle;

    /**
     * The constructor
     * @param pane - the player's {@link org.robodad.battleship.view.OceanPane}
     * @param rectangle - the {@link org.robodad.battleship.view.OceanGridRectangle}
     *                    where the ship was dragged
     */
    public OceanGridRectangleDragEnteredEventHandler(OceanPane pane, OceanGridRectangle rectangle) {
        this.pane = pane;
        this.rectangle = rectangle;
    }

    /**
     * Handle the DragDropDragOverped event
     * @param event - the DragOver event
     */
    public void handle(DragEvent event) {

        // if the object dragged was a ShipImageView
        if (event.getGestureSource() instanceof ShipImageView) {
            ShipImageView ship = (ShipImageView)event.getGestureSource();
            
            // show the ship at the current drag location
            ship.setColStart(rectangle.getCol());
            ship.setRowStart(rectangle.getRow());
            ship.update(pane);
        }
                       
         event.consume();
    }
}
