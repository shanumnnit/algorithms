package org.ib.practice.backtracking.allsubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = subsets(new ArrayList<>(Arrays.asList(3, 1, 2)));
        result.forEach(System.out::println);
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        A.sort(Integer::compare);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        subsetsHelper(A, 0, new ArrayList<>(), result);
        result.sort((a12, b) -> {
            int a1 = a12.size();
            int a2 = b.size();
            int res = 0;
            for (int i = 0; i < Math.min(a1, a2); i++) {
                res = Integer.compare(a12.get(i), b.get(i));
                if (res != 0) return res;
            }
            return Integer.compare(a1, a2);
        });
        return result;
    }

    private static void subsetsHelper(ArrayList<Integer> A, int ind, ArrayList<Integer> curObjs, ArrayList<ArrayList<Integer>> result) {
        if (ind == A.size()) {
            result.add(curObjs);
            return;
        }
        subsetsHelper(A, ind + 1, new ArrayList<>(curObjs), result);
        curObjs.add(A.get(ind));
        subsetsHelper(A, ind + 1, new ArrayList<>(curObjs), result);
    }
}
