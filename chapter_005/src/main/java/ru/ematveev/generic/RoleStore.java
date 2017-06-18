package ru.ematveev.generic;

/**
 * @author Matveev Evgeny.
 */
public class RoleStore implements Store<Role> {
    private SimpleArray simpleArray;

    public RoleStore(SimpleArray simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(Role value) {
            simpleArray.add(value);
    }

    @Override
    public void update(Role valueOld, Role valueNew) {
            simpleArray.update(valueOld, valueNew);
    }

    @Override
    public void delete(Role value) {

    }
}
