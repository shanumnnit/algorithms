package org.ib.practice.maths.excelcolumnnumber;

public class Test {
    public static void main(String[] args) {
        System.out.println(titleToNumber("Z"));
    }

    public static int titleToNumber(String A) {
        int columnNum = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            columnNum += (A.charAt(i) - 'A' + 1) * Math.pow(26, A.length() - i - 1);
        }
        return columnNum;
    }
}
