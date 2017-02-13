package model;

import exception.ImpossibleMoveException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class KingTest {
    private Cell cell;
    private King king;
    private Board board;

    /**
     *  The basic setup for tests.
     * @throws Exception Exception.
     */
    @Before
    public void setUp() throws Exception {
        cell = new Cell(4, 4);
        king = new King(cell);
        board = new Board(king);
    }
    /**
     * Test the method way when coordinates are true diagonally.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenCoordinatesIsTrueDiagonal() throws Exception {
        Cell[] expectedValue = new Cell[]{new Cell(3, 5)};
        Cell[] actualValue = king.way(new Cell(3, 5));

        assertThat(actualValue, is(expectedValue));
    }
    /**
     * Test the method way when coordinates are true vertically.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenCoordinatesIsTrueVertical() throws Exception {
        Cell[] expectedValue = new Cell[]{new Cell(4, 5)};
        Cell[] actualValue = king.way(new Cell(4, 5));

        assertThat(actualValue, is(expectedValue));
    }
    /**
     * Test the method way when coordinates are false diagonally.
     * @throws Exception ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenCoordinatesIsfalseDiagonal() throws Exception {
        king.way(new Cell(7, 1));
    }
    /**
     * Test the method way when coordinates are false vertically.
     * @throws Exception ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenCoordinatesIsfalseVertical() throws Exception {
        king.way(new Cell(4, 1));
    }
    /**
     * Test the method way when coordinates are more the board..
     * @throws Exception ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenCoordinatesIsMoreOrLessBoard() throws Exception {
        board.move(cell, new Cell(8, 8));
    }

}