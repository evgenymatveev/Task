package ru.ematveev.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test checks has the Linked list cycle or not.
 */
public class CheckCycleTest {
    /**
     * Test checks the method hasCycle().
     */
    @Test
    public void whenLinkedListHaveCycle() {
        CheckCycle.Node<Integer> first = new CheckCycle.Node(1);
        CheckCycle.Node<Integer> two = new CheckCycle.Node(2);
        CheckCycle.Node<Integer> third = new CheckCycle.Node(3);
        CheckCycle.Node<Integer> four = new CheckCycle.Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        CheckCycle checkCycle = new CheckCycle();
        System.out.println(checkCycle.hasCycle(first));

        assertThat(checkCycle.hasCycle(first), is(true));
    }

}