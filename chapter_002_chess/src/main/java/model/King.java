package model;

import exception.ImpossibleMoveException;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 12.02.17.
 */
public class King extends Figure {
    King(Cell position) {
        super(position);
    }

    public Cell[] cells;

    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int dx = dist.getX();
        int dy = dist.getY();
        int px = position.getX();
        int py = position.getY();
        if(Math.abs(px - dx) == 1 && Math.abs(py - dy) == 1 || (Math.abs(px - dx) == 0 && Math.abs(py - dy) == 1)
                || (Math.abs(py - dy) == 0 && Math.abs(px - dx) == 1)) {
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

