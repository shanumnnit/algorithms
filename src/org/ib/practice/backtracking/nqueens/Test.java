package org.ib.practice.backtracking.nqueens;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> result = solveNQueens(4);
        result.forEach(x -> {
            x.forEach(System.out::println);
            System.out.println();
        });
    }

    public static ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Integer[][] matrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], 0);
        }
        solveNQueensHelper(deepCopy(matrix), n, 0, result);
        return result;
    }

    private static void solveNQueensHelper(Integer[][] matrix, int n, int row, ArrayList<ArrayList<String>> result) {
        if (row >= n) {
            addToResult(matrix, n, result);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (matrix[row][j] == 0) {
                Integer[][] copiedMatrix = deepCopy(matrix);
                markOccupied(copiedMatrix, row, j);
                copiedMatrix[row][j] = 2;
                solveNQueensHelper(copiedMatrix, n, row + 1, result);
            }
        }
    }

    static <T> T[][] deepCopy(T[][] matrix) {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }

    private static void markOccupied(Integer[][] matrix, int row, int col) {
        //vertical
        for (int i = 0, j = col; isValidIndex(i, j, matrix.length); i++) {
            if (matrix[i][j] == 0) matrix[i][j] = 1;
        }
        //horizontal
        for (int i = row, j = 0; isValidIndex(i, j, matrix.length); j++) {
            if (matrix[i][j] == 0) matrix[i][j] = 1;
        }
        //upper left diagonal
        for (int i = row - 1, j = col - 1; isValidIndex(i, j, matrix.length); i--, j--) {
            if (matrix[i][j] == 0) matrix[i][j] = 1;
        }
        //upper right diagonal
        for (int i = row - 1, j = col + 1; isValidIndex(i, j, matrix.length); i--, j++) {
            if (matrix[i][j] == 0) matrix[i][j] = 1;
        }
        //lower left diagonal
        for (int i = row + 1, j = col - 1; isValidIndex(i, j, matrix.length); i++, j--) {
            if (matrix[i][j] == 0) matrix[i][j] = 1;
        }
        //lower right diagonal
        for (int i = row + 1, j = col + 1; isValidIndex(i, j, matrix.length); i++, j++) {
            if (matrix[i][j] == 0) matrix[i][j] = 1;
        }
    }

    private static boolean isValidIndex(int i, int j, int length) {
        if (i >= 0 && i < length && j >= 0 && j < length)
            return true;
        return false;
    }

    private static void addToResult(Integer[][] matrix, int n, ArrayList<ArrayList<String>> result) {
        ArrayList<String> curRes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2)
                    sb.append('Q');
                else sb.append('.');
            }
            curRes.add(sb.toString());
        }
        result.add(curRes);
    }
}
