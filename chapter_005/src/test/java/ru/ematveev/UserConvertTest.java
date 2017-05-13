package ru.ematveev;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Matveev Evgeny.
 */
public class UserConvertTest {
    /**
     * Test for check method process() - convert List to Map.
     *
     * @throws Exception Exception.
     */
    @Test
    public void testCheckConvertListToMap() throws Exception {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<>();
        User user1 = new User(1, "evgen", "moscow");
        User user2 = new User(2, "oleg", "piter");
        User user3 = new User(3, "vlad", "postov");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        User actualvalue = userConvert.process(list).get(2);

        assertThat(actualvalue, is(user2));
    }

}