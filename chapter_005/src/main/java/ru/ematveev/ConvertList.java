package ru.ematveev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class convert two-dimensional array to List and back.
 *
 * @author Matveev Evgeny.
 */
public class ConvertList {
    private List<Integer> list = new ArrayList<>();

    /**
     * Method convert two-dimensional array to List.
     *
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
     *
     * @param list List Integer.
     * @param rows numbers rows for split array.
     * @return two-dimensional array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        Iterator<Integer> iter = list.iterator();
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
                if (iter.hasNext()) {
                    arr[i][j] = iter.next();
                }
            }
        }

        return arr;
    }

    /**
     * Method converts List arrays in to List Integer.
     * @param list input List arrays.
     * @return List Integer.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] ls : list) {
            for (int l : ls) {
                result.add(l);
            }
        }
        return result;
    }
}


