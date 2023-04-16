package org.robodad.battleship.controller;

import java.util.ArrayList;
import java.util.List;

import org.robodad.battleship.model.Shot;
import org.robodad.battleship.view.ShipImageView;

public class ShipRules {
    
    private ShipImageView view;
    private List<Shot> hits;

    public ShipRules(ShipImageView view) {
        this.view = view;
        this.hits = new ArrayList<>();
    }

    public String getName() {
        return view.getName();
    }

    public ShipImageView getView() {
        return view;
    }
    
    public boolean isHit(Shot shot) {
        if (view.isHit(shot)) {
            if (!hits.contains(shot)) {
                hits.add(shot);
            }
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
