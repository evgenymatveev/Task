package model;

import java.util.Objects;

/**
 * Creates the coordinates of the positions of the figures on the Board.
 * @author Matveev Evgeny.
 */
public class Cell {
    private final int x;
    private final int y;

    /**
     * Constructor for coordinates.
     * @param x set x.
     * @param y set y.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for x.
     * @return x.
     */
    public int getX() {
        return x;
    }
    /**
     * Getter for y.
     * @return y.
     */
    public int getY() {
        return y;
    }

    /**
     * Override the method equals to properly compare objects.
     * @param o Input the object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    /**
     * Override the method.
     * @return hash code object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

