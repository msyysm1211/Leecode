package com.Problem.Q1000_Q1499;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1460_Make_Two_Arrays_Equal_by_Reversing_Sub_arrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : target) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : arr) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        return map.equals(map2);
    }

    public boolean canBeEqual2(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(arr, target);
    }

    public static void main(String[] args) {
        Solution1460_Make_Two_Arrays_Equal_by_Reversing_Sub_arrays s = new Solution1460_Make_Two_Arrays_Equal_by_Reversing_Sub_arrays();
        s.canBeEqual2(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3});
    }
}
