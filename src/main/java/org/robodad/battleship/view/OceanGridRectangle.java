package org.robodad.battleship.view;

import org.robodad.battleship.Constants;
import org.robodad.battleship.events.DragDroppedEventHandler;
import org.robodad.battleship.events.DragEnteredEventHandler;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanGridRectangle extends Rectangle {
    
    private int row;
    private int col;

    public OceanGridRectangle(int row, int col, OceanPane parent) {
        super(Constants.SIZE, Constants.SIZE);

        this.row = row;
        this.col = col;

        Color color =  Color.SEAGREEN;
        if ((row % 2) == (col % 2)) {
            color = Color.LIGHTSEAGREEN;
        }
        this.setFill(color);

        this.setOnDragEntered(new DragEnteredEventHandler(parent, this));
        this.setOnDragDropped(new DragDroppedEventHandler(parent, this));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
