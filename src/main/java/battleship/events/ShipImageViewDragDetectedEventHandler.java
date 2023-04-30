package battleship.events;

import battleship.view.ShipImageView;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class ShipImageViewDragDetectedEventHandler implements EventHandler<MouseEvent> {

    ShipImageView view;

    public ShipImageViewDragDetectedEventHandler(ShipImageView view) {
        this.view = view;
    }

    public void handle(MouseEvent event) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db = view.startDragAndDrop(TransferMode.COPY);
        
        /* Put an image on a dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putImage(view.getImage());
        db.setContent(content);
        
        event.consume();
    }
}

