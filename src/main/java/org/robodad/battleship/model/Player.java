package org.robodad.battleship.model;

import org.robodad.battleship.controller.FleetState;
import org.robodad.battleship.controller.ShipState;
import org.robodad.battleship.view.ShipImageView;

public class Player {
    
    public enum PlayerState {SETUP, READY, PLAYING, WIN, LOSE};

    private String name;
    private PlayerState state;
    private FleetState fleet;

    public Player(String name) {
        this.name = name;
        this.state = PlayerState.SETUP;
        this.fleet = new FleetState();
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

    public boolean isReady() {
        return (this.state == PlayerState.READY);
    }

    public void addShip(ShipImageView view) {
        fleet.add(new ShipState(view));
    }

    public boolean isHit(Shot shot) {
        return fleet.isHit(shot);
    }
}
