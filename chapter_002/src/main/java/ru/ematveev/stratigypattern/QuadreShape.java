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
     * Method pic() create square.
     * @return String;
     */
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(" __________")
                .append("\n").append("|          |")
                .append("\n").append("|          |")
                .append("\n").append("|          |")
                .append("\n").append("|          |")
                .append("\n").append("|__________|");
        return sb.toString();
    }
}
