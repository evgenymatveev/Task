package model;

import exception.FigureNotFoundException;
import exception.ImpossibleMoveException;
import exception.OccupiedWayException;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 03.02.17.
 */
public class Main {
    public static void main(String[] args) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
//        Cell p = new Cell(4, 4);
//        Elephant elephant = new Elephant(p);
//        Board board = new Board(elephant);
//        Cell cell = new Cell(7, 1);

        Cell p = new Cell(4, 4);
        Rook rook = new Rook(p);
        Board board = new Board(rook);
        Cell cell = new Cell(4, 0);

        try {
            board.move(p, cell);
        }
        catch (OccupiedWayException e) {
            e.printStackTrace();
        }
    }
}
