package org.ib.practice.binarysearch.findxpownmodd;

public class Test {
    public static void main(String[] args) {
        System.out.println(pow(71045970, 41535484, 647354928));
//        System.out.println(pow(12, 5, 15));

    }

    public static int pow(int x, int n, int d) {
        if (x == 0) return x;

        int result = 1;
        x = x % d;
        for (; n > 0; ) {
            if ((n & 1) == 1) {
                result = (result * x) % d;
            }
            x = (x * x) % d;
            n >>= 1;
        }
        return result;
    }
}
