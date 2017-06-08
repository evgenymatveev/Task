package ru.ematveev.iterator;

import java.util.Iterator;

/**
 * @author Matveev Evgeny.
 */
public class IteratorEvenNumbers implements Iterator {
    private final int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 26, 44, 11};
    private int index = 0;

    @Override
    public boolean hasNext() {
        return value.length > index;
    }

    @Override
    public Object next() {
        int result = 0;
        for (int i = index; i < value.length; i++) {
            if (value[i] % 2 != 0) {
                index = i + 1;
            } else {
                index = i + 1;
                result = value[i];
                return result;
            }
        }
        return result;
    }
}


