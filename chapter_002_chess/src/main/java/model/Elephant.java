package model;

import exception.ImpossibleMoveException;

/**
 * @author Matveev Evgeny.
 */
public class Elephant extends Figure {
    Elephant(Cell position) {
        super(position);
    }

    private Cell[] cells;

    /**
     * Do the way for the figures.
     * @param dist coordinates where to move.
     * @return an array of coordinates where to move.
     * @throws ImpossibleMoveException will throw Exception if the move can be done.
     */
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int dx = dist.getX();
        int dy = dist.getY();
        int px = position.getX();
        int py = position.getY();
        if (Math.abs(px - dx) == Math.abs(py - dy)) {
            cells = createPath(dx, dy, px, py);
        } else {
            throw new ImpossibleMoveException("Так ходить нельзя");
        }
        for (Cell s : cells) {
            System.out.printf("%s %s" + " " + "\n", s.getX(), s.getY());
        }
        return cells;
    }
}

