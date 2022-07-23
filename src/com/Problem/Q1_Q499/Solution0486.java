package com.Problem.Q1_Q499;

public class Solution0486 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        int max = 0;
        boolean flag = true;
        while (r < n) {
            if (nums[r] == 0 && flag == true) {
                flag = false;
            } else if (nums[r] == 0 && flag == false) {
                while (nums[l] != 0) {
                    l++;
                }
                l++;
            }
            max = Math.max(r - l + 1, max);
            r++;
        }
        return max;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int n = nums.length;
        int[][] opt = new int[n][2];
        opt[0][1] = 1;
        opt[0][0] = nums[0] == 0 ? 0 : 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 1) {
                opt[i][0] = opt[i - 1][0] + 1;
                opt[i][1] = opt[i - 1][1] + 1;
            } else {
                opt[i][1] = opt[i - 1][0] + 1;
                opt[i][0] = 0;
            }
            max = Math.max(max, Math.max(opt[i][0], opt[i][1]));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0486 s = new Solution0486();
        System.out.println(s.findMaxConsecutiveOnes2(new int[]{1, 0, 1, 1, 0}));
    }
}
