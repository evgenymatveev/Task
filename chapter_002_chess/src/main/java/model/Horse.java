package model;

import exception.ImpossibleMoveException;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 12.02.17.
 */
public class Horse extends Figure {
    Horse(Cell position) {
        super(position);
    }

    public Cell[] cells;

    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int dx = dist.getX();
        int dy = dist.getY();
        int px = position.getX();
        int py = position.getY();
        int k = 0;

        if(Math.abs(py - dy) == 2 && Math.abs(px - dx) == 1
                || Math.abs(py - dy) == 1 && Math.abs(px - dx) == 2) {
            cells = new Cell[] {new Cell(dx, dy)};


        } else {
            throw new ImpossibleMoveException("Так ходить нельзя");
        }
        for (Cell s : cells) {
            System.out.printf("%s %s" + " " + "\n", s.getX(), s.getY());
        }
        return cells;
    }
}
