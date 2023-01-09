package org.robodad.battleship.view;

import org.robodad.battleship.Constants;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameGridRectangle extends Rectangle {
    
    private int row;
    private int col;

    private GamePane parent;
    private ImageView imageView = null;

    public GameGridRectangle(int row, int col, GamePane parent) {
        super(Constants.SIZE, Constants.SIZE);

        this.row = row;
        this.col = col;
        this.parent = parent;

        if ((row % 2) == (col % 2)) {
            this.setFill(Color.LIGHTSEAGREEN);
        }
        else {
            this.setFill(Color.SEAGREEN);
        }

        GameGridRectangle rectangle = this;

        this.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                /* accept it only if it is not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != rectangle && event.getDragboard().hasImage()) {
                    /* allow for moving */
                    event.acceptTransferModes(TransferMode.COPY);

                    // ShipImageView ship = (ShipImageView)event.getGestureSource();
                }
                System.out.println("GameGridRectangle.DragOver.handle()");
                event.consume();
            }
        });

        // this.setOnDragEntered(new EventHandler<DragEvent>() {
        //     public void handle(DragEvent event) {
        //     /* the drag-and-drop gesture entered the target */
        //     /* show to the user that it is an actual gesture target */
        //          if (event.getGestureSource() != rectangle && event.getDragboard().hasImage()) {
        //             rectangle.setFocusTraversable(true);
        //          }
                        
        //          event.consume();
        //          System.out.println("GameGridRectangle.DragEntered.handle()");
        //     }
        // });

        // this.setOnDragExited(new EventHandler<DragEvent>() {
        //     public void handle(DragEvent event) {
        //         /* mouse moved away, remove the graphical cues */
        //         // TODO target.setFill(Color.BLACK);
        
        //         event.consume();
        //         System.out.println("GameGridRectangle.DragExited.handle()");
        //     }
        // });

        this.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                /* if there is a string data on dragboard, read it and use it */
                // Dragboard db = event.getDragboard();
                boolean success = false;
                // if (db.hasImage()) {
                if (event.getGestureSource() instanceof ShipImageView) {
                    ShipImageView ship = (ShipImageView)event.getGestureSource();
                    
                    int rows = 1;
                    int cols = 1;

                    if (ship.getOrientation() == ShipImageView.Orientation.EAST) {
                        cols = ship.getCells();
                    }
                    else {
                        rows = ship.getCells();
                    }

                    parent.add(ship, rectangle.getCol(), rectangle.getRow(), cols, rows);
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                System.out.println("GameGridRectangle.DragDropped.handle()");
                
                event.consume();
             }
        });

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
