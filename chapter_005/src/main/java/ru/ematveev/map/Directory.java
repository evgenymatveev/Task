package ru.ematveev.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Create the map for storage pair "key, value".
 *
 * @param <T> the key of map.
 * @param <V> the value of map.
 */
public class Directory<T, V> implements Iterable<T> {
    private Node[] tablehash;
    private ArrayList<Integer> arrayIndexValueMap;
    private int valueIndexMap = 0;
    private int tablesize;
    private int index;
    private int currentindex = 0;
    private int numbersElement = 0;
    private Node<T, V> nodeIterator = null;

    public Directory() {
        this.tablesize = 16;
        this.tablehash = new Node[tablesize];
        this.arrayIndexValueMap = new ArrayList<Integer>();
    }

    /**
     * The method create the index for array (hash table of Node).
     *
     * @param key key of element.
     * @return int value.
     */
    public int hashFunction(T key) {
        return key.hashCode() % tablesize;
    }

    /**
     * Method insert the element in the map.
     *
     * @param key   key of element.
     * @param value vakue of element.
     * @return boolean.
     */
    public boolean insert(T key, V value) {
        incrementArray(currentindex);
        index = hashFunction(key);
        if (tablehash[index] != null) {
            Node<T, V> node = tablehash[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    return false;
                } else {
                    if (node.next == null) {
                        Node<T, V> newNode = new Node<T, V>(key, value, null);
                        node.next = newNode;
                        numbersElement++;
                        return true;
                    }
                    node = node.next;
                }
            }
        } else {
            tablehash[index] = new Node(key, value, null);
            currentindex++;
            numbersElement++;
            arrayIndexValueMap.add(index);
            return true;
        }
        return false;
    }

    /**
     * Method check the size of table and increases by 2 times when the hashtable is filled.
     *
     * @param currentindex the number indeses in the hashtable.
     * @return boolean.
     */
    private boolean incrementArray(int currentindex) {
        if (currentindex == tablehash.length) {
            int newtablesize = tablesize * 2;
            Node[] newtablehash = Arrays.copyOf(tablehash, newtablesize);
            tablehash = newtablehash;
            return true;
        }
        return true;
    }

    /**
     * Method getting the value of element by key.
     *
     * @param key the key of element.
     * @return the value of elements.
     */
    public V get(T key) {
        if (key != null) {
            int index = hashFunction(key);
            Node<T, V> node = tablehash[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }

    /**
     * Method delete the element by key.
     *
     * @param key the key of element.
     * @return boolean.
     */
    public boolean delete(T key) {
        if (key != null) {
            int index = hashFunction(key);
            Node<T, V> node = tablehash[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    if (node.next == null) {
                        tablehash[index] = null;
                        arrayIndexValueMap.remove(key);
                        currentindex--;
                        numbersElement--;
                        return true;
                    } else {
                        Node<T, V> nodeNext = node.next;
                        node.key = (T) node.next.key;
                        node.value = (V) node.next.value;
                        Node<T, V> nodePrev = node;
                        nodePrev.next = nodeNext.next;
                        numbersElement--;
                        return true;
                    }
                }
                Node<T, V> nodeNext = node.next;
                if (nodeNext.key.equals(key)) {
                    Node<T, V> nodePrev = node;
                    nodePrev.next = nodeNext.next;
                    //arrayIndexValueMap.remove(hashFunction(key));
                    numbersElement--;
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    /**
     * Class for create the elements.
     *
     * @param <T> the unque key.
     * @param <V> the value of key.
     */
    private static class Node<T, V> {
        private T key;
        private V value;
        private Node next;

        private Node(T key, V value, Node<T, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return numbersElement != 0;
            }

            @Override
            public T next() {
                T keyMap = null;
                int indexHash = arrayIndexValueMap.get(valueIndexMap);
                if (nodeIterator == null) {
                    nodeIterator = tablehash[indexHash];
                }
                if (nodeIterator.next != null) {
                    keyMap = nodeIterator.key;
                    nodeIterator = nodeIterator.next;
                    numbersElement--;
                } else {
                    keyMap = nodeIterator.key;
                    nodeIterator = nodeIterator.next;
                    valueIndexMap++;
                    numbersElement--;
                }
                return keyMap;
            }
        };
    }
}
