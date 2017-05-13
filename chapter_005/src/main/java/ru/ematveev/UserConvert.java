package ru.ematveev;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class convert List Users to Map.
 * @author Matveev Evgeny.
 */
public class UserConvert {
    /**
     * Method convert List Users to Map with key = id users.
     * @param list List users.
     * @return HashMap.
     */
    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> map = new HashMap<>();
        for (User ls : list) {
            map.put(ls.getId(), ls);
        }
        System.out.println(map.toString());
        return map;
    }
}
