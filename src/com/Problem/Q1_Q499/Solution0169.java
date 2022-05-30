package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.Map;

public class Solution0169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int maxcount = Integer.MIN_VALUE / 2;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxcount) {
                maxcount = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        int res;
        int count = 0;
        int candidate = -1;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String args[]) {
        Solution0169 s = new Solution0169();
        s.majorityElement2(new int[]{1, 2, 2});
    }
}
