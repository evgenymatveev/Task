package ru.ematveev.iterator;

import java.util.Iterator;

/**
 * Create iterator when converts Iterator<Iterator<Integer>> in group Iterator<Integer>.
 *
 * @param <Integer> type the elements of iterator.
 */

public class MergeIterator<Integer> implements Iterator<Integer> {
    private Iterator<Iterator<Integer>> it;
    private Iterator<Integer> currentIterator = null;

    public MergeIterator(Iterator<Iterator<Integer>> it) {
        this.it = it;
    }

    @Override
    public boolean hasNext() {
        check();
        return (currentIterator != null && currentIterator.hasNext());
    }

    @Override
    public Integer next() {
        check();
        return currentIterator.next();
    }

    /**
     * Method check presence of elements in the iterators.
     */
    private void check() {
        if (currentIterator != null && currentIterator.hasNext()) {
            return;
        }
        currentIterator = null;
        while (it.hasNext()) {
            Iterator<Integer> itNext = it.next();
            if (itNext.hasNext()) {
                currentIterator = itNext;
                break;
            }
        }
    }
}
