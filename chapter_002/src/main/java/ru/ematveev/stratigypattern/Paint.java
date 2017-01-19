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
//    /**
//     * Number.
//     */
//    private int n;
    /**
     * Iprinter for output to console.
     */
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
     * @param n n.
     */
    public void draw(Shape shape) {
        iPrinter.println(shape.pic());
    }

    /**
     * Method start the program.
     * @param args args.
     */

    public static void main(String[] args) {
        IPrinter iPrinter = text -> System.out.println(text);
        Shape shape = new QuadreShape(7);
        Shape shape1 = new TriangleShape(7);
//        TriangleShape triangleShape = new TriangleShape(7);
//        QuadreShape quadreShape = new QuadreShape(7);
        Paint paint = new Paint(shape, iPrinter);

        paint.draw(shape);
        paint.draw(shape1);
    }
}
