package battleship.model;

import battleship.controller.FleetRules;
import battleship.controller.ShipRules;
import battleship.model.Constants.ShipType;
import battleship.model.Constants.ShotResult;
import battleship.plugins.Strategy;
import battleship.view.PlayerBoard;
import battleship.view.ShipImageView;
import javafx.application.Platform;

public class Player {
    
    public enum PlayerState {SETUP, READY, PLAYING, WIN, LOSE};

    private Strategy strategy;
    private PlayerState state;
    private FleetRules fleet;
    private Player opponent;
    private PlayerBoard board;
    private Result result;

    public Player(Strategy strategy) {
        this.strategy = strategy;
        this.state = PlayerState.SETUP;
        this.fleet = new FleetRules();
        this.result = new Result(ShotResult.MISS, ShipType.NONE);
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
        switch (result.getResult()) {
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
