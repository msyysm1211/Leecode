package com.Problem.Q500_Q999;

import java.util.*;

public class Solution0658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - k;

        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        int move = arr.length - k;
        while (move > 0) {
            if (x - arr[l] <= arr[r] - x) {
                r--;
            } else {
                l++;
            }
            move--;
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String args[]) {
        Solution0658 a = new Solution0658();
        a.findClosestElements(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, 5);
    }
}
