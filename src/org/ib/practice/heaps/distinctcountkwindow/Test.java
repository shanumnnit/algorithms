package org.ib.practice.heaps.distinctcountkwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        System.out.println(dNums(new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3)), 3));
    }

    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if (B > A.size()) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < B; j++) {
            if (map.containsKey(A.get(j))) {
                map.put(A.get(j), map.get(A.get(j)) + 1);
                continue;
            }
            map.put(A.get(j), 1);
        }
        res.add(map.size());
        for (int i = 0, j = B; j < A.size(); i++, j++) {
            if (map.get(A.get(i)) == 1) {
                map.remove(A.get(i));
            } else {
                map.put(A.get(i), map.get(A.get(i)) - 1);
            }
            if (map.containsKey(A.get(j))) {
                map.put(A.get(j), map.get(A.get(j)) + 1);
            } else
                map.put(A.get(j), 1);
            res.add(map.size());
        }
        return res;
    }
}
