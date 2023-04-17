package org.robodad.battleship.model;

import org.robodad.battleship.controller.FleetRules;
import org.robodad.battleship.controller.ShipRules;
import org.robodad.battleship.strategy.Stategy;
import org.robodad.battleship.strategy.Stategy.Result;
import org.robodad.battleship.view.OceanPane;
import org.robodad.battleship.view.PlayerBoard;
import org.robodad.battleship.view.ShipImageView;

import javafx.application.Platform;

public class Player {
    
    public enum PlayerState {SETUP, READY, PLAYING, WIN, LOSE};

    private Stategy strategy;
    private PlayerState state;
    private FleetRules fleet;
    private Player opponent;
    private PlayerBoard board;
    private Result result = Result.MISS;

    public Player(Stategy strategy) {
        this.strategy = strategy;
        this.state = PlayerState.SETUP;
        this.fleet = new FleetRules();
    }

    public String getName() {
        return this.strategy.getName();
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public void setPlayerBoard(PlayerBoard board) {
        this.board = board;
        this.fleet.setPlayerBoard(board);
    }

    public boolean isReady() {
        return (this.state == PlayerState.READY);
    }

    public boolean isPlaying() {
        return (this.state == PlayerState.PLAYING);
    }

    public boolean isLose() {
        if (fleet.isLost()) {
            this.state = PlayerState.LOSE;
        }
        return this.state == PlayerState.LOSE;
    }

    public boolean isWin() {
        if (opponent.isLose()) {
            this.state = PlayerState.WIN;
        }
        return this.state == PlayerState.WIN;
    }

    public void addShip(ShipImageView view) {
        fleet.add(new ShipRules(view));
    }

    public void nextTurn() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Shot shot = strategy.aim(result);
                result = opponent.handleShot(shot);
            }
        });
    }

    public Result handleShot(Shot shot) {
        Result result = fleet.handleShot(shot);
        switch (result) {
        case HIT:
        case SUNK:
            board.addExplosion(shot);
            break;
        case MISS:
            board.addPlop(shot);
            break;
        }
        return result;
    }
}
