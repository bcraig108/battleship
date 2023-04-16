package org.robodad.battleship.model;

import java.util.Objects;

public class Shot {
    
    private int row;
    private int col;

    public Shot(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String toString() {
        return String.valueOf((char)(row + 64)) + Integer.toString(col);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Shot)) {
            return false;
        }
        Shot shot = (Shot) o;
        return row == shot.row && col == shot.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
