package org.ib.practice.backtracking.letterphone;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        System.out.println(letterCombinations("20"));
    }

    public static ArrayList<String> letterCombinations(String A) {
        HashMap<Character, String> letterMap = new HashMap<>();
        letterMap.put('0', "0");
        letterMap.put('1', "1");
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
        ArrayList<String> result = new ArrayList<>();
        letterCombinationsHelper(A, 0, result, "", letterMap);
        return result;
    }

    private static void letterCombinationsHelper(String a, int i, ArrayList<String> result, String sequence, HashMap<Character, String> letterMap) {
        if (i >= a.length()) {
            result.add(sequence);
            return;
        }
        for (Character c : letterMap.get(a.charAt(i)).toCharArray()) {
            letterCombinationsHelper(a, i + 1, result, sequence + c, letterMap);
        }
    }
}
