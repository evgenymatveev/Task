package model;

import exception.FigureNotFoundException;
import exception.ImpossibleMoveException;
import exception.OccupiedWayException;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 02.02.17.
 */
public class Board {
    private Figure[] figures = new Figure[64];

    private int position = 0;

    public Board(Figure figure) {
        figures[position++] = figure;

    }
        public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
    }

    public Figure[] getFigures() {
        return figures;
    }

    public int getPosition() {
        return position;
    }

}



