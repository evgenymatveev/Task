package ru.ematveev.stratigypattern;

/**
 * Class TriangleShape implements Shape drawing a triangle.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 18.01.17.
 */
public class TriangleShape implements Shape {
    /**
     * Number.
     */
    private int n;

    /**
     * Constructor.
     * @param n n.
     */
    public TriangleShape(int n) {
        this.n = n;
    }

    /**
     * Method pic() create triangle.
     * @param n n.
     * @return String.
     */
    public String pic() {
        String result = "";
        int x = 0;
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                result = result + " ";
            }
            result = result + "/";
            result = result + generateBackSlash(x) + "\\" + "\n";
            x = x + 2;
        }
        result = result + "/";
        result = result + generateSeparator(x, n) + "\\";
        return result;
    }

    /**
     * Method for generete baskslash.
     * @param x x.
     * @return String.
     */
    public String generateBackSlash(int x) {
        String a = "";
        for (int h = x; h > 0; h--) {
            a = a + "@";
        }
        return a;
    }

    /**
     * Method generate separator.
     * @param x x.
     * @param n n.
     * @return String.
     */
    public String generateSeparator(int x, int n) {
        String a = "";
        for (int h = n; h > 0; h--) {
            a = a + "__";
        }
        return a;
    }
}

