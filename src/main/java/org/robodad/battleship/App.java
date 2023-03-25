package org.robodad.battleship;

import java.io.IOException;

import org.robodad.battleship.model.Player;
import org.robodad.battleship.view.GameBoard;
import org.robodad.battleship.view.PlayerBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Player player1;
    private Player player2;

    @Override
    public void start(Stage stage) throws IOException {

        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        
        scene = new Scene(new GameBoard(player1, player2));
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("Battleship");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
