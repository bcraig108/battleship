package battleship.events;

import battleship.view.OceanGridRectangle;
import battleship.view.OceanPane;
import battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;

/**
 * This class handles a {@link battleship.view.ShipImageView} being
 * dragged over an {@link battleship.view.OceanGridRectangle}
 */
public class OceanGridRectangleDragEnteredEventHandler 
    implements EventHandler<DragEvent> {
    
    /** the player's {@link battleship.view.OceanPane} */
    OceanPane pane;

    /** 
     * the {@link battleship.view.OceanGridRectangle} within the 
     * {@link battleship.view.OceanPane} 
     */
    OceanGridRectangle rectangle;

    /**
     * The constructor
     * @param pane - the player's {@link battleship.view.OceanPane}
     * @param rectangle - the {@link battleship.view.OceanGridRectangle}
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
