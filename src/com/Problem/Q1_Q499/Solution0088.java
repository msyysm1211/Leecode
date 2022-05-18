package com.Problem.Q1_Q499;

import java.util.Arrays;
import java.util.List;

public class Solution0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int arr[] = new int[m + n];
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                arr[p1 + p2] = nums2[p2];
                p2++;
            } else if (p2 == n) {
                arr[p1 + p2] = nums1[p1];
                p1++;
            } else if (nums1[p1] < nums2[p2]) {
                arr[p1 + p2] = nums1[p1];
                p1++;
            } else {
                arr[p1 + p2] = nums1[p2];
                p2++;
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = arr[i];
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int arr[] = new int[m + n];
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                arr[p1 + p2 + 1] = nums2[p2];
                p2--;
            } else if (p2 == -1) {
                arr[p1 + p2 + 1] = nums1[p1];
                p1--;
            } else if (nums1[p1] > nums2[p2]) {
                arr[p1 + p2 + 1] = nums1[p1];
                p1--;
            } else {
                arr[p1 + p2 + 1] = nums2[p2];
                p2--;
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = arr[i];
        }
    }

    public static void main(String args[]) {
        Solution0088 a = new Solution0088();
        a.merge3(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
