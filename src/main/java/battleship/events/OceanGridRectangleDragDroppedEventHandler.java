package battleship.events;

import battleship.view.OceanGridRectangle;
import battleship.view.OceanPane;
import battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;

/**
 * This class handles a {@link battleship.view.ShipImageView} being
 * dropped onto an {@link battleship.view.OceanGridRectangle}
 */
public class OceanGridRectangleDragDroppedEventHandler 
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
     *                    where the ship was dropped
     */
    public OceanGridRectangleDragDroppedEventHandler(OceanPane pane, OceanGridRectangle rectangle) {
        this.pane = pane;
        this.rectangle = rectangle;
    }
    
    /**
     * Handle the DragDropped event
     * @param event - the DragDropped event
     */
    public void handle(DragEvent event) {
        boolean success = false;

        // if the object dropped was a ShipImageView
        if (event.getGestureSource() instanceof ShipImageView) {
            ShipImageView ship = (ShipImageView)event.getGestureSource();

            // set the ship position based on drop location
            ship.setColStart(rectangle.getCol());
            ship.setRowStart(rectangle.getRow());
            ship.update(pane);

            success = true;
        }

        event.setDropCompleted(success);        
        event.consume();
     }
}
