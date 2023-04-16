package org.robodad.battleship;

import java.io.IOException;

import org.robodad.battleship.controller.FleetRules;
import org.robodad.battleship.controller.GameRules;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.strategy.Random;
import org.robodad.battleship.strategy.RandomMemory;
import org.robodad.battleship.view.GameBoard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private FleetRules fleetState1;
    private FleetRules fleetState2;

    private Player player1;
    private Player player2;

    private GameRules gameState;

    @Override
    public void start(Stage stage) throws IOException {

        player1 = new Player(new Random());
        player2 = new Player(new RandomMemory());

        player1.setOpponent(player2);
        player2.setOpponent(player1);

        gameState = new GameRules(player1, player2);

        scene = new Scene(new GameBoard(player1, player2, gameState));
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("Battleship");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
