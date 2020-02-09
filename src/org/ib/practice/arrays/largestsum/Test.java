package org.ib.practice.arrays.largestsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 0, 0);
        System.out.println(largestNumber(list));
    }

    public static String largestNumber(final List<Integer> A) {
        List<Integer> list = new ArrayList<>(A);
        list.sort((a, b) -> {
            StringBuilder s1 = new StringBuilder();
            s1.append(a).append(b);
            StringBuilder s2 = new StringBuilder();
            s2.append(b).append(a);
            return s2.toString().compareTo(s1.toString());
        });
        StringBuilder finalResult = new StringBuilder();
        list.forEach(x -> finalResult.append(x));
        String result = finalResult.toString().replaceAll("^0+(\\d*)", "$1").toString();
        if (result == null || result.trim().equalsIgnoreCase(""))
            result = "0";
        return result;
    }
}
