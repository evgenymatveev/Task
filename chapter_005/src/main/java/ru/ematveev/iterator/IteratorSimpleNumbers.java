package ru.ematveev.iterator;

import java.util.Iterator;

/**
 * @author Matveev Evgeny.
 */
public class IteratorSimpleNumbers implements Iterator<Integer> {
    private final int[] value = {2, 523, 199, 525, 347, 983, 11, 529, 7, 912};
    private int index = 0;

    @Override
    public boolean hasNext() {
        if (value.length > index) {
            for (int i = index; i < value.length; i++) {
                if (checkSqrt(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        int result = 0;
        for (int i = index; i < value.length; i++) {
            if (checkSqrt(value[i])) {
                result = value[i];
                index = i + 1;
                break;
            }
        }
        return result;
    }

      /**
     * The method checks the "prime number" or not.
     *
     * @param n verified number.
     * @return boolean.
     */
    private boolean checkSqrt(int n) {
        if (n == 0 || n == 1 || (n % 2 == 0 && n != 2)) {
            return false;
        } else {
            int x = (int) Math.sqrt(n);
            if (Math.pow(x, 2) == n) {
                if (checkNumber(x)) {
                    return false;
                }
            } else {
                if (checkNumber(n)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method checks whether the number n is divided by a number other than n.
     *
     * @param n verified number.
     * @return boolean.
     */
    private boolean checkNumber(int n) {
        if (n % 2 != 0 && n != 2) {
            for (int i = 3; i < Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}


