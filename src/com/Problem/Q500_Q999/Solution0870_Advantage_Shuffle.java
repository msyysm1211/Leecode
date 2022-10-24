package com.Problem.Q500_Q999;

import java.util.Arrays;

public class Solution0870_Advantage_Shuffle {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Integer[] index2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            index2[i] = i;
        }
        Arrays.sort(index2, (o1, o2) -> nums2[o1] - nums2[o2]);
        Arrays.sort(nums1);
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[i] > nums2[index2[l]]) {
                res[index2[l]] = nums1[i];
                l++;
            } else {
                res[index2[r]] = nums1[i];
                r--;
            }
        }
        return res;
    }

    public int[] advantageCount2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx = new Integer[n]; // nums2索引
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(nums1);
        Arrays.sort(idx, (i, j) -> nums2[i] - nums2[j]); //根据nums2数据升序，排序nums2(索引)
        int L = 0, R = n - 1; // nums2(索引)的左右指针
        for (int i : nums1) { // 遍历nums1
            if (i > nums2[idx[L]]) nums2[idx[L++]] = i; // 可以满足 nums1[i] > nums2[i]
            else nums2[idx[R--]] = i; //丢到数组最后
        }
        return nums2;
    }

    public static void main(String[] args) {
        Solution0870_Advantage_Shuffle s = new Solution0870_Advantage_Shuffle();
        System.out.println(s.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}));
    }

}
