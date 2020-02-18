package org.ib.practice.hashing.anagramgroups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(anagrams(Arrays.asList("aabbba", "baaabb", "aabaab")));
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        boolean[] toSkipString = new boolean[A.size()];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (toSkipString[i])
                continue;
            HashMap<Character, Integer> map = new HashMap<>();
            for (Character c : A.get(i).toCharArray()) {
                if (map.containsKey(c))
                    map.put(c, map.get(c) + 1);
                else map.put(c, 1);
            }
            ArrayList<Integer> grp = new ArrayList<>(Arrays.asList(i + 1));
            for (int j = i + 1; j < A.size(); j++) {
                HashMap<Character, Integer> temp = new HashMap<>(map);
                boolean addToGrp = true;
                for (Character c : A.get(j).toCharArray()) {
                    if (!temp.containsKey(c)) {
                        addToGrp = false;
                        break;
                    }
                    if (temp.get(c) == 1) {
                        temp.remove(c);
                    } else
                        temp.put(c, temp.get(c) - 1);
                }
                if (!addToGrp || !temp.isEmpty())
                    addToGrp = false;
                if (addToGrp) {
                    grp.add(j + 1);
                    toSkipString[j] = true;
                }
            }
            res.add(grp);
        }
        return res;
    }
}
