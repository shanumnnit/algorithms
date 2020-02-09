package org.ib.practice.maths.excelcolumntitle;

public class Test {
    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }

    public static String convertToTitle(int A) {
        String title = "";
        for (int i = 1; A > 0; i++) {
            int mod = A % 26 - 1;
            if (mod < 0) {
                mod = 25;
                A--;
            }
            title = (char) (mod + 'A') + title;
            A /= 26;
        }
        return title;
    }
}
