package model;

import exception.ImpossibleMoveException;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 12.02.17.
 */
public class Pawn extends Figure {

    public Pawn(Cell position, Color color) {
        super(position);
        this.color = color;
    }

    private Color color;

    public Pawn(Cell position) {
        super(position);
    }
    public Cell[] cells;

    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int dx = dist.getX();
        int dy = dist.getY();
        int px = position.getX();
        int py = position.getY();
        if(color == Color.WHITE && dy > py) {
                if (py == 1 && dx == px && dy <= 3) {
                    cells = createPath(dx, dy, px, py);
                } else if (px == dx && dy - py == 1) {
                    cells = createPath(dx, dy, px, py);
                } else {
                    throw new ImpossibleMoveException("Так ходить нельзя");
                }
                for (Cell s : cells) {
                    System.out.printf("%s %s" + " " + "\n", s.getX(), s.getY());
                }
        }
        else if(color == Color.BLACK && dy < py) {
                if (py == 6 && dx == px && dy >= 4) {
                    cells = createPath(dx, dy, px, py);
                } else if (px == dx && py - dy == 1) {
                    cells = createPath(dx, dy, px, py);
                } else {
                    throw new ImpossibleMoveException("Так ходить нельзя");
                }
                for (Cell s : cells) {
                    System.out.printf("%s %s" + " " + "\n", s.getX(), s.getY());
                }
        }
        else {
            throw new ImpossibleMoveException("Так ходить нельзя");
        }
        return cells;
    }
}


