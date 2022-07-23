package com.Problem.Q500_Q999;

public class Solution0977 {
    public int[] sortedSquares(int[] nums) {
        int zeropoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                zeropoint = i;
            } else break;
        }
        int neg = zeropoint, pos = zeropoint + 1;
        int[] res = new int[nums.length];
        int index = 0;
        while (neg >= 0 || pos < nums.length) {
            if (neg < 0) {
                res[index] = nums[pos] * nums[pos];
                pos++;
            } else if (pos == nums.length) {
                res[index] = nums[neg] * nums[neg];
                neg--;
            } else if (nums[neg] * nums[neg] > nums[pos] * nums[pos]) {
                res[index] = nums[pos] * nums[pos];
                pos++;
            } else if (nums[neg] * nums[neg] <= nums[pos] * nums[pos]) {
                res[index] = nums[neg] * nums[neg];
                neg--;
            }
            index++;
        }
        return res;
    }

    public static void main(String args[]) {
        Solution0977 s = new Solution0977();
        //s.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        s.sortedSquares(new int[]{-1});
    }
}
