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
        board.updateNumShips(ships.size());
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
                }
                board.updateNumShips(ships.size());
                return true;
            }
        }
        return false;
    }

    public boolean isLost() {
        return ships.isEmpty();
    }
}
