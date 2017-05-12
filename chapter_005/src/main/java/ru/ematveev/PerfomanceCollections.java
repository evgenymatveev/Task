package ru.ematveev;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Class measures the time insert and delete items in collections ArrayList, LinkedList and TreeSet.
 * @author Matveev Evgeny.
 */
public class PerfomanceCollections {
    private static final String CHAR = "qwertyuiopasdfghjklzxcvbnm1234567890";
    private static final int STRING_LENGTH = 3;
    private static final int NSMALL = 10000;
    private static final int NBIG = 100000;
    private static final int AMOUNT = 100;
    private Random random = new Random();

    /**
     * Method generate random string to add them in array.
     * @return random string.
     */

    private String generateString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < STRING_LENGTH; i++) {
            int number = random.nextInt(CHAR.length());
            char ch = CHAR.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * Method add received strings in the array.
     * @param array array strings for experiments on collections of.
     * @param n number strings for add to array.
     */
    private void addStrings(String[] array, int n) {
        for (int i = 0; i < n; i++) {
            array[i] = generateString();
        }
    }

    /**
     * Method add strings in the collection.
     * @param collection collection for experiment.
     * @param line an array of strings.
     * @return the time in milliseconds.
     */
    private long add(Collection<String> collection, String[] line) {
        Collections.addAll(collection, line);
        return System.currentTimeMillis();
    }

    /**
     * Method removes elements from the collection.
     * @param collection collection for experiment.
     * @param amount nthe number of elements to remove.
     * @return the time in milliseconds.
     */
    private long delete(Collection<String> collection, int amount) {
        int k = 0;
        while (collection.iterator().hasNext() && k < amount) {
            String str = collection.iterator().next();
            collection.remove(str);
        }
        return System.currentTimeMillis();
    }

    /**
     * Method to measure the time insert and delete items from collections.
     * @param array array strings for experiments.
     * @param n the number of elements.
     */
    private void time(String[] array, int n) {

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        TreeSet<String> treeSet = new TreeSet<>();

        long startArrayList = System.currentTimeMillis();
        add(arrayList, array);
        long diffArrayList = System.currentTimeMillis() - startArrayList;
        System.out.printf("Время вставки строк в коллекцию ArrayList: %s mc \n", diffArrayList);

        long startLinkedList = System.currentTimeMillis();
        add(linkedList, array);
        long diffLinkedList = System.currentTimeMillis() - startLinkedList;
        System.out.printf("Время вставки строк в коллекцию LinkedList: %s mc \n", diffLinkedList);

        long startTreeSet = System.currentTimeMillis();
        add(treeSet, array);
        long diffTreeSet = System.currentTimeMillis() - startTreeSet;
        System.out.printf("Время вставки строк в коллекцию TreeSet: %s mc \n", diffTreeSet);

        long startArrayListDelete = System.currentTimeMillis();
        delete(arrayList, AMOUNT);
        long diffArrayListDelete = System.currentTimeMillis() - startArrayListDelete;
        System.out.printf("Время удаления %d строк в коллекции ArrayList: %s mc \n", AMOUNT, diffArrayListDelete);

        long startLinkedListDelete = System.currentTimeMillis();
        delete(linkedList, AMOUNT);
        long diffLinkedListDelete = System.currentTimeMillis() - startLinkedListDelete;
        System.out.printf("Время удаления %d строк в коллекции LinkedList: %s mc \n", AMOUNT, diffLinkedListDelete);

        long startTreeSetDelete = System.currentTimeMillis();
        delete(treeSet, AMOUNT);
        long diffTreeSetDelete = System.currentTimeMillis() - startTreeSetDelete;
        System.out.printf("Время удаления %d строк в коллекции TreeSet: %s mc \n", AMOUNT, diffTreeSetDelete);
    }

    /**
     * Method start the programm.
     * @param args input String arguments.
     */
    public static void main(String[] args) {
        PerfomanceCollections perfomanceCollections = new PerfomanceCollections();

        String[] arr = new String[NSMALL];
        perfomanceCollections.addStrings(arr, NSMALL);
        System.out.printf("Время вставки и удаления в коллекциях %d элементов: \n", NSMALL);
        perfomanceCollections.time(arr, NSMALL);
        System.out.println();

        String[] arr2 = new String[NBIG];
        perfomanceCollections.addStrings(arr2, NBIG);
        System.out.printf("Время вставки и удаления в коллекциях %d элементов: \n", NBIG);
        perfomanceCollections.time(arr2, NBIG);

    }
}


