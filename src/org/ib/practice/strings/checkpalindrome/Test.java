package org.ib.practice.strings.checkpalindrome;

public class Test {
    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static int isPalindrome(String A) {
        int l = 0, r = A.length() - 1;
        boolean contansLetterOrDigit = false;
        for (int i = 0; i < A.length(); i++) {
            contansLetterOrDigit |= isLetterOrDigit(A.charAt(i));
        }
        if (!contansLetterOrDigit) return 1;
        while (l < r) {
            try {
                while (!isLetterOrDigit(A.charAt(l)))
                    l++;
                while (!isLetterOrDigit(A.charAt(r)))
                    r--;
            } catch (Exception e) {
                return 0;
            }
            char lowerCaseL = A.charAt(l) >= 'A' && A.charAt(l) <= 'Z' ? (char) ('a' + A.charAt(l) - 'A') : A.charAt(l);
            char lowerCaseR = A.charAt(r) >= 'A' && A.charAt(r) <= 'Z' ? (char) ('a' + A.charAt(r) - 'A') : A.charAt(r);
            if (lowerCaseL != lowerCaseR)
                return 0;
            l++;
            r--;
        }
        return 1;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
}
