package ru.ematveev;

import java.util.ArrayList;
import java.util.List;

/**
 * Class convert two-dimensional array to List and back.
 * @author Matveev Evgeny.
 */
public class ConvertList {
    private List<Integer> list = new ArrayList<>();

    /**
     * Method convert two-dimensional array to List.
     * @param array two-dimensional array.
     * @return list Integer.
     */
    public List<Integer> toList(int[][] array) {
        for (int[] anArray : array) {
            for (int k : anArray) {
                list.add(k);
            }
        }
        return list;
    }

    /**
     * Method convert List to two-dimensional array with the given number of rows.
     * @param list List Integer.
     * @param rows numbers rows for split array.
     * @return two-dimensional array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int columns = 0;
        int k = 0;
        if (list.size() % rows != 0) {
            columns = list.size() / rows + 1;
        } else {
            columns = list.size() / rows;
        }

        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (k == list.size()) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = list.get(k);
                    k++;
                }
            }
        }
        return arr;
    }
}


