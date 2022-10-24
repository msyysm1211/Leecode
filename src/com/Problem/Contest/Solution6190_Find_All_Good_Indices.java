package com.Problem.Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution6190_Find_All_Good_Indices {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i])
                dp1[i] = dp1[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1])
                dp2[i] = dp2[i + 1] + 1;
        }
        for (int i = k; i < n - k; i++) {
            if (dp1[i - 1] >= k && dp2[i + 1] >= k) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution6190_Find_All_Good_Indices s = new Solution6190_Find_All_Good_Indices();
        System.out.println(s.goodIndices(new int[]{2, 1, 3}, 1));
    }

}
