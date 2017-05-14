package ru.ematveev;

import java.util.Set;
import java.util.TreeSet;
import java.util.List;

/**
 * Class age sorts the users in ascending order.
 */
public class SortUser {
    /**
     * Method age sorts the users in ascending order.
     * @param list input List users.
     * @return Set users.
     */
     public Set<Users> sort(List<Users> list) {
        Set<Users> users = new TreeSet<>();
        users.addAll(list);
        return users;
    }
}

