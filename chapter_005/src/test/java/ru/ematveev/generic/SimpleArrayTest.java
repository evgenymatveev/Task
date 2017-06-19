package ru.ematveev.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class SimpleArrayTest {
    /**
     * The method checks the addition of elements to an array of type Integer.
     */
    @Test
    public void whenArrayAddElementTypeInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(2);
        simpleArray.add(1);
        simpleArray.add(2);

        assertThat(simpleArray.getObjects()[1], is(2));
    }
    /**
     * The method checks the addition of elements to an array of type String.
     */
    @Test
    public void whenArrayAddElementTypeString() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(2);
        simpleArray.add("1");
        simpleArray.add("2");

        assertThat(simpleArray.getObjects()[1], is("2"));
    }
    /**
     * The method checks the receipt of elements from the array of type Integer.
     */
    @Test
    public void whenArrayGetValueElementTypeInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(2);
        simpleArray.add(1);
        simpleArray.add(2);

        assertThat(simpleArray.getValue(1), is(2));
    }
    /**
     * The method checks the receipt of elements from the array of type String.
     */
    @Test
    public void whenArrayGetValueElementTypeString() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(2);
        simpleArray.add("1");
        simpleArray.add("2");

        assertThat(simpleArray.getValue(1), is("2"));
    }

    /**
     * The method checks the change of the element in the array of type Integer.
     */
    @Test
    public void whenArrayUpdateValueElementTypeInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(2);
        simpleArray.add(1);
        simpleArray.add(2);

        simpleArray.update(2, 10);

        assertThat(simpleArray.getValue(1), is(10));
    }

    /**
     * The method checks the receipt of an element from an array by index of type Integer.
     */
    @Test
    public void whenArrayGetIndexElementTypeInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(2);
        simpleArray.add(1);
        simpleArray.add(2);

        assertThat(simpleArray.getIndex(2), is(1));
    }

    /**
     * Method checks the deletion of an element from an array.
     */
    @Test
    public void whenArraydeleteElementTypeInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(2);
        simpleArray.add(1);
        simpleArray.add(2);

        simpleArray.delete(2);

        assertThat(simpleArray.getIndex(2), is(-1));
    }

}