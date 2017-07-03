package ru.ematveev.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Checks work the container for storage unique elements based on a linked list..
 */
public class SetLinkedListContainerTest {
    /**
     * Test check adding an elements to a container.
     */
    @Test
    public void whenAddElementToContainer() {
        SetLinkedListContainer<Integer> setLinkedListContainer = new SetLinkedListContainer<Integer>();
        setLinkedListContainer.add(1);
        setLinkedListContainer.add(2);
        setLinkedListContainer.add(3);

        assertThat(setLinkedListContainer.getSize(), is(3));
    }

    /**
     * Test check adding a duplicate to a container.
     */
    @Test
    public void whenAddDuplicateElementToContainer() {
        SetLinkedListContainer<Integer> setLinkedListContainer = new SetLinkedListContainer<Integer>();
        setLinkedListContainer.add(1);
        setLinkedListContainer.add(2);
        setLinkedListContainer.add(1);

        assertThat(setLinkedListContainer.getSize(), is(2));
    }

    /**
     * Method check method next().
     */
    @Test
    public void whenCallMethodNext() {
        SetLinkedListContainer<Integer> setLinkedListContainer = new SetLinkedListContainer<Integer>();
        setLinkedListContainer.add(1);
        setLinkedListContainer.add(2);

        setLinkedListContainer.iterator().next();

        assertThat(setLinkedListContainer.iterator().next(), is(2));
    }

    /**
     * Method check method hasNext().
     */
    @Test
    public void whenCallMethodHasNext() {
        SetLinkedListContainer<Integer> setLinkedListContainer = new SetLinkedListContainer<Integer>();
        setLinkedListContainer.add(1);
        setLinkedListContainer.add(2);

        setLinkedListContainer.iterator().next();
        setLinkedListContainer.iterator().next();

        assertThat(setLinkedListContainer.iterator().hasNext(), is(false));
    }

}