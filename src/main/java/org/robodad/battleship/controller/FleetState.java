package org.robodad.battleship.controller;

import java.util.ArrayList;
import java.util.List;

import org.robodad.battleship.model.Shot;

public class FleetState {
    
    private List<ShipState> ships;

    public FleetState() {
        ships = new ArrayList<>();
    }

    public void add(ShipState shipState) {
        ships.add(shipState);
        System.out.println("Fleet size " + ships.size());
    }

    public boolean isHit(Shot shot) {
        for (ShipState shipState : ships) {
            if (shipState.isHit(shot)) {
                if (shipState.isSunk()) {
                    System.out.println(shipState.getName() + " sunk!");
                    ships.remove(shipState);
                }
                System.out.println(ships.size() + " ships left");
                return true;
            }
        }
        return false;
    }

    public boolean isLost() {
        return ships.isEmpty();
    }
}
