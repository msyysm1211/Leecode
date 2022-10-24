package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution0373_Find_K_Pairs_with_Smallest_Sums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums2[o1[1]] - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < m; i++) {
            heap.add(new int[]{i, 0});
        }
        while (k > 0 && !heap.isEmpty()) {
            int[] top = heap.poll();
            List<Integer> list = new ArrayList();
            list.add(nums1[top[0]]);
            list.add(nums2[top[1]]);
            res.add(list);
            if (top[1] + 1 < n)
                heap.add(new int[]{top[0], top[1] + 1});
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0373_Find_K_Pairs_with_Smallest_Sums s = new Solution0373_Find_K_Pairs_with_Smallest_Sums();
        System.out.println(s.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 3));
    }

}
