package com.Problem.Q1_Q499;

import java.util.Arrays;

public class Solution0238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int sum = 1;
        int[] res = new int[n];
        int count0 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                sum *= nums[i];
            } else {
                count0++;
            }
        }
        if (count0 == 0) {
            for (int i = 0; i < n; i++) {
                res[i] = sum / nums[i];
            }
        } else if (count0 == 1) {
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    res[i] = 0;
                } else {
                    res[i] = sum;
                }
            }
        } else {
            Arrays.fill(res, 0);
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = r * res[i];
            r *= nums[i];
        }
        return res;
    }
}
