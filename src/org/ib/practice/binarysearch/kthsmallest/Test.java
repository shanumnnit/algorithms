package org.ib.practice.binarysearch.kthsmallest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(kthsmallest(Arrays.asList(60, 94, 63, 3, 86, 40, 93, 36, 56, 48, 17, 10, 23, 43, 77, 1, 1, 93, 79, 4, 10, 47, 1, 99, 91, 53, 99, 18, 52, 61, 84, 10, 13, 52, 3, 9, 78, 16, 7, 62), 22));
    }

    public static int kthsmallest(final List<Integer> A, int B) {
        int l = Collections.min(A);
        int h = Collections.max(A);
        while (l <= h) {
            int mid = (l + h) / 2;
            int countLess = 0, countEqual = 0;
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) < mid)
                    countLess++;
                else if (A.get(i) == mid)
                    countEqual++;
                if (countLess >= B)
                    break;
            }
            if (countLess < B && (countLess + countEqual) >= B)
                return mid;
            else if (countLess >= B) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
