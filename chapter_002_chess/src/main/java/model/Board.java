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

    private int max = 7;

    protected int min = 0;

    private int position = 0;

    public Board(Figure figure) {
        figures[position++] = figure;
    }

    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        if (!(dist.getX() > max || dist.getX() < min || dist.getY() > max || dist.getY() < min)) {

            for (Figure f : figures) {
                if (source.equals(f.position)) {
                    f.way(dist);
                    return true;
                } else {
                    throw new FigureNotFoundException("В ячейке нет фигуры!");
                }
            }
        } else {
            throw new ImpossibleMoveException("Не верная координата, Вы вышли за пределы доски!");
        }
        return false;
    }
}



