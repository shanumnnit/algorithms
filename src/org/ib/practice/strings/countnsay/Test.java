package org.ib.practice.strings.countnsay;

public class Test {
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int A) {
        StringBuilder sb = new StringBuilder("1");
        while (--A != 0) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < sb.length(); ) {
                int num = sb.charAt(i);
                int count = 1;
                int j = i;
                for (; j < sb.length() - 1; ) {
                    if (sb.charAt(j) == sb.charAt(j + 1)) {
                        j++;
                        count++;
                    } else break;
                }
                if (i != j)
                    i = j + 1;
                else i++;
                sb2.append(count).append((char) num);
            }
            sb = sb2;
        }
        return sb.toString();
    }
}
