package ru.ematveev;

import java.util.Comparator;

/**
 * Class Comparator for method sortHash.
 */
public class UsersHashComparator implements Comparator<Users> {
    /**
     * The method compares the hashcode two Users.
     * @param o1 first Users.
     * @param o2 second Users.
     * @return 0 if value equals, 1 if value Users's first more than value Users's second
     * and -1 1 if value Users's first less than value Users's second
     */
    @Override
    public int compare(Users o1, Users o2) {
        if (o1.hashCode() < o2.hashCode()) {
            return  -1;
        }
        if (o1.hashCode() > o2.hashCode()) {
            return 1;
        } else {
            return 0;
        }
    }
}
