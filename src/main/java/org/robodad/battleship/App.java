package org.robodad.battleship;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Battleship");
        
        scene = new Scene(new GamePane());
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        //Creating the patrol boat image view
        // ImageView imageView = new PatrolImageView();
        // ImageView imageView = new SubmarineImageView();
        // ImageView imageView = new DestroyerImageView();
        // ImageView imageView = new BattleshipImageView();
        // ImageView imageView = new CarrierImageView();
        
        // //Setting the Scene object
        // Group root = new Group(imageView);
        // Scene scene = new Scene(root, 620, 600);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
