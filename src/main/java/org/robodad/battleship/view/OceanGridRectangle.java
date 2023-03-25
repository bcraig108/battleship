package org.robodad.battleship.view;

import org.robodad.battleship.Constants;
import org.robodad.battleship.events.OceanGridRectangeDragDroppedEventHandler;
import org.robodad.battleship.events.OceanGridRectangeDragEnteredEventHandler;
import org.robodad.battleship.model.Player;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanGridRectangle extends Rectangle {
    
    private int row;
    private int col;
    private Player player;

    public OceanGridRectangle(int row, int col, OceanPane parent, Player player) {
        super(Constants.SIZE, Constants.SIZE);

        this.row = row;
        this.col = col;
        this.player = player;

        Color color =  Color.SEAGREEN;
        if ((row % 2) == (col % 2)) {
            color = Color.LIGHTSEAGREEN;
        }
        this.setFill(color);

        this.setOnDragEntered(new OceanGridRectangeDragEnteredEventHandler(parent, this));
        this.setOnDragDropped(new OceanGridRectangeDragDroppedEventHandler(parent, this));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
