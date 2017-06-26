package ru.ematveev.generic;

/**
 * @author Matveev Evgeny.
 */
class AbstractStore<T extends Base> implements Store<T> {
    private final int size = 5;
    private SimpleArray<T> arrays = new SimpleArray<T>(size);
    /**
     * Method addition the value different types.
     * @param value the enter value.
     */
    @Override
    public void add(T value) {
        this.arrays.add(value);
    }
    /**
     * Method update the element.
     * @param valueOld value to change.
     * @param valueNew the value to which you want to change.
     */
    @Override
    public void update(T valueOld, T valueNew) {
        this.arrays.update(valueOld, valueNew);
    }
    /**
     * Method removes the elements.
     * @param value the enter value.
     */
    @Override
    public void delete(T value) {
        this.arrays.delete(value);
    }

    public SimpleArray<T> getBase() {
        return this.arrays;
    }
}
