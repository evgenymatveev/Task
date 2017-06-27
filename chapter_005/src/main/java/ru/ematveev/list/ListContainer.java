package ru.ematveev.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * The dynamic container at the base of the array for storage <T> elements.
 *
 * @param <T> the type of elements.
 */
public class ListContainer<T> implements SimpleContainer<T> {
    private Object[] container;
    private int index = 0;
    private int current = 0;

    public ListContainer(int size) {
        this.container = new Object[size];
    }

    public Object[] getContainer() {
        return container;
    }

    @Override
    public void add(T t) {
        if (index < container.length) {
            container[index] = t;
            index++;
        } else {
            int newlength = container.length * 3 / 2 + 1;
            container = Arrays.copyOf(container, newlength);
            container[index] = t;
            index++;
        }
    }

    @Override
    public T get(int index) {
        return (T) container[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index > current;
            }

            @Override
            public T next() {
                return (T) container[current++];
            }
        };
    }
}
