package org.ib.practice.hashing.foursum;

import java.util.*;

public class Test {
    static class Pair implements Comparable<Pair> {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public int compareTo(Pair other) {
            return i != other.i ? Integer.compare(i, other.i)
                    : Integer.compare(j, other.j);
        }
    }

    public static void main(String[] args) {
        fourSum(new ArrayList<>(Arrays.asList(1, 0, -1, 0, -2, 2)), 0).forEach(System.out::println);
    }

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<Integer, TreeSet<Pair>> hashMap = new HashMap<>();
        Collections.sort(A);
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (hashMap.containsKey(A.get(i) + A.get(j))) {
                    hashMap.get(A.get(i) + A.get(j)).add(new Pair(i, j));
                } else hashMap.put(A.get(i) + A.get(j), new TreeSet<>(Arrays.asList(new Pair(i, j))));
            }
        }
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (hashMap.containsKey(B - (A.get(i) + A.get(j)))) {
                    TreeSet<Pair> possiblePairs = hashMap.get(B - (A.get(i) + A.get(j)));
                    for (Pair possiblePair : possiblePairs) {
                        if (possiblePair.i == i || possiblePair.j == i || possiblePair.i == j || possiblePair.j == j)
                            continue;
                        ArrayList<Integer> fourSumPair = new ArrayList<>(Arrays.asList(A.get(i), A.get(j), A.get(possiblePair.i), A.get(possiblePair.j)));
                        Collections.sort(fourSumPair);
                        boolean isFourPairAlreadyPresent = false;
                        for (ArrayList<Integer> curFourSumPair : res) {
                            if (curFourSumPair.equals(fourSumPair))
                                isFourPairAlreadyPresent = true;
                        }
                        if (!isFourPairAlreadyPresent)
                            res.add(fourSumPair);
                    }
                }
            }
        }
        return res;
    }
}
