package org.robodad.battleship;

import java.io.IOException;

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

    @Override
    public void start(Stage stage) throws IOException {
        
        scene = new Scene(new GameBoard());
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("Battleship");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
