package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.Map;

public class Solution0325 {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int presum = 0;
        map.put(0, -1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            if (!map.containsKey(presum)) {
                map.put(presum, i);
            } else {
                int t = map.get(presum);
                int min = Math.min(t, i);
                map.put(presum, min);
            }
            if (map.containsKey(presum - k)) {
                ans = Math.max(ans, i - map.get(presum - k));
            }
        }
        return ans;
    }

    public int maxSubArrayLen2(int[] nums, int k) {
        int n = nums.length;
        // 哈希表，映射前缀和值到第一次出现的下标位置
        Map<Integer, Integer> preSumIndex = new HashMap<>();
        int ans = 0;
        // 前缀和
        int preSum = 0;
        // 0 出现的位置在 -1 位置处
        preSumIndex.put(0, -1);
        for (int i = 0; i < n; ++i) {
            // 累加前缀和
            preSum += nums[i];
            // 确保记录的是第一次出现的位置
            if (!preSumIndex.containsKey(preSum)) {
                preSumIndex.put(preSum, i);
            }
            // 检查一下是否需要更新答案
            if (preSumIndex.containsKey(preSum - k)) {
                ans = Math.max(ans, i - preSumIndex.get(preSum - k));
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution0325 s = new Solution0325();
        int t = s.maxSubArrayLen(new int[]{1, 1, 1, -1, 4}, 4);
        System.out.println(t);
    }
}
