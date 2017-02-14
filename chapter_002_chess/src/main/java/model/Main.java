package model;

import exception.FigureNotFoundException;
import exception.ImpossibleMoveException;
import exception.OccupiedWayException;

/**
 * @author Matveev Evgeny.
 */
public class Main {
    /**
     * Method to run the program.
     * @param args args.
     * @throws ImpossibleMoveException ImpossibleMoveException.
     * @throws OccupiedWayException OccupiedWayException.
     * @throws FigureNotFoundException FigureNotFoundException.
     */
    public static void main(String[] args) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
//        Cell p = new Cell(4, 4);
//        Elephant elephant = new Elephant(p);
//        Board board = new Board();
//        board.addFigures(elephant);
//        Cell cell = new Cell(5, 3);
//
//        Cell p = new Cell(1, 4);
//        Rook rook = new Rook(p);
//        Board board = new Board();
//        board.addFigures(rook);
//        Cell cell = new Cell(1, 0);
//
//        Cell p = new Cell(3, 1);
//        Queen queen = new Queen(p);
//        Board board = new Board();
//        board.addFigures(queen);
//        Cell cell = new Cell(0, 4);
//
//        Cell p = new Cell(7, 7);
//        King king = new King(p);
//        Board board = new Board();
//        board.addFigures(king);
//        Cell cell = new Cell(7, 6);

        Cell p = new Cell(3, 6);
        Pawn pawn = new Pawn(p, Color.BLACK);
        Board board = new Board();
        board.addFigures(pawn);
        Cell cell = new Cell(3, 5);

//        Cell p = new Cell(3, 2);
//        Horse horse = new Horse(p);
//        Board board = new Board();
//        board.addFigures(horse);
//        Cell cell = new Cell(5, 3);


        try {
            board.move(p, cell);
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        }
    }
}
