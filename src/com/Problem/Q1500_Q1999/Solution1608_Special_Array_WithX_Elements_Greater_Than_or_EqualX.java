package com.Problem.Q1500_Q1999;

import java.util.Arrays;
import java.util.Collections;

public class Solution1608_Special_Array_WithX_Elements_Greater_Than_or_EqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            int num = n - i;
            if (num <= nums[i] && (num == n || nums[i - 1] < num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1608_Special_Array_WithX_Elements_Greater_Than_or_EqualX s = new Solution1608_Special_Array_WithX_Elements_Greater_Than_or_EqualX();
        System.out.println(s.specialArray(new int[]{3, 5}));
    }

}
