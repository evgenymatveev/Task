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

}
