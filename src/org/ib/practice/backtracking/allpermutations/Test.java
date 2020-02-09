package org.ib.practice.backtracking.allpermutations;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(permute(new ArrayList<>(Arrays.asList(1, 2, 3))));
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(A));
        permuteHelper(A, 0, result);
        return result;
    }

    private static void permuteHelper(ArrayList<Integer> arr, int i, ArrayList<ArrayList<Integer>> result) {
        if (i >= arr.size())
            return;
        for (int j = i; j < arr.size(); j++) {
            swap(arr, i, j);
            if (i != j)
                result.add(new ArrayList<>(arr));
            permuteHelper(arr, i + 1, result);
            swap(arr, i, j);
        }
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        Integer ith = arr.get(i);
        Integer jth = arr.get(j);
        arr.set(i, jth);
        arr.set(j, ith);
    }
}
