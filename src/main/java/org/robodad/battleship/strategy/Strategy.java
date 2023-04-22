package org.robodad.battleship.strategy;

import org.robodad.battleship.model.Shot;

public interface Strategy {
    
    public enum Result {HIT, MISS, SUNK};

    public String getName();

    public Shot aim(Result lastResult);
}
