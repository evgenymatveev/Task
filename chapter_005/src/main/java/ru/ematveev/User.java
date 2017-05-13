package ru.ematveev;

/**
 * @author Matveev Evgeny.
 */
public class User {
    private final int id;
    private final String name;
    private final String city;

    public User(final int id, final String name, final String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
