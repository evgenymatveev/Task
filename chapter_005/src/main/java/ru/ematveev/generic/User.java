package ru.ematveev.generic;

/**
 * @author Matveev Evgeny.
 */
public class User extends Base {
    public User(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
