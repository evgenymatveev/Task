package ru.ematveev.iterator;

import java.util.Iterator;

/**
 * @author Matveev Evgeny.
 */
public class IteratorArray implements Iterator<Integer> {
    private final int[][] value = {{1, 2}, {3, 4}};
    private int i = 0;
    private int j = 0;

    @Override
    public boolean hasNext() {
        return value[i].length > j && value.length > i;
    }

    @Override
    public Integer next() {
        if (j == value[i].length) {
            i++;
            j = 0;
        }
        return value[i][j++];
    }
}


