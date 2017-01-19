package ru.ematveev.stratigypattern;

/**
 * Class QuadreShape implements Shape drawing a square.
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 18.01.17.
 */
public class QuadreShape implements Shape {
//    private int n;
//
//    public QuadreShape(int n) {
//        this.n = n;
//    }

    /**
     * Method pic() create square.
     *
     * @return String;
     */
    public String pic(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == (n - 1) || j == 0 || j == (n - 1)) {
//                    System.out.print("x");
//                    System.out.print(" ");
                    result = result + "x";
                    result = result + " ";
                } else {
//                    System.out.print("@ ");
                    result = result + "@ ";
                }
            }
//            System.out.println();
            result = result + "\n";
        }
        return result;
    }

}




