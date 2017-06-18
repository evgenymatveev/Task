package ru.ematveev.generic;

/**
 * @author Matveev Evgeny.
 */
public class UserStore implements Store<User> {
    int size;
    private SimpleArray<User> simpleArray = new SimpleArray<User>(size);

    @Override
    public void add(User value) {
        simpleArray.add(value);
    }

    @Override
    public void update(User valueOld, User valueNew) {
        simpleArray.update(valueOld, valueNew);
    }

    @Override
    public void delete(User value) {

    }
}
