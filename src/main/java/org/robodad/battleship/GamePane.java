package org.robodad.battleship;

import java.io.InputStream;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GamePane extends GridPane {

    private static final double SIZE = 50;

    public GamePane() {
        
        for (int row = 1; row <= 10; row++) {

            Label rowLabel = new Label();
            rowLabel.setText(String.valueOf((char)(row + 64)));
            rowLabel.setAlignment(Pos.CENTER);
            rowLabel.setMinWidth(SIZE);
            rowLabel.setMinHeight(SIZE);
            this.add(rowLabel,0,row);

            for (int col = 1; col <= 10; col++) {
            
                Label colLabel = new Label();
                colLabel.setText(Integer.toString(col));
                colLabel.setAlignment(Pos.CENTER);
                colLabel.setMinWidth(SIZE);
                colLabel.setMinHeight(SIZE);
                this.add(colLabel,col,0);

                Button btn = new Button();
                btn.setText("O");
                btn.setAlignment(Pos.CENTER);
                btn.setMinWidth(SIZE);
                btn.setMinHeight(SIZE);
                this.add(btn,col,row);
            }
        }
    }

    public void displayShips() {
    }
}
