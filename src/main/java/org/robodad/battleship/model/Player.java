package org.robodad.battleship.model;

import org.robodad.battleship.controller.FleetRules;
import org.robodad.battleship.controller.ShipRules;
import org.robodad.battleship.view.OceanPane;
import org.robodad.battleship.view.ShipImageView;

import javafx.application.Platform;

public class Player {
    
    public enum PlayerState {SETUP, READY, PLAYING, WIN, LOSE};

    private String name;
    private PlayerState state;
    private FleetRules fleet;
    private Player opponent;
    private OceanPane pane;

    public Player(String name) {
        this.name = name;
        this.state = PlayerState.SETUP;
        this.fleet = new FleetRules();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public void setPane(OceanPane pane) {
        this.pane = pane;
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

    public boolean isHit(Shot shot) {
        return fleet.isHit(shot);
    }

    public void nextTurn() {
        int row = (int)(Math.random() * 10) + 1;
        int col = (int)(Math.random() * 10) + 1;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                opponent.handleShot(new Shot(row, col));
            }
        });
    }

    public void handleShot(Shot shot) {
        if (isHit(shot)) {
            System.out.println(name + ": HIT R" + shot.getRow() + " C" + shot.getCol());
            pane.addExplosion(shot);
        }
        else {
            System.out.println(name + ": MISS R" + shot.getRow() + " C" + shot.getCol());
            pane.addPlop(shot);
        }
    }
}
