package org.ib.practice.strings.longestpalindromicsubstring;

public class Test {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabaaa"));
    }

    public static String longestPalindrome(String A) {
        if (A == null || "".equalsIgnoreCase(A.trim()))
            return A;
        boolean[][] dpArr = new boolean[A.length()][A.length()];

        for (int i = 0; i < A.length(); i++)
            dpArr[i][i] = true;
        int resultI = 0;
        int resultJ = 0;
        for (int k = 2; k <= A.length(); k++) {
            for (int i = A.length() - k; i >= 0; i--) {
                if (k == 2) {
                    if (A.charAt(i) == A.charAt(i + k - 1)) {
                        dpArr[i][i + k - 1] = true;
                        resultI = i;
                        resultJ = i + k - 1;
//                        System.out.println(A.substring(resultI, resultJ + 1));
                    }
                    continue;
                }
                if (A.charAt(i) == A.charAt(i + k - 1) && dpArr[i + 1][i + k - 2]) {
                    dpArr[i][i + k - 1] = true;
                    resultI = i;
                    resultJ = i + k - 1;
//                    System.out.println(A.substring(resultI, resultJ + 1));
                }

            }
        }

        return A.substring(resultI, resultJ + 1);
    }
}
