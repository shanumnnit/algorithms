package org.ib.practice.maths.sieve;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(sieve(23));
    }

    public static ArrayList<Integer> sieve(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == 1) return result;
        int[] x = new int[A];
        Arrays.fill(x, 1);
        x[0] = x[1] = 1;
        for (int i = 2; i < Math.sqrt(A); i++) {
            if (x[i] == 1) {
                for (int j = 2; j * i < A; j++) {
                    x[j * i] = 0;
                }
            }
        }
        for (int i = 2; i < A; i++) {
            if (x[i] == 1)
                result.add(i);
        }
        return result;
    }
}
