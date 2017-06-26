package ru.ematveev.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test the storage RoleStore.
 */
public class RoleStoreTest {
    /**
     * Test of method the add() of the class RoleStore.
     */
    @Test
    public void whenAddElementTypeUserInArray() {
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        RoleStore roleStore = new RoleStore();
        roleStore.add(role1);
        roleStore.add(role2);

        SimpleArray<Role> role = roleStore.getBase();

        assertThat(role.getValue(1).getId(), is("2"));
    }
    /**
     * Test of method the update() of the class UserStore.
     */
    @Test
    public void whenUpdateElementTypeUserInArray() {
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        Role roleNew = new Role("3");
        RoleStore roleStore = new RoleStore();
        roleStore.add(role1);
        roleStore.add(role2);

        roleStore.update(role1, roleNew);
        SimpleArray<Role> role = roleStore.getBase();

        assertThat(role.getValue(0).getId(), is("3"));
    }
    /**
     * Test of method the delete() of the class UserStore.
     */
    @Test
    public void whenDeleteElementTypeUserInArray() {
        Role role1 = new Role("1");
        Role role2 = new Role("2");
        RoleStore roleStore = new RoleStore();
        roleStore.add(role1);
        roleStore.add(role2);

        roleStore.delete(role1);
        SimpleArray<Role> role = roleStore.getBase();

        assertThat(role.getValue(0).getId(), is("2"));
    }

}