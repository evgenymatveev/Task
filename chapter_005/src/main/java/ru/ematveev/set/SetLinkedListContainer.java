package ru.ematveev.set;

import java.util.Iterator;

/**
 * A container Set based on a linked list.
 *
 * @param <E> type of elements.
 */
public class SetLinkedListContainer<E> implements SimpleSet<E> {
    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;
    private int current = 0;
    private Node<E> node = null;

    public int getSize() {
        return size;
    }

    @Override
    public void add(E e) {
        if (size == 0) {
            first = new Node<E>(e, null, null);
            last = first;
            size++;
        } else {
            if (contains(e)) {
                Node<E> node = new Node<E>(e, null, null);
                last.next = node;
                last = node;
                size++;
            }
        }
    }

    /**
     * Method check duplicate in a container.
     *
     * @param e the element for check.
     * @return boolean
     */
    private boolean contains(E e) {
        Node<E> node = first;
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (node.element == e) {
                result = false;
                break;
            } else {
                result = true;
                node = node.next;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public E next() {
                if (current == 0) {
                    current++;
                    node = first;
                    return node.element;
                } else {
                    node = node.next;
                    current++;
                    return node.element;
                }
            }
        };
    }

    /**
     * Class for create reference for storage of elements.
     *
     * @param <E> the type of elements.
     */
    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        private Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
