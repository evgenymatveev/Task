package model;

import exception.ImpossibleMoveException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class HorseTest {
    private Cell cell;
    private Horse horse;
    private Board board;

    /**
     *  The basic setup for tests.
     * @throws Exception Exception.
     */
    @Before
    public void setUp() throws Exception {
        cell = new Cell(3, 2);
        horse = new Horse(cell);
        board = new Board(horse);
    }
    /**
     * Test the method way when coordinates are true.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenCoordinatesIsTrue() throws Exception {
        Cell[] expectedValue = new Cell[]{new Cell(4, 4)};
        Cell[] actualValue = horse.way(new Cell(4, 4));

        assertThat(actualValue, is(expectedValue));
    }
    /**
     * Test the method way when coordinates are false..
     * @throws Exception Exception.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenCoordinatesIsfalse() throws Exception {
        horse.way(new Cell(3, 5));
    }
    /**
     * Test the method way when coordinates are more the board..
     * @throws Exception ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenCoordinatesIsMoreOrLessBoard() throws Exception {
        board.move(cell, new Cell(3, -1));
    }

}