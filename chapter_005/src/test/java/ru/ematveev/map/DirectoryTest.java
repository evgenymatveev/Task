package ru.ematveev.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Class testing the metods insert, delete, get by key and iteration the elements of creating map.
 */
public class DirectoryTest {
    /**
     * The test of method insert().
     */
    @Test
    public void whenInsertElementByKeyShouldCreateMap() {
        Directory<Integer, User4> map = new Directory<>();
        Calendar birthdayfirst = new GregorianCalendar(1977, 5, 7);
        Calendar birthdaysecond = new GregorianCalendar(1977, 5, 7);
        User4 first = new User4("Evgen", 30, birthdayfirst);

        assertThat(map.insert(32, first), is(true));
    }

    /**
     * The test of method get().
     */
    @Test
    public void whenGetElementsOutMapBykeyShouldValue() {
        Directory<Integer, User4> map = new Directory<>();
        Calendar birthdayfirst = new GregorianCalendar(1977, 5, 7);
        Calendar birthdaysecond = new GregorianCalendar(1980, 6, 8);
        User4 first = new User4("Evgen", 30, birthdayfirst);
        User4 second = new User4("Slava", 35, birthdaysecond);

        map.insert(16, first);
        map.insert(9, second);

        assertThat(map.get(9).getName(), is("Slava"));

    }

    /**
     * The test of method delete().
     */
    @Test
    public void whenDeleteElementsOutMapBykeyShouldRemoveElements() {
        Directory<Integer, User4> map = new Directory<>();
        Calendar birthdayfirst = new GregorianCalendar(1977, 5, 7);
        Calendar birthdaysecond = new GregorianCalendar(1980, 6, 8);
        User4 first = new User4("Evgen", 30, birthdayfirst);
        User4 second = new User4("Slava", 30, birthdaysecond);

        map.insert(16, first);
        map.insert(9, second);
        map.delete(16);

        assertNull(map.get(16));
    }

    /**
     * The test of method next().
     */
    @Test
    public void whenCallMethodNext() {
        Directory<Integer, User4> map = new Directory<>();
        Calendar birthdayfirst = new GregorianCalendar(1977, 5, 7);
        Calendar birthdaysecond = new GregorianCalendar(1980, 6, 8);
        User4 first = new User4("Evgen", 30, birthdayfirst);
        User4 second = new User4("Slava", 30, birthdaysecond);

        map.insert(16, first);
        map.insert(32, second);
        map.insert(9, second);
        map.iterator().next();

        assertThat(map.iterator().next(), is(32));
    }

    /**
     * The test of method hasNext().
     */
    @Test
    public void whenCallMethodHasNext() {
        Directory<Integer, User4> map = new Directory<>();
        Calendar birthdayfirst = new GregorianCalendar(1977, 5, 7);
        Calendar birthdaysecond = new GregorianCalendar(1980, 6, 8);
        User4 first = new User4("Evgen", 30, birthdayfirst);
        User4 second = new User4("Slava", 30, birthdaysecond);

        map.insert(16, first);
        map.insert(32, second);
        map.insert(9, second);
        map.iterator().next();
        map.iterator().next();
        map.iterator().next();

        assertThat(map.iterator().hasNext(), is(false));
    }

}