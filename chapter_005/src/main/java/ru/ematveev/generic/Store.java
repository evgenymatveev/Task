package ru.ematveev.generic;

/**
 * @author Matveev Evgeny.
 */
public interface Store<T extends Base> {
    void add(T value);
    void update(T valueOld, T valueNew);
    void delete(T value);

}
