package model;

import exception.FigureNotFoundException;
import exception.ImpossibleMoveException;
import exception.OccupiedWayException;

/**
 * @author Matveev Evgeny.
 */
public class Board {
    private Figure[] figures = new Figure[64];
    private int max = 7;
    private int min = 0;
    private int position = 0;

    /**
     * Board games.
     * @param figure chess figures.
     */
    public Board(Figure figure) {
        figures[position++] = figure;
    }

    /**
     * Method check the correct coordinates.
     * @param source position where is fugure.
     * @param dist position where you need to put figure.
     * @return boolean.
     * @throws ImpossibleMoveException throws an exception ImpossibleMoveException if the coordinate is not correct.
     * @throws OccupiedWayException OccupiedWayException.
     * @throws FigureNotFoundException throws an exception FigureNotFoundException if if the cell has no figure.
     */
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



