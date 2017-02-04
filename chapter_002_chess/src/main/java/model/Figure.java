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

    public Figure(Cell position) {
        this.position = position;
    }

    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    public Cell[] createPath(int dx, int dy, int px, int py) {
        int n = Math.abs(px - dx) > Math.abs(py - dy) ? Math.abs(px - dx) : Math.abs(py - dy);
        Cell[] a = new Cell[n];
        int k = 0;

        int stepX = dx > px ? 1 : dx == px ? 0 : -1;
        int stepY = dy > py ? 1 : dy == py ? 0 : -1;

        int tmpX = px;
        int tmpY = py;

        while(tmpX != dx || tmpY != dy) {
            tmpX = tmpX + stepX;
            tmpY = tmpY + stepY;
            a[k++] = new Cell(tmpX, tmpY);
        }
        return a;
    }
}
