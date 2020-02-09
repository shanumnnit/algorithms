package org.ib.practice.maths.findfactors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(allFactors(36));
    }

    public static ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> a = new ArrayList<>();
        List<Integer> b = new LinkedList<>();
        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                a.add(i);
                if (i != A / i)
                    b.add(0, A / i);
            }
        }
        a.addAll(b);
        if (a.size() == 0)
            a.add(1);
        return a;
    }
}
