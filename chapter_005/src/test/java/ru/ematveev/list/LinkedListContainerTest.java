package ru.ematveev.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class LinkedListContainerTest {
    /**
     * Test check adding an elements to a container.
     */
    @Test
    public void whenAddElementToContainer() {
        LinkedListContainer<Integer> linkedList = new LinkedListContainer<Integer>();
        linkedList.add(5);
        linkedList.add(7);

        assertThat(linkedList.getSize(), is(2));
    }
    /**
     * Test check getting an element by index.
     */
    @Test
    public void whenGetElementFromContainerByIndex() {
        LinkedListContainer<Integer> linkedList = new LinkedListContainer<Integer>();
        linkedList.add(5);
        linkedList.add(7);

        assertThat(linkedList.get(1), is(7));

    }

    /**
     * Method check method next().
     */
    @Test
    public void whenCallMethodNext() {
        LinkedListContainer<Integer> linkedList = new LinkedListContainer<Integer>();
        linkedList.add(5);
        linkedList.add(7);

        linkedList.iterator().next();

        assertThat(linkedList.iterator().next(), is(7));
    }

    /**
     * Method check method hasNext().
     */
    @Test
    public void whenCallMethodHasNext() {
        LinkedListContainer<Integer> linkedList = new LinkedListContainer<Integer>();
        linkedList.add(5);
        linkedList.add(7);

        linkedList.iterator().next();
        linkedList.iterator().next();

        assertThat(linkedList.iterator().hasNext(), is(false));
    }

}