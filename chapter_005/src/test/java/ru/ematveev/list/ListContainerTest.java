package ru.ematveev.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for method ListContainer().
 */
public class ListContainerTest {
    /**
     * Test check adding an elements to a container.
     */
    @Test
    public void whenAddElementToContainer() {
        ListContainer<String> list = new ListContainer<>(10);
        list.add("a");
        list.add("b");

        assertThat(list.getContainer()[1], is("b"));
    }

    /**
     * Test check getting an element by index.
     */
    @Test
    public void whenGetElementFromContainerByIndex() {
        ListContainer<String> list = new ListContainer<>(10);
        list.add("a");
        list.add("b");

        assertThat(list.get(0), is("a"));
    }

    /**
     * Method check method next().
     */
    @Test
    public void whenCallMethodNext() {
        ListContainer<String> list = new ListContainer<>(10);
        list.add("a");
        list.add("b");

        list.iterator().next();

        assertThat(list.iterator().next(), is("b"));
    }

    /**
     * Method check method hasNext().
     */
    @Test
    public void whenCallMethodHasNext() {
        ListContainer<String> list = new ListContainer<>(10);
        list.add("a");
        list.add("b");

        list.iterator().next();
        list.iterator().next();

        assertThat(list.iterator().hasNext(), is(false));
    }

}