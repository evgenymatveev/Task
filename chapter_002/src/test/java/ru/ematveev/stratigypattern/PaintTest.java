package ru.ematveev.stratigypattern;

import org.junit.Before;
import org.junit.Test;
import ru.ematveev.model.IPrinter;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Class PaintTest for testing method draw().
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 18.01.17.
 */
public class PaintTest {
    /**
     * Object IPrinter for testing.
     */
    private IPrinter iPrinter;

    /**
     * Method setUp() for create the mock IPrinter.
     * @throws Exception Exception.
     */
    @Before
    public void setUp() throws Exception {
        iPrinter = mock(IPrinter.class);
    }

    /**
     * Method to testing method draw when drawin the quadre.
     * @throws Exception Exception.
     */
    @Test
    public void testDrawWhenDrawinTheQuadre() throws Exception {
        Shape shape = new QuadreShape(2);
        Paint paint = new Paint(iPrinter);

        paint.draw(shape);

        String expectedValue = "x " + "x " + "\n" + "x " + "x " + "\n";

        verify(iPrinter).println(expectedValue);
    }
    /**
     * Method to testing method draw when drawin the triangle.
     * @throws Exception Exception.
     */
    @Test
    public void testDrawWhenDrawinTheTriangle() throws Exception {
        Shape shape1 = new TriangleShape(1);
        Paint paint = new Paint(iPrinter);

        paint.draw(shape1);

        String expectedValue = " /" + "\\" + "\n" + "/__\\";

        verify(iPrinter).println(expectedValue);
    }
}