package org.ib.practice.hashing.twosum;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(twoSum(new ArrayList<>(Arrays.asList(2, 11, 11, -2, -2, 15, 3, 7)), 9));
    }

    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(B - A.get(i))) {
                return new ArrayList<>(Arrays.asList(map.get(B - A.get(i)) + 1, i + 1));
            } else if (map.containsKey(A.get(i)))
                continue;
            map.put(A.get(i), i);
        }
        return res;
    }
}
