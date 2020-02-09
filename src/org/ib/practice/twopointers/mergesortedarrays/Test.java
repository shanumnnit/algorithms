package org.ib.practice.twopointers.mergesortedarrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 5, 8));
        merge(a, new ArrayList<>(Arrays.asList(6, 7, 9, 10)));
        System.out.println(a);
    }

    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        a.ensureCapacity(a.size() + b.size());
        int j = 0;
        for (int i = 0; i < a.size() && j < b.size(); ) {
            while (a.get(i) <= b.get(j)) {
                i++;
                if (i >= a.size()) break;
            }
            a.add(i, b.get(j));
            i++;
            j++;
        }
        for (int k = j; k < b.size(); k++) {
            a.add(b.get(k));
        }
    }
}
