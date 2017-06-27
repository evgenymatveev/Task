package ru.ematveev.list;

import java.util.Iterator;

/**
 * Interface for implementing various dynamic containers for storing elements.
 *
 * @param <T> the type of elements.
 */
public interface SimpleContainer<T> extends Iterable<T> {
    /**
     * Method for add the elements to a container.
     *
     * @param t the element of the T type.
     */
    void add(T t);

    /**
     * Method getting an element by index.
     *
     * @param index the number element in the container.
     * @return the element of the T type.
     */
    T get(int index);

    @Override
    Iterator<T> iterator();
}
