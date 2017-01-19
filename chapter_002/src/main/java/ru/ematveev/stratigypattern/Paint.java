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
     * Iprinter for output to console.
     */
    private IPrinter iPrinter;

    /**
     * Constructor.
     * @param iPrinter iPrinter.
     */

    public Paint(IPrinter iPrinter) {
        this.iPrinter = iPrinter;
    }

    /**
     * Method output to console the figures.
     * @param shape shape.
     */
    public void draw(Shape shape) {
        iPrinter.println(shape.pic());
    }
}
