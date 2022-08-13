package com.Problem.Q500_Q999;

import java.util.HashMap;
import java.util.Map;

public class Solution0560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = nums.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum - k, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution0560 s = new Solution0560();
        int t = s.subarraySum(new int[]{}, 0);
        System.out.println(t);
    }
}
