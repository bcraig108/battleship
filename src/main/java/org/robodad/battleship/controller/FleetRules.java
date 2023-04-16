package org.robodad.battleship.controller;

import java.util.ArrayList;
import java.util.List;

import org.robodad.battleship.model.Shot;
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

    public boolean isHit(Shot shot) {
        for (ShipRules shipRules : ships) {
            if (shipRules.isHit(shot)) {
                if (shipRules.isSunk()) {
                    board.removeShip(shipRules);
                    ships.remove(shipRules);
                    board.updateMessage(shot + ": " + shipRules.getName() + " sunk!");
                    board.updateNumShips(ships.size());
                }
                else {
                    board.updateMessage(shot + ": " + shipRules.getName() + " hit!");
                }
                return true;
            }
        }
        board.updateMessage(shot + ": Miss!");
        return false;
    }

    public boolean isLost() {
        // TODO throws exception
        // if (ships.isEmpty()) {
        //     board.updateMessage("Fleet Sunk!");
        // }
        return ships.isEmpty();        
    }
}
