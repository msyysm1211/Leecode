package com.Problem.Q500_Q999;

import java.util.ArrayList;
import java.util.List;

public class Solution0658_Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int l = 0, r = n - k;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
