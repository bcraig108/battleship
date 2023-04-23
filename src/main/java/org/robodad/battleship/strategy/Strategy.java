package org.robodad.battleship.strategy;

import org.robodad.battleship.model.Shot;

/**
 * This interface allows plugin Strategy classes to be created
 */
public interface Strategy {
    
    /**
     * The result of a shot - hit, miss, or sunk
     */
    public enum Result {
        HIT,    /** an opposing ship was hit, by not sunk */ 
        MISS,   /** no opposing ships were hit */
        SUNK};  /** an opposing ship was hit and was sunk */

    /**
     * @return the name of the strategy
     */
    public String getName();

    /**
     * Shoot at a location on the opponent's board
     * @param lastResult the result of the last shot
     * @return the location to shoot at
     */
    public Shot aim(Result lastResult);
}
