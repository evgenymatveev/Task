package ru.ematveev.generic;

/**
 * @author Matveev Evgeny.
 */
public class UserStore implements Store<User> {
    private final int size = 5;
    private SimpleArray<User> users = new SimpleArray<>(size);
    /**
     * Method addition the value different types.
     * @param value the enter value.
     */
    @Override
    public void add(User value) {
        this.users.add(value);
    }
    /**
     * Method update the element.
     * @param valueOld value to change.
     * @param valueNew the value to which you want to change.
     */
    @Override
    public void update(User valueOld, User valueNew) {
        this.users.update(valueOld, valueNew);
    }
    /**
     * Method removes the elements.
     * @param value the enter value.
     */
    @Override
    public void delete(User value) {
        this.users.delete(value);
    }
}
