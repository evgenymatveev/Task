package ru.ematveev.list;

/**
 * The implementation of the FIFO Queue (first-in-first-out).
 *
 * @param <T> the type of elements.
 */
public class QueueContainer<T> {
    private final LinkedListContainer<T> linkedList = new LinkedListContainer<T>();

    public LinkedListContainer<T> getLinkedList() {
        return linkedList;
    }

    /**
     * Method adds items to the container.
     *
     * @param t the element of the T type.
     */
    public void add(T t) {
        linkedList.add(t);
    }

    /**
     * Method delete and get the first element.
     *
     * @return the first element.
     */
    public T peek() {
        return linkedList.remove(0);
    }
}
