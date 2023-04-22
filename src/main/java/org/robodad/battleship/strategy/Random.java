package org.robodad.battleship.strategy;

import org.robodad.battleship.model.Shot;

public class Random implements Strategy {

    @Override
    public String getName() {
        return new String("RoboDad Random");
    }

    @Override
    public Shot aim(Result lastResult) {
        int row = (int)(Math.random() * 10) + 1;
        int col = (int)(Math.random() * 10) + 1;

        return new Shot(row, col);
    }
    
}
