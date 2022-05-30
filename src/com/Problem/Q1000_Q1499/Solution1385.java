package com.Problem.Q1000_Q1499;

import com.Problem.Q500_Q999.Solution0704;

import java.util.Arrays;

public class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0;
        for (int i : arr1) {
            int p = findmindistance(arr2, i);
            boolean res = true;
            if (p < arr2.length) {
                res &= arr2[p] - i > d;
            }
            if (p - 1 >= 0 && p - 1 < arr2.length) {
                res &= i - arr2[p - 1] > d;
            }
            cnt += res ? 1 : 0;
        }
        return cnt;
    }

    int findmindistance(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        if (arr[r] < target) {
            return r + 1;
        }
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        Solution1385 a = new Solution1385();
        int t = a.findTheDistanceValue(new int[]{4, 5, 8}, new int[]{1, 8, 9, 10}, 2);
        System.out.println(t);
    }
}
