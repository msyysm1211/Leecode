package com.Problem.Q1_Q499;

import java.lang.reflect.Array;
import java.util.*;

public class Solution0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        String strs2[] = strs;
        Map<String, List<String>> res = new HashMap<String, List<String>>();
        for (String s : strs2) {
            char temp[] = s.toCharArray();
            Arrays.sort(temp);
            String s2 = new String(temp);
            List<String> oneresult = res.getOrDefault(s2, new ArrayList<String>());
            oneresult.add(s);
            res.put(s2, oneresult);
        }
        return new ArrayList<List<String>>(res.values());
    }
}
