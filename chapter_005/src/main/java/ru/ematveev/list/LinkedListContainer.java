package ru.ematveev.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Container based on a linked list.
 * @param <T> the type of objects.
 */
public class LinkedListContainer<T> implements SimpleContainer<T> {
    private Item<T> first = null;
    private Item<T> last = null;
    private int size;
    private int current = 0;

    public Item<T> getLast() {
        return last;
    }

    public Item<T> getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }

    /**
     * Method adds items to the container.
     * @param t the element of the T type.
     */
    @Override
    public void add(final T t) {
        if (size == 0) {
            first = new Item<>(t, null, null);
            last = first;
            size++;
        } else {
            Item<T> node = new Item<>(t, null, null);
            last.next = node;
            last = node;
            size++;
        }
    }

    /**
     * Method delete the element by index.
     * @param index number the element.
     * @return the value of the deleted item.
     */
    public T remove(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(size == 0) {
            throw new NullPointerException("Empty list");
        }
        Item<T> node = first;
            for(int i = 0; i < index; i++) {
                node = node.next;
            }
            Item<T> nodeOld = node;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
            size--;
            return nodeOld.element;
    }

    /**
     * Method gets the element by index.
     * @param index the number element in the container.
     * @return the element.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Item<T> node = first;
            for (int i = 0; i < index; i++) {
               node = node.next;
            }
        return node.element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return current != size;
            }

            @Override
            public T next() {
                if (size == 0) {
                    throw new NoSuchElementException();
                }
                T next = get(current);
                current++;

                return next;
            }
        };
    }

    /**
     * Class for create reference for storage of elements.
     * @param <T> the type of elements.
     */
    private static class Item<T> {
        private T element;
        private Item<T> next;
        private Item<T> prev;

        private Item(final T element, final Item<T> next, final Item<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

