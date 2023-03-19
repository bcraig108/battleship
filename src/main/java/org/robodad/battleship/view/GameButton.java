package org.robodad.battleship.view;

import org.robodad.battleship.Constants;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class GameButton extends Button {

    public GameButton() {
        this.setText("O");
        this.setAlignment(Pos.CENTER);
        this.setMinWidth(Constants.SIZE);
        this.setMinHeight(Constants.SIZE);

        Button button = this;

        this.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                /* accept it only if it is not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != button && event.getDragboard().hasImage()) {
                    /* allow for moving */
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                
                event.consume();
            }
        });

        this.setOnDragEntered(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
            /* the drag-and-drop gesture entered the target */
            /* show to the user that it is an actual gesture target */
                 if (event.getGestureSource() != button && event.getDragboard().hasImage()) {
                    // TODO button.setFocusTraversable(true);
                 }
                        
                 event.consume();
            }
        });

        this.setOnDragExited(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                // TODO target.setFill(Color.BLACK);
        
                event.consume();
            }
        });

        this.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {
                    // TODO button.setImage(db.getImage());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                
                event.consume();
             }
        });
    }
}
