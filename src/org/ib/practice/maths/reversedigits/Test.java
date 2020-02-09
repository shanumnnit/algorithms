package org.ib.practice.maths.reversedigits;

public class Test {
    public static void main(String[] args) {
        System.out.println(reverse(-101));
    }

    public static int reverse(int A) {
        boolean isNeg = false;
        if (A < 0) {
            isNeg = true;
            A = -A;
        }
        int temp = A;
        int digits = 0;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        long result = 0;
        while (A > 0) {
            result += (A % 10) * Math.pow(10, --digits);
            A /= 10;
        }
        if (-2147483648 > result || 2147483647 < result)
            return 0;

        if (isNeg)
            return -(int) result;
        return (int) result;

    }
}
