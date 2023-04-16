package org.robodad.battleship.strategy;

import java.util.LinkedList;
import java.util.List;

import org.robodad.battleship.Constants;
import org.robodad.battleship.model.Shot;

public class RandomMemory implements Stategy {

    List<Shot> available;

    public RandomMemory() {
        // create a list of available shots to take
        this.available = new LinkedList<Shot>();
        for (int row = 1; row <= Constants.NUM_ROWS; row++) {
            for (int col = 1; col <= Constants.NUM_COLS; col++) {
                available.add(new Shot(row, col));
            }
        }
    }

    @Override
    public String getName() {
        return new String("RandomMemory");
    }

    @Override
    public Shot aim() {
        // select a shot to take from the available list
        int index = (int)(Math.random() * available.size());
        Shot shot = available.get(index);

        // remove the shot from the list
        available.remove(index);
        return shot;
    }
    
}
