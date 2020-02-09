package org.ib.practice.twopointers.removeduplicatesinsortedarray.atmosttwice;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 5, 5, 6, 9, 9, 9));
        System.out.println(removeDuplicates(a));
        System.out.println(a);
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        int j = 0;
        for (int i = 0; i < a.size(); i++) {
            int currEle = a.get(i);
            int count = 1;
            while ((i + 1) < a.size() && currEle == a.get(i + 1)) {
                i++;
                count++;
                if (i >= a.size() - 1)
                    break;
            }
            a.set(j, currEle);
            j++;
            if (count >= 2 && j < a.size()) {
                a.set(j, currEle);
                j++;
            }
        }
        a.subList(j, a.size()).clear();
        return j;
    }
}
