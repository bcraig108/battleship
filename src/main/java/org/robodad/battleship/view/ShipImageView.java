package org.robodad.battleship.view;

import java.lang.invoke.ConstantCallSite;

import org.robodad.battleship.Constants;
import org.robodad.battleship.events.DragDetectedEventHandler;
import org.robodad.battleship.events.DragDoneEventHandler;
import org.robodad.battleship.events.MouseClickedEventHandler;

import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShipImageView extends ImageView {

    private Orientation orientation;
    private int cells;

    /**
     * ShipImageView constructor
     * @param cells
     * @param file
     */
    public ShipImageView(int cells, String file) {

        this.cells = cells;
        this.orientation = Orientation.HORIZONTAL;

        Image image = new Image(getClass().getResourceAsStream(file));

        // setting image to the image view
        this.setImage(image);
        this.setFitHeight(Constants.SIZE);
        this.setFitWidth(Constants.SIZE * cells);

        // setup event handlers
        this.setOnDragDetected(new DragDetectedEventHandler(this));
        this.setOnDragDone(new DragDoneEventHandler(this));
        this.setOnMouseClicked(new MouseClickedEventHandler(this));
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

    public int getRowStart(int row) {
        return Math.max(Math.min(row, Constants.NUM_ROWS - getRows() + 1), 1);
    }

    public int getColStart(int col) {
        return Math.max(Math.min(col, Constants.NUM_COLS - getCols() + 1), 1);
    }

    public int getRows() {
        if (orientation == Orientation.HORIZONTAL) {
            return 1;
        } else {
            return cells;
        }
    }

    public int getCols() {
        if (orientation == Orientation.HORIZONTAL) {
            return cells;
        } else {
            return 1;
        }
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
