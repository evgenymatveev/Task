package model;

import exception.ImpossibleMoveException;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 12.02.17.
 */
public class Queen extends Figure {
    Queen(Cell position) {
        super(position);
    }

    public Cell[] cells;

    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int dx = dist.getX();
        int dy = dist.getY();
        int px = position.getX();
        int py = position.getY();
        if(Math.abs(px - dx) == Math.abs(py - dy) || (Math.abs(px - dx) == 0 && Math.abs(py - dy) != 0)
                || (Math.abs(py - dy) == 0 && Math.abs(px - dx) != 0)) {
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
