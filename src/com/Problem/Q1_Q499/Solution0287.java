package com.Problem.Q1_Q499;

public class Solution0287 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int pre = 0;
        while (pre != slow) {
            pre = nums[pre];
            slow = nums[slow];
        }
        return slow;
    }
}
