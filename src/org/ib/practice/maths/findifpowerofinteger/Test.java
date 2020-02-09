package org.ib.practice.maths.findifpowerofinteger;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        System.out.println(isPower(1024000000));
    }

    public static int isPower(int A) {
        LinkedList<Integer> factors = new LinkedList<>();
        LinkedList<Integer> factors2 = new LinkedList<>();
        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                factors.add(i);
                if (i != A / i)
                    factors2.add(0, A / i);
            }
        }
        factors.addAll(factors2);
        if (factors.size() == 2)
            return 0;
        if (factors.size() == 1)
            return 1;
        for (int i = 1; i < factors.size() - 1 && Math.pow(factors.get(i), 2) <= A; i++) {
            int product = factors.get(i);
            while (true) {
                if (product == A)
                    return 1;
                if (product > A || product == 0)
                    break;
                product = product * factors.get(i);
            }
        }
        return 0;
    }
}
