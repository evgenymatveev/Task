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
        Paint paint = new Paint();
        QuadreShape quadreShape = new QuadreShape();
        paint.setShape(quadreShape);
        paint.draw(iPrinter);

        String expectedValue = "\n" + " __________"
                                + "\n" + "|          |"
                                + "\n" + "|          |"
                                + "\n" + "|          |"
                                + "\n" + "|          |"
                                + "\n" + "|__________|";

        verify(iPrinter).println(expectedValue);
    }
    /**
     * Method to testing method draw when drawin the triangle.
     * @throws Exception Exception.
     */
    @Test
    public void testDrawWhenDrawinTheTriangle() throws Exception {
        Paint paint = new Paint();
        TriangleShape triangleShape = new TriangleShape();
        paint.setShape(triangleShape);
        paint.draw(iPrinter);

        String expectedValue = "     /\\"
                + "\n" + "    /  \\"
                + "\n" + "   /    \\"
                + "\n" + "  /      \\"
                + "\n" + " /        \\"
                + "\n" + "/__________\\";

        verify(iPrinter).println(expectedValue);
    }

}