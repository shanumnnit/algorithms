package org.ib.practice.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(Arrays.asList(100, 202, 201, 200, 1, 3, 2, 4, 203, 5)));
    }

    public static int longestConsecutive(final List<Integer> A) {
        int maxSoFar = 1;
        int min = Collections.min(A);
        int max = Collections.max(A);
        HashSet<Integer> set = new HashSet<>(A);
        int maxHere = 1;
        for (int i = min; i <= max; i++) {
            if (set.contains(i) && set.contains(i + 1)) {
                maxHere++;
                maxSoFar = Math.max(maxSoFar, maxHere);
                continue;
            }
            maxHere = 1;
        }
        return Math.max(maxSoFar, 1);
    }
}
