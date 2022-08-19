package com.Problem.Q1_Q499;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution0378_KthSmallest_Element_in_a_Sorted_Matrix {

    public int kthSmallest(int[][] matrix, int k) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] temp = queue.poll();
            if (temp[2] != n - 1) {
                queue.add(new int[]{matrix[temp[1]][temp[2] + 1], temp[1], temp[2] + 1});
            }
        }
        return queue.poll()[0];
    }


    public static void main(String[] args) {
        Solution0378_KthSmallest_Element_in_a_Sorted_Matrix s = new Solution0378_KthSmallest_Element_in_a_Sorted_Matrix();
        stringToArray t = new stringToArray();
        int[][] arr = t.stringToInt2dArray("[[1,5,9],[10,11,13],[12,13,15]]");
        System.out.println(s.kthSmallest(arr, 8));
    }

}
