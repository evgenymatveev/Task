package ru.ematveev.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class IteratorSimpleNumbersTest {
    /**
     * Method check method next().
     */
    @Test
    public void whenCallMethodNext() {
        IteratorSimpleNumbers it = new IteratorSimpleNumbers();

        it.next();
        it.next();
        it.next();
        it.next();
        int result = (int) it.next();

        assertThat(result, is(983));
    }

    /**
     * Method check method hasNext().
     */
    @Test
    public void whenCheckPositionWhenCallHasNext() {
        IteratorSimpleNumbers it = new IteratorSimpleNumbers();

        it.next();
        it.next();
        it.next();
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