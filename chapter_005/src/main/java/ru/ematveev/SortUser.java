package ru.ematveev;

import java.util.Collections;
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

    /**
     * Method sorts the collection by hash.
     * @param list input collection.
     * @return sorted collection.
     */
    public List<Users> sortHash(List<Users> list) {
        Collections.sort(list, new UsersHashComparator());
        return list;
    }
    /**
     * Method sorts the collection by length of name.
     * @param list input collection.
     * @return sorted collection.
     */
    public List<Users> sortLength(List<Users> list) {
        Collections.sort(list, new UsersLengthComparator());
        return list;
    }
}

