package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0451_Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        char[] arrs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < arrs.length; i++) {
            map.put(arrs[i], map.getOrDefault(arrs[i], 0) + 1);
        }
        StringBuffer buffer = new StringBuffer();
        List<Character> rank = new ArrayList<>(map.keySet());
        Collections.sort(rank, (a, b) -> {
            return map.get(b) - map.get(a);
        });
        for (int i = 0; i < rank.size(); i++) {
            char c = rank.get(i);
            int num = map.get(c);
            for (int j = 0; j < num; j++) {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }
}
