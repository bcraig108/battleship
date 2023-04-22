package org.robodad.battleship.controller;

import java.util.ArrayList;
import java.util.List;

import org.robodad.battleship.model.Shot;
import org.robodad.battleship.strategy.Strategy.Result;
import org.robodad.battleship.view.PlayerBoard;

public class FleetRules {
    
    private List<ShipRules> ships;
    private PlayerBoard board;

    public FleetRules() {
        ships = new ArrayList<>();
    }

    public void add(ShipRules shipRules) {
        ships.add(shipRules);
    }

    public void setPlayerBoard(PlayerBoard board) {
        this.board = board;
    }

    public Result handleShot(Shot shot) {
        for (ShipRules shipRules : ships) {
            Result result = shipRules.handleShot(shot);
            switch (result) {
            case SUNK:
                board.removeShip(shipRules);
                ships.remove(shipRules);
                board.updateMessage(shot + ": " + shipRules.getName() + " sunk!");
                board.updateNumShips(ships.size());
                return result;
            case HIT:
                board.updateMessage(shot + ": " + shipRules.getName() + " hit!");
                return result;
            case MISS:
            default:
                board.updateMessage(shot + ": Miss!");
            }
        }
        return Result.MISS;
    }

    public boolean isLost() {
        return ships.isEmpty();        
    }
}
