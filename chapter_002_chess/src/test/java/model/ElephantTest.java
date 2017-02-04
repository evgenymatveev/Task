//package model;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;
//
///**
// * Class
// *
// * @author Matveev Evgeny.
// * @version 1.0.
// * @since 03.02.17.
// */
//public class ElephantTest {
//    @Test
//    public void testWay() throws Exception {
//        Elephant elephant = new Elephant(new Cell(7, 5));
//        Cell cell = new Cell(4, 2);
//        Cell[] expectedValue = new Cell[] {new Cell(6, 4), new Cell(5, 3), new Cell(4, 2)};
//        Cell[] actualValue = elephant.way(cell);
//
//        assertThat((actualValue), is(expectedValue));
//
//    }
//
//}