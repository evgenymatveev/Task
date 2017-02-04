package model;

import exception.ImpossibleMoveException;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 03.02.17.
 */
public class Main {
    public static void main(String[] args)  throws ImpossibleMoveException {
        Figure elephant = new Elephant(new Cell(7, 5));
        Board board = new Board(elephant);
        Cell cell = new Cell(4, 2);

        try {
            elephant.way(cell);
        }
        catch (ImpossibleMoveException e) {
            e.printStackTrace();
        }

    }
}
