package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution0136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count + 1);
            }
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }

    public static void main(String args[]) {
        Solution0136 s = new Solution0136();
        s.singleNumber(new int[]{4, 1, 2, 1, 2});
    }
}
