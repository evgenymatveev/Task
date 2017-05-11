package ru.ematveev;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class ConvertListTest {
    private ConvertList convertList;
    private int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    private List<Integer> list;

    /**
     * Method for initial data.
     * @throws Exception Exception.
     */
    @Before
    public void setUp() throws Exception {
        convertList = new ConvertList();
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
    }

    /**
     * Test for method validation toList.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenArrayConvertToList() throws Exception {
        List<Integer> actualvalue = convertList.toList(arr);
        List<Integer> expectedValue = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));

        assertThat(actualvalue, is(expectedValue));

    }

    /**
     * Test for method validation toArray.
     * @throws Exception Exception.
     */
    @Test
    public void testWhenListConvertToArrayForGivenNumberOfColumns() throws Exception {
        int[][] actualvalue = convertList.toArray(list, 3);
        int[][] expectedValue = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};

        assertThat(actualvalue, is(expectedValue));
    }

}