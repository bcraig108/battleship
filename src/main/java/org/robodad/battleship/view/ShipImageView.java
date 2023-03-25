package org.robodad.battleship.view;

import org.robodad.battleship.Constants;
import org.robodad.battleship.events.ShipImageViewDragDetectedEventHandler;
import org.robodad.battleship.events.ShipImageViewDragDoneEventHandler;
import org.robodad.battleship.events.ShipImageViewMouseClickedEventHandler;

import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShipImageView extends ImageView {

    private int cells;
    private Orientation orientation;
    private Image horizImage;
    private Image vertImage;
    private int rowStart = -1;
    private int colStart = -1;
    private OceanPane pane = null;

    /**
     * ShipImageView constructor
     * @param cells
     * @param file
     */
    public ShipImageView(int cells, String HorizFile, String VertFile) {

        this.cells = cells;
        this.orientation = Orientation.HORIZONTAL;

        this.horizImage = new Image(
            getClass().getResourceAsStream(HorizFile),
            cells * Constants.SIZE,
            Constants.SIZE,
            false,
            false);

        this.vertImage = new Image(
            getClass().getResourceAsStream(VertFile),
            cells * Constants.SIZE,
            Constants.SIZE,
            false,
            false);
        
        // setting image to the image view
        this.setImage(this.horizImage);
        this.setFitHeight(Constants.SIZE);
        this.setFitWidth(Constants.SIZE * cells);

        // setup event handlers
        this.setOnDragDetected(new ShipImageViewDragDetectedEventHandler(this));
        this.setOnDragDone(new ShipImageViewDragDoneEventHandler(this));
        this.setOnMouseClicked(new ShipImageViewMouseClickedEventHandler(this));
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

    public void setRowStart(int row) {
        rowStart = Math.max(Math.min(row, Constants.NUM_ROWS - getRows() + 1), 1); 
    }

    public int getRowStart() {
        return rowStart;
    }

    public void setColStart(int col) {
        colStart = Math.max(Math.min(col, Constants.NUM_COLS - getCols() + 1), 1);
    }

    public int getColStart() {
        return colStart;
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

    public void setGamePane(OceanPane pane) {
        this.pane = pane;
    }

    public OceanPane getGamePane() {
        return pane;
    }

    public void update(OceanPane pane) {
        pane.getChildren().remove(this);
        pane.add(
            this, 
            colStart, 
            rowStart, 
            getCols(), 
            getRows());

        setGamePane(pane);
    }

    public void HandleMouseButtonSecondary(double sceneX, double sceneY) {

        if (orientation == Orientation.HORIZONTAL) {
            orientation = Orientation.VERTICAL;
            setImage(this.vertImage);
            setFitHeight(Constants.SIZE * cells);
            setFitWidth(Constants.SIZE);
        }
        else {
            orientation = Orientation.HORIZONTAL;
            setImage(this.horizImage);
            setFitHeight(Constants.SIZE);
            setFitWidth(Constants.SIZE * cells);
        }

        // update the position based on where the mouse was clicked
        setRowStart(rowStart);
        setColStart(colStart);
    
        update(pane);
    }
}
