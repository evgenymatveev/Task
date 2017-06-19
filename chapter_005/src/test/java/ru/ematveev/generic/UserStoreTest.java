package ru.ematveev.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test the storage UserStore.
 */
public class UserStoreTest {
    /**
     * Test of method the add() of the class UserStore.
     */
    @Test
    public void whenAddElementTypeUserInArray() {
        User user1 = new User("1");
        User user2 = new User("2");
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);

        SimpleArray<User> user = userStore.getUsers();

        assertThat(user.getValue(1).getId(), is("2"));
    }
    /**
     * Test of method the update() of the class UserStore.
     */
    @Test
    public void whenUpdateElementTypeUserInArray() {
        User user1 = new User("1");
        User user2 = new User("2");
        User userNew = new User("3");
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);

        userStore.update(user1, userNew);
        SimpleArray<User> user = userStore.getUsers();

        assertThat(user.getValue(0).getId(), is("3"));
    }
    /**
     * Test of method the delete() of the class UserStore.
     */
    @Test
    public void whenDeleteElementTypeUserInArray() {
        User user1 = new User("1");
        User user2 = new User("2");
        UserStore userStore = new UserStore();
        userStore.add(user1);
        userStore.add(user2);

        userStore.delete(user1);
        SimpleArray<User> user = userStore.getUsers();

        assertThat(user.getValue(0).getId(), is("2"));
    }

}