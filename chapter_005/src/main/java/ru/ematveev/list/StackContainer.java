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
     * Method delete and get the last element.
     *
     * @return the last element.
     */
    public T pop() {
        T old = linkedList.get(linkedList.getSize() - 1);
        linkedList.remove(linkedList.getSize() - 1);
        return old;
    }
}
