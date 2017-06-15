package ru.ematveev.iterator;

import java.util.Iterator;

/**
 * @author Matveev Evgeny.
 */
public class IteratorEvenNumbers implements Iterator<Integer> {
    private final int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 26, 44, 11};
    private int index = 0;

    @Override
    public boolean hasNext() {
        return value.length > index && (checkEven(index) != -1);
    }

    @Override
    public Integer next() {
        index = checkEven(index);
        return value[index++];
    }

    /**
     * Parity check method.
     * @param n index of elements.
     * @return numbers if it is even.
     */
    private int checkEven(int n) {
        for (int i = n; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method start the program.
     * @param args String[].
     */
    public static void main(String[] args) {
        IteratorEvenNumbers it = new IteratorEvenNumbers();

        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());
    }
}


