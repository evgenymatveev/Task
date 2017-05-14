package ru.ematveev;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test the class sort().
 */
public class SortUserTest {
    /**
     * Test checks method sort().
     * @throws Exception Exception.
     */
    @Test
    public void testWhenInputListUsersAndReturnSetSortAge() throws Exception {
        SortUser sortUser = new SortUser();
        List<Users> list = new ArrayList<>();
        Users users1 = new Users("evgen", 30);
        Users users2 = new Users("vlad", 20);
        Users users3 = new Users("gleb", 35);

        list.addAll(
                Arrays.asList(users1, users2, users3));

        Set<Users> actualValue = sortUser.sort(list);
        Set<Users> expectedValue = new TreeSet<>(Arrays.asList(users1, users2, users3));

        assertThat(actualValue, is(expectedValue));
    }

}