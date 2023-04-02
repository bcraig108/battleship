package org.robodad.battleship.controller;

import java.util.ArrayList;
import java.util.List;

import org.robodad.battleship.model.Shot;
import org.robodad.battleship.view.ShipImageView;

public class ShipState {
    
    private ShipImageView view;
    private List<Shot> hits;

    public ShipState(ShipImageView view) {
        this.view = view;
        this.hits = new ArrayList<>();
    }

    public String getName() {
        return view.getName();
    }

    public boolean isHit(Shot shot) {
        if (hits.contains(shot)) {
            return true;
        }
        else if (view.isHit(shot)) {
            hits.add(shot);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isSunk() {
        return hits.size() == view.getCells();
    }
}
