package org.ib.practice.strings.reversewordwise;

public class Test {
    public static void main(String[] args) {
//        System.out.println(solve("   hello     world   whatsupp   "));
        System.out.println(solve(" abcba dd "));
    }

    public static String solve(String A) {
        StringBuilder sb = new StringBuilder(A.trim());
        for (int i = 0; i < sb.length(); ) {
            int j = i;
            for (; j < sb.length(); j++) {
                if (sb.charAt(j) == ' ') {
                    break;
                }
            }
            reverse(sb, i, j - 1);
            while ((j + 1) < sb.length() && sb.charAt(j + 1) == ' ') {
                sb.deleteCharAt(j-- + 1);
                j++;
            }
            i = ++j;
        }
        return sb.reverse().toString();
    }

    private static void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }
}
