package ru.ematveev.iterator;

import java.util.Iterator;

/**
 * @author Matveev Evgeny.
 */
public class ConvertIteratorInteger implements ConvertIterator {
    /**
     * Iterator implementation.
     *
     * @param it iterator iterator.
     * @return Iterator<Integer>.
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new MergeIterator<Integer>(it);
    }
}
