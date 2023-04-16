package org.robodad.battleship.strategy;

import org.robodad.battleship.model.Shot;

public interface Stategy {
    
    public String getName();

    public Shot aim();
}
