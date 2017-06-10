package ru.ematveev.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class IteratorEvenNumbersTest {
    /**
     * Method check method next().
     */
    @Test
    public void whenCallMethodNext() {
        IteratorEvenNumbers it = new IteratorEvenNumbers();

        it.next();
        it.next();
        it.next();
        it.next();
        int result = (int) it.next();

        assertThat(result, is(10));
    }

    /**
     * Method check method hasNext().
     */
    @Test
    public void whenCheckPositionWhenCallHasNext() {
        IteratorEvenNumbers it = new IteratorEvenNumbers();

        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.hasNext();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }
}