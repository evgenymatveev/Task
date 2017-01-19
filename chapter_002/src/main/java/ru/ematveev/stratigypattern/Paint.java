package ru.ematveev.stratigypattern;

import ru.ematveev.model.IPrinter;

/**
 * Class Paint this StratigyClient.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 18.01.17.
 */
public class Paint {
    /**
     * Interface Shape connection.
     */

    private Shape shape;
    /**
     * Iprinter for output to console.
     */
    private int n;
    private IPrinter iPrinter;

    /**
     * Constructor.
     * @param shape shape.
     * @param iPrinter iPrinter.
     */

    public Paint(Shape shape, IPrinter iPrinter) {
        this.shape = shape;
        this.iPrinter = iPrinter;
    }

    /**
     * Method output to console the figures.
     * @param shape shape.
     */
    public void draw(Shape shape, int n) {
        iPrinter.println(shape.pic(n));
    }

    /**
     * Method start the program.
     * @param args args.
     */

    public static void main(String[] args) {
        IPrinter iPrinter = text -> System.out.println(text);
        Shape shape = new QuadreShape();
        TriangleShape triangleShape = new TriangleShape();
        QuadreShape quadreShape = new QuadreShape();
        Paint paint = new Paint(shape, iPrinter);

        paint.draw(quadreShape, 7);
        paint.draw(triangleShape, 6);
    }
}
