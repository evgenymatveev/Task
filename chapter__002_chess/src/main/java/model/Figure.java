package model;

import exception.ImpossibleMoveException;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 02.02.17.
 */
public abstract class Figure {
    final Cell position;

    protected Figure(Cell position) {
        this.position = position;
    }

    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;
}
