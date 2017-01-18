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
     * Method pic() create triangle.
     * @return String;
     */
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("     /\\")
                .append("\n").append("    /  \\")
                .append("\n").append("   /    \\")
                .append("\n").append("  /      \\")
                .append("\n").append(" /        \\")
                .append("\n").append("/__________\\");
        return sb.toString();
    }
}
