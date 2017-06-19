package ru.ematveev.generic;

/**
 * @author Matveev Evgeny.
 */
public class RoleStore implements Store<Role> {
    private final int size = 5;
    private SimpleArray<Role> roles = new SimpleArray<>(size);
    /**
     * Method addition the value different types.
     * @param value the enter value.
     */
    @Override
    public void add(Role value) {
            roles.add(value);
    }
    /**
     * Method update the element.
     * @param valueOld value to change.
     * @param valueNew the value to which you want to change.
     */
    @Override
    public void update(Role valueOld, Role valueNew) {
            roles.update(valueOld, valueNew);
    }
    /**
     * Method removes the elements.
     * @param value the enter value.
     */
    @Override
    public void delete(Role value) {
        this.roles.delete(value);
    }

    public SimpleArray<Role> getRoles() {
        return this.roles;
    }
}
