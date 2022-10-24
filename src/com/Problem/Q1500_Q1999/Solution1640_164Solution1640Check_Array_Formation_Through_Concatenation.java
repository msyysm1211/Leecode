package com.Problem.Q1500_Q1999;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1640_164Solution1640Check_Array_Formation_Through_Concatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> set = new HashMap<>();
        for (int[] piece : pieces) {
            set.put(piece[0], piece);
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.containsKey(arr[i])) {
                int[] nums = set.get(arr[i]);
                int n = nums.length;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == arr[i]) {
                        i++;
                    } else {
                        return false;
                    }
                }
                i--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1640_164Solution1640Check_Array_Formation_Through_Concatenation s = new Solution1640_164Solution1640Check_Array_Formation_Through_Concatenation();
        System.out.println(s.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
    }

}
