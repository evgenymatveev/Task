package ru.ematveev.generic;

/**
 * @author Matveev Evgeny.
 */
public abstract class Base {
    private String id;

    public Base(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
