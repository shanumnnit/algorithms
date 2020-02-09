package org.ib.practice.binarysearch.rangesearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(searchRange(new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 4)), 5));
    }

    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int firstIndx = -1;
        A.sort(Integer::compareTo);
        firstIndx = binarySearchFirstInd(A, B);
        if (firstIndx == -1) {
            return new ArrayList<>(Arrays.asList(-1, -1));
        }
        int lastIndx = binarySearchLastInd(A, B, firstIndx);
        return new ArrayList<>(Arrays.asList(firstIndx, lastIndx));
    }

    private static int binarySearchFirstInd(List<Integer> a, int b) {
        int l = 0, r = a.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a.get(mid) == b && (((mid - 1) < 0) || a.get(mid) > a.get(mid - 1))) {
                return mid;
            } else if (a.get(mid) > b || (a.get(mid).equals(b) && a.get(mid).equals(a.get(mid - 1)))) {
                r = mid - 1;
            } else if (a.get(mid) < b) {
                l = mid + 1;
            } else break;
        }
        return -1;
    }

    private static int binarySearchLastInd(List<Integer> a, int b, int startIndx) {
        int l = startIndx, r = a.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a.get(mid) > b) {
                r = mid - 1;
            } else if (a.get(mid) == b && ((mid + 1) >= a.size() || (a.get(mid + 1) > b))) {
                return mid;
            } else if (a.get(mid) < b || (a.get(mid) == b && a.get(mid).equals(a.get(mid - 1)))) {
                l = mid + 1;
            } else break;
        }
        return -1;
    }

}
