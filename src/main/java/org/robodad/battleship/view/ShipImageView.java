package org.robodad.battleship.view;

import org.robodad.battleship.Constants;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class ShipImageView extends ImageView {

    public ShipImageView(int cells, String file) {

        Image image = new Image(getClass().getResourceAsStream(file));

        //Setting image to the image view
        this.setImage(image);
        this.setFitHeight(Constants.SIZE);
        this.setFitWidth(Constants.SIZE * cells);

        ImageView view = this;

        this.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = view.startDragAndDrop(TransferMode.MOVE);
                
                /* Put a string on a dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(image);
                db.setContent(content);
                
                event.consume();
            }
        });

        this.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag and drop gesture ended */
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    view.setImage(null);
                }
                event.consume();
            }
        });
    }
}
