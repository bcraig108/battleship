package org.robodad.battleship.view;

import java.io.Serializable;

import org.robodad.battleship.Constants;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class ShipImageView extends ImageView {

    public enum Orientation { NORTH, EAST };

    private Orientation orientation;
    private int cells;
    private String file;

    /**
     * ShipImageView constructor
     * @param cells
     * @param file
     */
    public ShipImageView(int cells, String file) {

        this.cells = cells;
        this.orientation = Orientation.EAST;
        this.file = file;

        Image image = new Image(getClass().getResourceAsStream(file));

        //Setting image to the image view
        this.setImage(image);
        this.setFitHeight(Constants.SIZE);
        this.setFitWidth(Constants.SIZE * cells);

        ShipImageView view = this;

        this.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = view.startDragAndDrop(TransferMode.COPY);
                
                /* Put a string on a dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(view.getImage());
                db.setContent(content);
                
                event.consume();
                System.out.println("ShipImageView.DragDetected.handle()");
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
                System.out.println("ShipImageView.DragDone.handle()");
            }
        });

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                    if (view.getOrientation() == Orientation.EAST) {
                        view.setRotate(90.0);
                        view.setOrientation(Orientation.NORTH);
                    }
                    else {
                        view.setRotate(0.0);
                        view.setOrientation(Orientation.EAST);
                    }
                }
                event.consume();
                System.out.println("ShipImageView.MouseEvent.handle()");
            }
        });
    }

    /**
     * getCells returns the number of cells occupied by the ship
     * @return (int) the number of cells occupied by the ship
     */
    public int getCells() {
        return cells;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
