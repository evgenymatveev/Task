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
    private IPrinter iPrinter;

    /**
     * Setter for Shape.
     * @param shape shape.
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * Method that prints to the console figures.
     * @param iPrinter iPrinter.
     */
    public void draw(IPrinter iPrinter) {
        iPrinter.println(shape.pic());
    }

    /**
     * Method start the program.
     * @param args args.
     */

    public static void main(String[] args) {
        IPrinter iPrinter = new IPrinter() {
            @Override
            public void println(String text) {
                System.out.println(text);
            }
        };
        Paint paint = new Paint();

        QuadreShape quadreShape = new QuadreShape();
        paint.setShape(quadreShape);
        paint.draw(iPrinter);

        TriangleShape triangleShape = new TriangleShape();
        paint.setShape(triangleShape);
        paint.draw(iPrinter);


    }
}
