package org.ib.practice.backtracking.graycode;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }

    public static ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(0, 1));
        int lsCounter = 1;
        while (--a > 0) {
            for (int i = res.size() - 1; i >= 0; i--) {
                res.add(res.get(i) | (1 << lsCounter));
            }
            lsCounter++;
        }
        return res;
    }
}
