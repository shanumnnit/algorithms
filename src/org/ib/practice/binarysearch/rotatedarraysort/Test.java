package org.ib.practice.binarysearch.rotatedarraysort;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(search((Arrays.asList(5, 6, 0, 1, 2, 3, 4)), 6));
        System.out.println(search((Arrays.asList(2, 3, 4, 5, 6, 0, 1)), 0));
        System.out.println(search((Arrays.asList(101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100)), 202));
        System.out.println(search((Arrays.asList(1, 2, 3, 4)), 1));

    }

    public static int search(final List<Integer> A, int B) {
        int l = 0, r = A.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A.get(mid).equals(B))
                return mid;
            if (A.get(mid) <= A.get(r)) {
                if (B > A.get(mid) && B <= A.get(r))
                    l = mid + 1;
                else
                    r = mid - 1;
            } else {
                if (B > A.get(l) && B < A.get(mid))
                    r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }
}
