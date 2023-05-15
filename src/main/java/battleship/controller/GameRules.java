package battleship.controller;

import java.util.Optional;

import battleship.model.Player;
import battleship.model.Player.PlayerState;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * This class contains the rules for the game, keeping track of each player's
 * turn, and who wins and loses
 */
public class GameRules {

    /** Player 1 */
    private Player player1;

    /** Player 2 */
    private Player player2;

    /** The next player */
    private Player nextPlayer;

    /** The alert box, indicating who wins */
    private Alert alert;

    private int turnCount;

    /**
     * The constructor
     * @param player1 - Player 1
     * @param player2 - Player 2
     */
    public GameRules(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.nextPlayer = player1;
        this.turnCount = 1;
    }

    /**
     * @return true if both players are ready to play
     */
    public boolean isReady() {
        return player1.isReady() && player2.isReady(); 
    }

    /**
     * Starts the game
     */
    public void start() {
        // set both players' states to PLAYING
        player1.setState(PlayerState.PLAYING);
        player2.setState(PlayerState.PLAYING);

        // create a thread to run the game
        GameRules game = this;

        Thread thread = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    game.run();
                }
             }
        );
        thread.start();
    }

    /**
     * Run the game while both players are still playing
     */
    private void run() {
        // while the next player is still playing
        while (nextPlayer.isPlaying()) {

            // let the next player take its turn
            nextPlayer.nextTurn();

            // select the next player
            setNextPlayer();

            // wait for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            // if the next player wins, show the win alert
            if (nextPlayer.isWin()) {
                showWinDialog();
            }
        }
    }

    /**
     * Set the next player, swap from player 1 to player 2 and vice versa
     */
    private void setNextPlayer() {
        if (nextPlayer == player1) {
            nextPlayer = player2;
        }
        else {
            nextPlayer = player1;
            turnCount++;
        }
    }

    /**
     * Popup the "Game Over" dialog, indicating who wins
     */
    private void showWinDialog() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText(null);
                alert.setContentText(nextPlayer.getName() + " wins in " + turnCount + " turns!");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    Platform.exit();
                }            
            }
        });
    }
}
