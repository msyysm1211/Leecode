package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i : nums1) {
            if (map.containsKey(i) && map.get(i) >= 1) {
                res.add(i);
                int count = map.get(i);
                map.put(i, count--);
            }
        }
        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
