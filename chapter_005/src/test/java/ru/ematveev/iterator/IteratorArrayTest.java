package ru.ematveev.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class IteratorArrayTest {
    /**
     * Method check method next().
     */
    @Test
    public void whenCallMethodNext() {
        IteratorArray it = new IteratorArray();

        it.next();
        int result = (int) it.next();

        assertThat(result, is(2));
    }

    /**
     * Method check method hasNext().
     */
    @Test
    public void whenCheckPositionWhenCallHasNext() {
        IteratorArray it = new IteratorArray();

        it.next();
        it.next();
        it.next();
        it.next();
        it.hasNext();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

}