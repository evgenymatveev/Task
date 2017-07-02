package ru.ematveev.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Checks work the container for storage unique elements.
 */
public class SetListContainerTest {
    /**
     * Test check adding an elements to a container.
     */
    @Test
    public void whenAddElementToContainer() {
        SetListContainer<Integer> setlist = new SetListContainer<Integer>(3);
        setlist.add(1);
        setlist.add(2);
        setlist.add(3);

        assertThat(setlist.getContainer()[1], is(2));
    }

    /**
     * Test check adding a duplicate to a container.
     */
    @Test
    public void whenAddDuplicateElementToContainer() {
        SetListContainer<Integer> setlist = new SetListContainer<Integer>(3);
        setlist.add(1);
        setlist.add(2);
        setlist.add(1);

        assertNull(setlist.getContainer()[2]);
    }

    /**
     * Method check method next().
     */
    @Test
    public void whenCallMethodNext() {
        SetListContainer<Integer> setlist = new SetListContainer<Integer>(3);
        setlist.add(1);
        setlist.add(2);

        setlist.iterator().next();

        assertThat(setlist.iterator().next(), is(2));
    }

    /**
     * Method check method hasNext().
     */
    @Test
    public void whenCallMethodHasNext() {
        SetListContainer<Integer> setlist = new SetListContainer<Integer>(3);
        setlist.add(1);
        setlist.add(2);

        setlist.iterator().next();
        setlist.iterator().next();

        assertThat(setlist.iterator().hasNext(), is(false));
    }

}