package ru.ematveev.stratigypattern;

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
     * Setter for Shape.
     * @param shape shape.
     */
    private void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * Method that prints to the console figures.
     */
    public void draw() {
        System.out.println(shape.pic());
    }

    /**
     * Method start the program.
     * @param args args.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();

        QuadreShape quadreShape = new QuadreShape();
        paint.setShape(quadreShape);
        paint.draw();

        TriangleShape triangleShape = new TriangleShape();
        paint.setShape(triangleShape);
        paint.draw();
    }
}
