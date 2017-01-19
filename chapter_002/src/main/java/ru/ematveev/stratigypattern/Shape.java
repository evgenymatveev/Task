package ru.ematveev.stratigypattern;

/**
 * Interface Shape (Strategy).
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 18.01.17.
 */
public interface Shape {
    /**
     * The base method to create the figures.
     * @param n n.
     * @return String.
     */
    String pic(int n);
}
