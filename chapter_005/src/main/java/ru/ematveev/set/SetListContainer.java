package ru.ematveev.set;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Container for storage the unique elements.
 *
 * @param <E> type of elements.
 */
public class SetListContainer<E> implements SimpleSet<E> {
    private Object[] container;
    private int index = 0;
    private int current = 0;

    /**
     * Constructor for array.
     *
     * @param size size of the array.
     */
    public SetListContainer(int size) {
        this.container = new Object[size];
    }

    public Object[] getContainer() {
        return container;
    }

    @Override
    public void add(E e) {
        if (index < container.length) {
            if (contains(e)) {
                container[index] = e;
                index++;
            }
        } else {
            int newlength = container.length * 3 / 2 + 1;
            container = Arrays.copyOf(container, newlength);
            if (contains(e)) {
                container[index] = e;
                index++;
            }
        }
    }

    /**
     * Method checks the duplicates in an array.
     *
     * @param e the element for check.
     * @return boolean.
     */
    private boolean contains(E e) {
        boolean result = false;
        for (int i = 0; i < container.length; i++) {
            if (e == container[i]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return current < index;
            }

            @Override
            public E next() {
                return (E) container[current++];
            }
        };
    }
}
