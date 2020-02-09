package org.ib.practice.twopointers.tripletminimizediff;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 9, 15));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 3, 6, 6));
        System.out.println(solve(A, B, C));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0, j = 0, k = 0; i < A.size() && j < B.size() && k < C.size(); ) {
            int minIndx = minIndex(i, j, k, A, B, C);
            int minValue = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int maxValue = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));

            if (Math.abs(maxValue - minValue) < minDiff) {
                minDiff = Math.abs(maxValue - minValue);
//                System.out.println(A.get(i) + " " + B.get(j) + " " + C.get(k));
            }
            if (minValue == A.get(i))
                i++;
            if (minValue == B.get(j))
                j++;
            if (minValue == C.get(k))
                k++;
        }
        return minDiff;
    }

    private static int minIndex(int i, int j, int k, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        int minValue = Math.min(a.get(i), Math.min(b.get(j), c.get(k)));
        if (minValue == a.get(i))
            return i;
        else if (minValue == b.get(j))
            return j;
        else return k;
    }
}
