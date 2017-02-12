package model;

import exception.ImpossibleMoveException;

public class Rook extends Figure {

    Rook(Cell position) {
        super(position);
    }

    public Cell[] cells;

    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int dx = dist.getX();
        int dy = dist.getY();
        int px = position.getX();
        int py = position.getY();
        if((Math.abs(px - dx) == 0 && Math.abs(py - dy) != 0)
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