package model;

import exception.ImpossibleMoveException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class ElephantTest {
    private Cell cell;
    private Elephant elephant;
    private Board board;

    /**
     *  The basic setup for tests.
     * @throws Exception Exception.
     */
    @Before
    public void setUp() throws Exception {
        cell = new Cell(4, 4);
        elephant = new Elephant(cell);
        board = new Board(elephant);
    }

    /**
     * Test the method way when coordinates are true.
     * @throws Exception Exception.
     */
    @Test
    public void testWayWhenCoordinatesIsTrue() throws Exception {
        Cell[] expectedValue = new Cell[]{new Cell(5, 3), new Cell(6, 2)};
        Cell[] actualValue = elephant.way(new Cell(6, 2));

        assertThat(actualValue, is(expectedValue));
    }

    /**
     * Test the method way when coordinates are false..
     * @throws Exception Exception.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenCoordinatesIsfalse() throws Exception {
        elephant.way(new Cell(7, 4));
    }
    /**
     * Test the method way when coordinates are more the board..
     * @throws Exception ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testWayWhenCoordinatesIsMoreBoard() throws Exception {
        board.move(cell, new Cell(8, 0));
    }

}