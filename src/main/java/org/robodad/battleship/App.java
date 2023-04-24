package org.robodad.battleship;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import org.robodad.battleship.controller.GameRules;
import org.robodad.battleship.model.Player;
import org.robodad.battleship.view.GameBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import plugins.Strategy;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private Player player1;
    private Player player2;

    private GameRules gameState;

    @Override
    public void start(Stage stage) throws IOException {

        try {
            Strategy strategy1 = loadStrategy(stage, "Player 1");
            Strategy strategy2 = loadStrategy(stage, "Player 2");

            player1 = new Player(strategy1);
            player2 = new Player(strategy2);

            player1.setOpponent(player2);
            player2.setOpponent(player1);

            gameState = new GameRules(player1, player2);

            scene = new Scene(new GameBoard(player1, player2, gameState));
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            stage.setTitle("Battleship");
            stage.setScene(scene);
            stage.show();
        }
        catch (ClassNotFoundException | NoSuchMethodException | 
                SecurityException | InstantiationException | IllegalAccessException | 
                InvocationTargetException | IOException e) {
            e.printStackTrace();
        }
    }

    private Strategy loadStrategy(Stage stage, String player) throws 
        ClassNotFoundException, NoSuchMethodException, 
        SecurityException, InstantiationException, IllegalAccessException, 
        InvocationTargetException, IOException {
        
        Strategy strategy = null;

        while (strategy == null) {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open AI for " + player);

            File file = fileChooser.showOpenDialog(stage);

            if (file == null) continue;

            URL loadPath = file.toURI().toURL();
            URL[] classUrl = new URL[]{loadPath};

            URLClassLoader cl = new URLClassLoader(classUrl);

            String className = file.getName().replaceFirst("[.][^.]+$", "");
            Class<?> loadedClass = cl.loadClass("plugins." + className);

            strategy = (Strategy)loadedClass.getDeclaredConstructor().newInstance();

            cl.close();
        }

        return strategy;
    }

    public static void main(String[] args) {
        launch();
    }
}
