package ru.ematveev.list;

/**
 * Class checks the Linked list have the cycle or not.
 * @param <T> the type of object.
 */
public class CheckCycle<T> {
    /**
     * Method for check the cycle.
     * @param first one Node of the Linked list.
     * @return true if the cycle is.
     */
    public boolean hasCycle(Node<T> first) {
        Node slow = first;
        Node fast = first;

        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (!slow.equals(fast));
        return true;
    }

    /**
     * Class for create Nodes for Linked list.
     * @param <T> the type of elements.
     */
    public static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }
    }
}
