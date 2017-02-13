package model;

import exception.ImpossibleMoveException;

/**
 * @author Matveev Evgeny.
 */
public abstract class Figure {
    public Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Do the way for the figures.
     * @param dist coordinates where to move.
     * @return an array of coordinates where to move.
     * @throws ImpossibleMoveException will throw Exception if the move can be done.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Creates an array of ways to move for figure.
     * @param dx coordinate x where do you need to make a move.
     * @param dy coordinate y where do you need to make a move.
     * @param px coordinate x is base.
     * @param py coordinate y is base.
     * @return array.
     */
    public Cell[] createPath(int dx, int dy, int px, int py) {
        int n = Math.abs(px - dx) > Math.abs(py - dy) ? Math.abs(px - dx) : Math.abs(py - dy);
        Cell[] a = new Cell[n];
        int k = 0;

        int stepX = dx > px ? 1 : dx == px ? 0 : -1;
        int stepY = dy > py ? 1 : dy == py ? 0 : -1;

        int tmpX = px;
        int tmpY = py;

        while (k < a.length) {
            tmpX = tmpX + stepX;
            tmpY = tmpY + stepY;
            a[k++] = new Cell(tmpX, tmpY);
        }
        return a;
    }
    public Cell getPosition() {
        return position;
    }
}
