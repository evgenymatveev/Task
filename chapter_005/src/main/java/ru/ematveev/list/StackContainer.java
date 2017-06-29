package ru.ematveev.list;

/**
 * The implementation of the LIFO stack (last-in-first-out).
 *
 * @param <T> the type of elements.
 */
public class StackContainer<T> {
    private final LinkedListContainer<T> linkedList = new LinkedListContainer<T>();

    public LinkedListContainer<T> getLinkedList() {
        return linkedList;
    }

    /**
     * Method adds items to the container.
     *
     * @param t the element of the T type.
     */
    public void push(final T t) {
        linkedList.add(t);
    }

    /**
     * Method get the last element.
     *
     * @return the last element.
     */
    public T pop() {
        return linkedList.get(linkedList.getSize() - 1);
    }
}
