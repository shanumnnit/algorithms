package org.ib.practice.binarysearch.findsquareroot;

public class Test {
    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
    }

    public static int sqrt(int A) {
        if (A == 0 || A == 1)
            return A;
        long mid = 0;
        long l = 1, r = A;
        for (; l < r; ) {
            mid = (l + r) / 2;
            if (mid * mid == A || (mid * mid < A && (mid + 1) * (mid + 1) > A))
                return (int) mid;
            else if (mid * mid < A)
                l = mid + 1;
            else if (mid * mid > A)
                r = mid - 1;
        }
        if (l == r) return (int) l;
        return (int) mid;
    }
}
