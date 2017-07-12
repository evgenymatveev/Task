package ru.ematveev.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for method StackContainer().
 */
public class StackContainerTest {
    /**
     * Test check adding an elements to a container.
     */
    @Test
    public void whenAddElementToContainer() {
        StackContainer<Integer> stackContainer = new StackContainer<Integer>();
        stackContainer.push(2);
        stackContainer.push(5);
        stackContainer.push(56);

        assertThat(stackContainer.getLinkedList().get(1), is(5));
    }
    /**
     * Test check getting last element.
     */
    @Test
    public void whenGetAndRemoveLastElementFromContainer() {
        StackContainer<Integer> stackContainer = new StackContainer<Integer>();
        stackContainer.push(2);
        stackContainer.push(5);
        stackContainer.push(56);

        assertThat(stackContainer.pop(), is(56));
    }
}