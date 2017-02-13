package model;

import exception.ImpossibleMoveException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class PawnTest {
    private Cell cell;
    private Pawn pawn;
    private Board board;

    /**
     * Test the method way when coordinates are base and true and color is white.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenColorWhitePositionBasicCoordinateIsTrue() throws Exception {
        cell = new Cell(3, 1);
        pawn = new Pawn(cell, Color.WHITE);
        board = new Board(pawn);
        Cell[] expectedValue = new Cell[]{new Cell(3, 2), new Cell(3, 3)};
        Cell[] actualValue = pawn.way(new Cell(3, 3));

        assertThat(actualValue, is(expectedValue));
    }
    /**
     * Test the method way when coordinates are base and true and color is black.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenColorBlackPositionBasicCoordinateIsTrue() throws Exception {
        cell = new Cell(6, 6);
        pawn = new Pawn(cell, Color.BLACK);
        board = new Board(pawn);
        Cell[] expectedValue = new Cell[]{new Cell(6, 5), new Cell(6, 4)};
        Cell[] actualValue = pawn.way(new Cell(6, 4));

        assertThat(actualValue, is(expectedValue));
    }
    /**
     * Test the method way when coordinates are not base and true and color is white.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenColorWhitePositionNoBasicCoordinateIsTrue() throws Exception {
        cell = new Cell(5, 4);
        pawn = new Pawn(cell, Color.WHITE);
        board = new Board(pawn);
        Cell[] expectedValue = new Cell[]{new Cell(5, 5)};
        Cell[] actualValue = pawn.way(new Cell(5, 5));

        assertThat(actualValue, is(expectedValue));
    }
    /**
     * Test the method way when coordinates are not base and true and color is black.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenColorBlackPositionNoBasicCoordinateIsTrue() throws Exception {
        cell = new Cell(1, 4);
        pawn = new Pawn(cell, Color.BLACK);
        board = new Board(pawn);
        Cell[] expectedValue = new Cell[]{new Cell(1, 3)};
        Cell[] actualValue = pawn.way(new Cell(1, 3));

        assertThat(actualValue, is(expectedValue));
    }
    /**
     * Test the method way when coordinates are not base and false and color is white.
     * @throws Exception Exception.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenColorWhitePositionNoBasicCoordinateIsFalse() throws Exception {
        cell = new Cell(4, 2);
        pawn = new Pawn(cell, Color.WHITE);
        board = new Board(pawn);
        pawn.way(new Cell(5, 3));
    }
    /**
     * Test the method way when coordinates are not base and false and color is black.
     * @throws Exception Exception.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenColorBlackPositionNoBasicCoordinateIsFalse() throws Exception {
        cell = new Cell(0, 4);
        pawn = new Pawn(cell, Color.BLACK);
        board = new Board(pawn);
        pawn.way(new Cell(0, 1));
    }
    /**
     * Test the method way when coordinates are more the board and color is white.
     * @throws Exception ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenColorWhiteMoreBoard() throws Exception {
        cell = new Cell(5, 4);
        pawn = new Pawn(cell, Color.WHITE);
        board = new Board(pawn);
        pawn.way(new Cell(5, 8));
    }
    /**
     * Test the method way when coordinates are more the board and color is black.
     * @throws Exception ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenColorBlackMoreBoard() throws Exception {
        cell = new Cell(5, 6);
        pawn = new Pawn(cell, Color.BLACK);
        board = new Board(pawn);
        pawn.way(new Cell(5, -1));
    }

}