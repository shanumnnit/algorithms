package org.ib.practice.strings.longestcommonprefix;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new ArrayList<>(Arrays.asList("aaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))));
    }

    public static String longestCommonPrefix(ArrayList<String> A) {
        if (A.size() == 0)
            return "";
        else if (A.size() == 1)
            return A.get(0);
        String lcp = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            lcp = findCommon(lcp, A.get(i));
        }
        return lcp;
    }

    private static String findCommon(String a, String b) {
        String smallerStr = a;
        String largerStr = b;
        if (a.length() > b.length()) {
            smallerStr = b;
            largerStr = a;
        }
        StringBuilder prefix = new StringBuilder("");
        for (int i = 0; i < smallerStr.length(); i++) {
            if (smallerStr.charAt(i) == largerStr.charAt(i)) {
                prefix.append(smallerStr.charAt(i));
            } else break;
        }
        return prefix.toString();
    }
}
