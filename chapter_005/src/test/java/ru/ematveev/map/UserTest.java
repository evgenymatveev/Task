package ru.ematveev.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Tests the map.
 */
public class UserTest {
    /**
     * Test the map when the methods equals() and hashcode() is not redefined.
     */
    @Test
    public void whenMethodsEqualsAndHashcodeNotRedefined() {
        Calendar birthdayfirst = new GregorianCalendar(1977, 5, 7);
        Calendar birthdaysecond = new GregorianCalendar(1977, 5, 7);
        User first = new User("Evgen", 30, birthdayfirst);
        User second = new User("Evgen", 30, birthdaysecond);

        Map<User, Object> map = new HashMap<>();
        map.put(first, null);
        map.put(second, null);

        System.out.println(map);
    }
    /**
     * Test the map when the methods hashcode() is redefined.
     */
    @Test
    public void whenMethodHashcodeRedefined() {
        Calendar birthdayfirst = new GregorianCalendar(1977, 5, 7);
        Calendar birthdaysecond = new GregorianCalendar(1977, 5, 7);
        User2 first = new User2("Evgen", 30, birthdayfirst);
        User2 second = new User2("Evgen", 30, birthdaysecond);

        Map<User2, Object> map = new HashMap<>();
        map.put(first, null);
        map.put(second, null);

        System.out.println(map);
    }
    /**
     * Test the map when the methods equals() is redefined.
     */
    @Test
    public void whenMethodEqualsRedefined() {
        Calendar birthdayfirst = new GregorianCalendar(1977, 5, 7);
        Calendar birthdaysecond = new GregorianCalendar(1977, 5, 7);
        User3 first = new User3("Evgen", 30, birthdayfirst);
        User3 second = new User3("Evgen", 30, birthdaysecond);

        Map<User3, Object> map = new HashMap<>();
        map.put(first, null);
        map.put(second, null);

        System.out.println(map);
    }
    /**
     * Test the map when the methods equals() and hashcode() is redefined.
     */
    @Test
    public void whenMethodsEqualsAndHashcodeRedefined() {
        Calendar birthdayfirst = new GregorianCalendar(1977, 5, 7);
        Calendar birthdaysecond = new GregorianCalendar(1977, 5, 7);
        User4 first = new User4("Evgen", 30, birthdayfirst);
        User4 second = new User4("Evgen", 30, birthdaysecond);

        Map<User4, Object> map = new HashMap<>();
        map.put(first, null);
        map.put(second, null);

        System.out.println(map);
    }

}