package ru.ematveev.iterator;

import java.util.Iterator;

/**
 * @author Matveev Evgeny.
 */
public interface ConvertIterator {
    /**
     * Interface for create method when converts Iterator<Integer>
     * in a Iterator<Iterator<Integer>>.
     *
     * @param it iterator iterator.
     * @return Iterator<Integer>.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
