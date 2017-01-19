package ru.ematveev.stratigypattern;

/**
 * Class QuadreShape implements Shape drawing a square.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 18.01.17.
 */
public class QuadreShape implements Shape {
    /**
     * Number.
     */
    private int n;

    /**
     * Constuctor.
     * @param n n.
     */
    public QuadreShape(int n) {
        this.n = n;
    }
    public String pic() {
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == (n - 1) || j == 0 || j == (n - 1)) {
                    result = result + "x";
                    result = result + " ";
                } else {
                    result = result + "@ ";
                }
            }
            result = result + "\n";
        }
        return result;
    }
}




