package model;

import exception.ImpossibleMoveException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class QueenTest {
    private Cell cell;
    private Queen queen;
    private Board board;
    /**
     *  The basic setup for tests.
     * @throws Exception Exception.
     */
    @Before
    public void setUp() throws Exception {
        cell = new Cell(4, 4);
        queen = new Queen(cell);
        board = new Board();
        board.addFigures(queen);
    }
    /**
     * Test the method way when coordinates are true diagonally.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenCoordinatesIsTrueDiagonal() throws Exception {
        Cell[] expectedValue = new Cell[]{new Cell(5, 3), new Cell(6, 2)};
        Cell[] actualValue = queen.way(new Cell(6, 2));

        assertThat(actualValue, is(expectedValue));
    }
    /**
     * Test the method way when coordinates are true vertically.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenCoordinatesIsTrueVertical() throws Exception {
        Cell[] expectedValue = new Cell[]{new Cell(4, 3), new Cell(4, 2)};
        Cell[] actualValue = queen.way(new Cell(4, 2));

        assertThat(actualValue, is(expectedValue));
    }
    /**
     * Test the method way when coordinates are more the board..
     * @throws Exception ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenCoordinatesIsMoreBoard() throws Exception {
        board.move(cell, new Cell(-1, 4));
    }

}