package battleship.view;

import battleship.controller.GameRules;
import battleship.events.OceanGridRectangleDragDroppedEventHandler;
import battleship.events.OceanGridRectangleDragEnteredEventHandler;
import battleship.events.OceanGridRectangleMouseClickedEventHandler;
import battleship.model.Constants;
import battleship.model.Player;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanGridRectangle extends Rectangle {
    
    private int row;
    private int col;
    private OceanPane pane;
    private ImageView image;

    public OceanGridRectangle(int row, int col, OceanPane pane, Player player, GameRules gameState) {
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
        this.setOnMouseClicked(new OceanGridRectangleMouseClickedEventHandler(this, player, gameState));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void addExplosion() {
        if (image == null) {
            image = new ExplosionImageView();
            pane.add(image, col, row);
        }  
    }

    public void addPlop() {
        if (image == null) {
            image = new PlopImageView();
            pane.add(image, col, row);
        }  
    }
}
