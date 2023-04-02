package org.robodad.battleship.view;

import org.robodad.battleship.Constants;
import org.robodad.battleship.events.OceanGridRectangleDragDroppedEventHandler;
import org.robodad.battleship.events.OceanGridRectangleDragEnteredEventHandler;
import org.robodad.battleship.events.OceanGridRectangleMouseClickedEventHandler;
import org.robodad.battleship.model.Player;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanGridRectangle extends Rectangle {
    
    private int row;
    private int col;
    private OceanPane pane;
    private ExplosionImageView explosion;

    public OceanGridRectangle(int row, int col, OceanPane pane, Player player) {
        super(Constants.SIZE, Constants.SIZE);

        this.row = row;
        this.col = col;
        this.pane = pane;

        Color color =  Color.SEAGREEN;
        if ((row % 2) == (col % 2)) {
            color = Color.LIGHTSEAGREEN;
        }
        this.setFill(color);

        this.setOnDragEntered(new OceanGridRectangleDragEnteredEventHandler(pane, this));
        this.setOnDragDropped(new OceanGridRectangleDragDroppedEventHandler(pane, this));
        this.setOnMouseClicked(new OceanGridRectangleMouseClickedEventHandler(pane, this, player));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void addExplosion() {
        if (explosion == null) {
            explosion = new ExplosionImageView();
            pane.add(explosion, col, row);
        }  
    }
}
