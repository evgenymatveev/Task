package ru.ematveev.sortsubdivision;

import java.util.*;

/**
 * @author Matveev Evgeny.
 */
public class SortSubdivision {
    private List<String> list;
    private List<String[]> listtmp = new ArrayList<>();

    public SortSubdivision(List<String> list) {
        this.list = list;
    }

    public void divide() {
        for (String str : list) {
            String sp = "\\\\";
            String[] a = str.split(sp);
            listtmp.add(a);
        }
        checkElements();
    }

    private void checkElements() {
        ListIterator<String[]> it = listtmp.listIterator();

        while (it.hasNext()) {
            String[] str = it.next();
            int l = str.length;
            while (l != 1) {
                String[] b = new String[l - 1];
                System.arraycopy(str, 0, b, 0, l - 1);
                if (!addElement(b)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < (l - 1); i++) {
                        sb.append(b[i]);
                        if (i != (l - 1 - 1)) {
                            sb.append("\\");
                        }
                    }
                    //System.out.println(sb.toString());
                    it.add(b);
                    list.add(sb.toString());
                }
                l--;
            }
        }
    }

    private boolean addElement(String[] b) {
        for (String[] s : listtmp) {
            if (Arrays.equals(b, s)) {
                return true;
            }
        }
        return false;
    }

    public List<String> sortAscending() {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("K1\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2\\SK1\\SSK2");

        SortSubdivision ss = new SortSubdivision(list);
        ss.divide();
        ss.sortAscending();

        for (String s : ss.list) {
            System.out.println(s);
        }

    }
}


