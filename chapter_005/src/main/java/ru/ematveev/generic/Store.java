package ru.ematveev.generic;

/**
 * Interface for create storage the different models.
 * @param <T> Parametrized type.
 */
public interface Store<T extends Base> {
    /**
     * Method addition the value different types.
     * @param value the enter value.
     */
    void add(T value);

    /**
     * Method update the element.
     * @param valueOld value to change.
     * @param valueNew the value to which you want to change.
     */
    void update(T valueOld, T valueNew);

    /**
     * Method removes the elements.
     * @param value the enter value.
     */
    void delete(T value);

}
