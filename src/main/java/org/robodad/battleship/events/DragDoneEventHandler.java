package org.robodad.battleship.events;

import org.robodad.battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class DragDoneEventHandler implements EventHandler<DragEvent> {
    
    ShipImageView view;

    public DragDoneEventHandler(ShipImageView view) {
        this.view = view;
    }

    public void handle(DragEvent event) {
        /* the drag and drop gesture ended */
        /* if the data was successfully moved, clear it */
        if (event.getTransferMode() == TransferMode.MOVE) {
            view.setImage(null);
        }
        event.consume();
    }
}
