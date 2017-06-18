package ru.ematveev.sortsubdivision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Matveev Evgeny.
 */
public class SortSubdivision {
    private final List<String> list;
    private Set<String> set = new HashSet<String>();

    public SortSubdivision(List<String> list) {
        this.list = list;
    }

    /**
     * Adding missing units to set.
     */
    public void divide() {
        String res = null;
        for (String str : list) {
            String sp = "\\\\";
            String[] a = str.split(sp);
            for (int i = 0; i < a.length; i++) {
                if (i == 0) {
                    res = a[i];
                }
                if (i > 0) {
                    res = res + "\\" + a[i];
                }
                set.add(res);
            }
        }
    }

    /**
     * Method starting the program.
     * @param args String arguments.
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("K1\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2\\SK1\\SSK2");
        list.add("K2\\SK2\\SSK2");
        list.add("K1\\SK2\\SSK2");

        SortSubdivision sd = new SortSubdivision(list);
        sd.divide();

        for (String s : sd.set) {
            System.out.println(s);
        }

    }
}