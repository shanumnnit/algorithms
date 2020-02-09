package org.ib.practice.maths.factorialzeroes;

public class Test {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(0));
    }

    public static int trailingZeroes(int A) {
        int trailingZeros = 0;
        for (int i = 5; i <= A; i += 5) {
            int temp = i;
            while (temp % 5 == 0 && temp != 0) {
                trailingZeros++;
                temp /= 5;
            }
        }
        return trailingZeros;
    }
}
