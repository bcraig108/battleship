package org.robodad.battleship.model;

public class Player {
    
    public enum PlayerState {SETUP, READY, PLAYINING, WIN, LOSE};

    private String name;
    private PlayerState state;

    public Player(String name) {
        this.name = name;
        this.state = PlayerState.SETUP;
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
}
