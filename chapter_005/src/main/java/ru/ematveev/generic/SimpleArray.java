package ru.ematveev.generic;

import java.util.Arrays;

/**
 * Class for storages the different elements.
 *
 * @param <T> parametrized type.
 */
public class SimpleArray<T> {
    private Object[] objects;
    private int index = 0;

    /**
     * Method for initializing an array.
     *
     * @param size array size.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Array Objects for storing different types of elements.
     *
     * @return array.
     */

    public Object[] getObjects() {
        return objects;
    }

    /**
     * Method adds the elements to an array.
     *
     * @param value Incoming element of any type.
     */
    public void add(T value) {
        if (index < objects.length) {
            this.objects[index++] = value;
        } else {
            objects = Arrays.copyOf(objects, objects.length * 2);
            this.objects[index++] = value;
        }
    }

    /**
     * Getting an item by index.
     *
     * @param position number of the cell in the array where the element is located.
     * @return the element of type T.
     */
    public T getValue(int position) {
        return (T) this.objects[position];
    }

    /**
     * Method for changing the value of an element in an array.
     * @param valueOld value to change.
     * @param valueNew the value to which you want to change.
     * @return boolean.
     */
    public boolean update(T valueOld, T valueNew) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(valueOld) && valueOld.getClass() == objects[i].getClass()) {
                objects[i] = valueNew;
                System.out.println(objects[i]);
                return true;

            }
        }
        return false;
    }

    /**
     * A method that returns the position of an element in an array cell by the value of the element.
     *
     * @param value value of an element in an array of type T.
     * @return number of the cell in the array where the element is located.
     */
    public int getIndex(T value) {
        int result = -1;
        for (int i = 0; i < this.objects.length; i++) {
            if (objects[i].equals(value)) {
                result = i;
            }
        }
        return result;
    }

    /**
     * Method removes an element from an array.
     * @param value value of an element in an array of type T.
     * @return boolean.
     */
    public boolean delete(T value) {
        for (int i = 0; i < this.objects.length; i++) {
            if (objects[i].equals(value) && value.getClass() == objects[i].getClass()) {
                for (int j = i; j < objects.length - 1; j++) {
                    objects[j] = objects[j + 1];

                }
                Object[] newArr = new Object[objects.length - 1];
                System.arraycopy(objects, 0, newArr, 0, objects.length - 1);
                objects = newArr;
                System.out.println(objects.length);
                return true;
            }
        }
        return false;
    }
}
