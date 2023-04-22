package org.robodad.battleship.controller;

import java.util.ArrayList;
import java.util.List;

import org.robodad.battleship.model.Shot;
import org.robodad.battleship.strategy.Strategy.Result;
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
    
    public Result handleShot(Shot shot) {
        if (view.isHit(shot)) {
            if (!hits.contains(shot)) {
                hits.add(shot);
            }
            if (isSunk()) {
                return Result.SUNK;
            }
            else {
                return Result.HIT;
            }
        }
        else {
            return Result.MISS;
        }
    }

    public boolean isSunk() {
        return hits.size() == view.getCells();
    }
}
