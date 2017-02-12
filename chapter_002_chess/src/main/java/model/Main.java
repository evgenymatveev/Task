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

//        Cell p = new Cell(1, 4);
//        Rook rook = new Rook(p);
//        Board board = new Board(rook);
//        Cell cell = new Cell(1, 0);

//        Cell p = new Cell(3, 1);
//        Queen queen = new Queen(p);
//        Board board = new Board(queen);
//        Cell cell = new Cell(0, 4);

//        Cell p = new Cell(7, 7);
//        King king = new King(p);
//        Board board = new Board(king);
//        Cell cell = new Cell(7, 6);

//        Cell p = new Cell(3, 6);
//        Pawn pawn = new Pawn(p, Color.BLACK);
//        Board board = new Board(pawn);
//        Cell cell = new Cell(3, 5);

        Cell p = new Cell(3, 2);
        Horse horse = new Horse(p);
        Board board = new Board(horse);
        Cell cell = new Cell(5, 3);


        try {
            board.move(p, cell);
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        }
    }
}
