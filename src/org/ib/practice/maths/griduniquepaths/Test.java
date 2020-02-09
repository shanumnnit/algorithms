package org.ib.practice.maths.griduniquepaths;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        System.out.println(uniquePaths(10, 13));
    }

    public static int uniquePaths(int A, int B) {
        if (A == 1 || B == 1)
            return 1;
        return (factorial(A + B - 2).divide(factorial(A - 1).multiply(factorial(B - 1)))).intValue();
    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = n; i > 1; i--)
            result = result.multiply(new BigInteger(i + ""));
        return result;
    }
}
