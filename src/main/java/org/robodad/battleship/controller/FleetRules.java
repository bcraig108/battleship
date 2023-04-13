package org.robodad.battleship.controller;

import java.util.ArrayList;
import java.util.List;

import org.robodad.battleship.model.Shot;
import org.robodad.battleship.view.OceanPane;

public class FleetRules {
    
    private List<ShipRules> ships;
    private OceanPane pane;

    public FleetRules() {
        ships = new ArrayList<>();
    }

    public void add(ShipRules shipState) {
        ships.add(shipState);
        System.out.println("Fleet size " + ships.size());
    }

    public void setPane(OceanPane pane) {
        this.pane = pane;
    }

    public boolean isHit(Shot shot) {
        for (ShipRules shipState : ships) {
            if (shipState.isHit(shot)) {
                if (shipState.isSunk()) {
                    pane.getChildren().remove(shipState.getView());
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
