package ru.ematveev;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
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

        list.addAll(Arrays.asList(users1, users2, users3));
        List<Users> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(users2, users1, users3));
        List<Users> actualValue = new ArrayList<>(sortUser.sort(list));

        assertThat(actualValue, is(list2));
    }

}