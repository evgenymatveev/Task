package ru.ematveev.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for method QueueContainer().
 */
public class QueueContainerTest {
    /**
     * Test check adding an elements to a container.
     */
    @Test
    public void whenAddElementToContainer() {
        QueueContainer<String> queueContainer = new QueueContainer<String>();
        queueContainer.add("a");
        queueContainer.add("b");
        queueContainer.add("c");

        assertThat(queueContainer.getLinkedList().get(0), is("a"));

    }
    /**
     * Test check getting first element.
     */
    @Test
    public void whenGetElementFromContainer() {
        QueueContainer<String> queueContainer = new QueueContainer<String>();
        queueContainer.add("a");
        queueContainer.add("b");
        queueContainer.add("c");

        assertThat(queueContainer.peek(), is("a"));
    }

}