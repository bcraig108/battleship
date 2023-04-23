package org.robodad.battleship.controller;

import java.util.ArrayList;
import java.util.List;

import org.robodad.battleship.model.Shot;
import org.robodad.battleship.strategy.Strategy.Result;
import org.robodad.battleship.view.ShipImageView;

/**
 * This class contains the rules for each ship in the fleet
 */
public class ShipRules {
    
    /** The ship icon and location */
    private ShipImageView view;

    /** This list of hits the ship has taken */
    private List<Shot> hits;

    /**
     * The constructor, creates an empty list of hits taken
     * @param view - the ship icon and location
     */
    public ShipRules(ShipImageView view) {
        this.view = view;
        this.hits = new ArrayList<>();
    }

    /**
     * @return the name of the ship
     */
    public String getName() {
        return view.getName();
    }

    /**
     * @return the ship icon and location
     */
    public ShipImageView getView() {
        return view;
    }
    
    /**
     * Handle an opponent's shot
     * @param shot the oppenent's shot
     * @return whether the ship was hit, sunk or missed
     */
    public Result handleShot(Shot shot) {
        // if the ship was hit
        if (view.isHit(shot)) {
            // if the list of shots does not contain this cell
            if (!hits.contains(shot)) {
                // add this cell to the list of hits
                hits.add(shot);
            }
            // check to see if the ship was sunk or just hit
            if (isSunk()) {
                return Result.SUNK;
            }
            else {
                return Result.HIT;
            }
        }
        else {  // the ship was missed
            return Result.MISS;
        }
    }

    /**
     * @return whether the ship was sunk or not, depending on the number of
     * cells and the number of unique hits
     */
    public boolean isSunk() {
        return hits.size() == view.getCells();
    }
}
