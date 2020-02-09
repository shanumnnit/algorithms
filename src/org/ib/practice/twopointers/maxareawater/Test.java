package org.ib.practice.twopointers.maxareawater;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(maxArea(new ArrayList<>(Arrays.asList(3, 1, 2, 4, 5))));
    }

    public static int maxArea(ArrayList<Integer> A) {
        int maxArea = 0;
        for (int i = 0, j = A.size() - 1; i < j; ) {
            int curArea = Math.min(A.get(i), A.get(j)) * (j - i);
            if (curArea > maxArea)
                maxArea = curArea;
            if (A.get(i) < A.get(j))
                i++;
            else j--;
        }
        return maxArea;
    }
}
