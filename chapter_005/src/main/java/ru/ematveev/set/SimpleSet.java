package ru.ematveev.set;

import java.util.Iterator;

/**
 * Conteaner for storage the unique elements.
 *
 * @param <E> type of elements.
 */
public interface SimpleSet<E> extends Iterable<E> {
    /**
     * Method for add the elements to a container.
     *
     * @param e the element of the T type.
     */
    void add(E e);

    @Override
    Iterator<E> iterator();

}
