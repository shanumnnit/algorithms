package org.ib.practice.arrays.fingmissinginteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-1, 1, 2));
        System.out.println(firstMissingPositive(list));
    }

    public static int firstMissingPositive(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= 0 || list.get(i) >= list.size())
                continue;
            int j = i;
            int currVal = list.get(j);
            for (; currVal >= 0 && currVal < list.size(); ) {
                j = list.get(currVal);
                list.set(currVal, Integer.MIN_VALUE);
                currVal = j;
            }
        }
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            if (Integer.MIN_VALUE != list.get(i))
                return i;
        }
        boolean onePresent = list.stream().anyMatch(x -> x == 1);
        if (onePresent)
            return list.size() + 1;
        return list.size();
    }
}
