package org.robodad.battleship.controller;

import java.util.Optional;

import org.robodad.battleship.model.Player;
import org.robodad.battleship.model.Player.PlayerState;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class GameRules {

    private Player player1;
    private Player player2;
    private Player nextPlayer;
    private Alert alert;

    public GameRules(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.nextPlayer = player1;
    }

    public boolean isReady() {
        return player1.isReady() && player2.isReady(); 
    }

    public void start() {
        player1.setState(PlayerState.PLAYING);
        player2.setState(PlayerState.PLAYING);

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

    private void run() {
        while (nextPlayer.isPlaying()) {
            nextPlayer.nextTurn();
            setNextPlayer();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            if (nextPlayer.isWin()) {
                showWinDialog();
            }
        }
        System.out.println("Game Over!!!");
    }

    private void setNextPlayer() {
        if (nextPlayer == player1) {
            nextPlayer = player2;
        }
        else {
            nextPlayer = player1;
        }
    }

    private void showWinDialog() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText(null);
                alert.setContentText(nextPlayer.getName() + " Wins!");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    Platform.exit();
                }            
            }
        });
    }
}
