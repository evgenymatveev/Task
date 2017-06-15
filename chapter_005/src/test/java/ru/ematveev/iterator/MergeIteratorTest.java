package ru.ematveev.iterator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class MergeIteratorTest {
    /**
     * Method check method hasNext().
     */
    @Test
    public void whenCheckPositionWhenCallHasNext() {
        Iterator<Integer> it1 = Arrays.asList(2, 4, 8).iterator();
        Iterator<Integer> it2 = Arrays.asList(5, 1, 3).iterator();
        Iterator<Integer> it3 = Arrays.asList(6, 9, 7).iterator();
        Iterator<Iterator<Integer>> it = Arrays.asList(it1, it2, it3).iterator();
        ConvertIteratorInteger convertIterator = new ConvertIteratorInteger();
        Iterator<Integer> newIterator = convertIterator.convert(it);

        newIterator.next();
        newIterator.next();
        newIterator.next();
        boolean result = newIterator.hasNext();

        assertThat(result, is(true));
    }

    /**
     * Method check method next().
     */
    @Test
    public void nwhenCallMethodNext() {
        Iterator<Integer> it1 = Arrays.asList(2, 4, 8).iterator();
        Iterator<Integer> it2 = Arrays.asList(5, 1, 3).iterator();
        Iterator<Integer> it3 = Arrays.asList(6, 9, 7).iterator();
        Iterator<Iterator<Integer>> it = Arrays.asList(it1, it2, it3).iterator();
        ConvertIteratorInteger convertIterator = new ConvertIteratorInteger();
        Iterator<Integer> newIterator = convertIterator.convert(it);

        newIterator.next();
        newIterator.next();
        newIterator.next();
        int result = (int) newIterator.next();

        assertThat(result, is(5));
    }

}