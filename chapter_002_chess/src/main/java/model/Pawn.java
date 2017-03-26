package model;

import exception.ImpossibleMoveException;

/**
 * @author Matveev Evgeny.
 */
public class Pawn extends Figure {
    /**
     * Constructor for write the figure.
     * @param position coordinate of figure.
     * @param color color of figure.
     */
    public Pawn(Cell position, Color color) {
        super(position);
        this.color = color;
    }

    private Color color;

    public Pawn(Cell position) {
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
//        int px = position.getX();
//        int py = position.getY();
        int px = getPosition().getX();
        int py = getPosition().getY();
        if (color == Color.WHITE && dy > py) {
            if ((py == 1 && dx == px && dy <= 3) || (px == dx && dy - py == 1)) {
                cells = createPath(dx, dy, px, py);
            } else {
                throw new ImpossibleMoveException("Так ходить нельзя");
            }
        } else if (color == Color.BLACK && dy < py) {
            if ((py == 6 && dx == px && dy >= 4) || (px == dx && py - dy == 1)) {
                cells = createPath(dx, dy, px, py);
            } else {
                throw new ImpossibleMoveException("Так ходить нельзя");
            }
        } else {
            throw new ImpossibleMoveException("Так ходить нельзя");
        }
        for (Cell s : cells) {
            System.out.printf("%s %s" + " " + "\n", s.getX(), s.getY());
        }
        return cells;
    }
}


