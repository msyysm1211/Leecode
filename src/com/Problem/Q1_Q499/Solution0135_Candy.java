package com.Problem.Q1_Q499;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution0135_Candy {
    public int candy(int[] ratings) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = ratings.length;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return ratings[0] == ratings[1] ? 2 : 3;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            minheap.add(new int[]{ratings[i], i});
        }
        for (int i = 0; i < n; i++) {
            int[] cur = minheap.poll();
            int index = cur[1];
            int value = cur[0];
            if (index - 1 >= 0 && index + 1 < n) {
                if (arr[index - 1] == 0 && arr[index + 1] == 0) {
                    arr[index] = 1;
                } else {
                    if (ratings[index] == ratings[index - 1] && ratings[index] > ratings[index + 1]) {
                        arr[index] = arr[index + 1] + 1;
                    } else if (ratings[index] == ratings[index - 1] && ratings[index] <= ratings[index + 1]) {
                        arr[index] = 1;
                    } else if (ratings[index] == ratings[index + 1] && ratings[index - 1] < ratings[index]) {
                        arr[index] = arr[index - 1] + 1;
                    } else if (ratings[index] == ratings[index + 1] && ratings[index - 1] >= ratings[index]) {
                        arr[index] = 1;
                    } else {
                        arr[index] = Math.max(arr[index - 1], arr[index + 1]) + 1;
                    }
                }
            } else if (index - 1 < 0) {
                arr[index] = arr[index + 1] + 1;
            } else {
                arr[index] = arr[index - 1] + 1;
            }
        }
        int sum = Arrays.stream(arr).sum();
        return sum;
    }

    public int candy2(int[] ratings) {
        int n = ratings.length;
        int[] arrs = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                arrs[i] = arrs[i - 1] + 1;
            } else {
                arrs[i] = 1;
            }
        }
        int right = 0;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            res += Math.max(right, arrs[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0135_Candy s = new Solution0135_Candy();
        System.out.println(s.candy2(new int[]{1, 3, 4, 5, 2}));
    }

}
