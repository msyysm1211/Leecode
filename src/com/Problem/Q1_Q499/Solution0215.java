package com.Problem.Q1_Q499;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution0215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        int t = nums.length - k;
        for (int num : nums) {
            queue.offer(num);
        }
        int res = 0;
        for (int i = 0; i <= t; i++) {
            res = queue.poll();
        }
        return res;
    }

    public int findKthLargest2(int[] nums, int k) {
        int size = nums.length;
        buildheap(nums, size);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            size--;
            heapifyup(nums, 0, size);
        }
        return nums[0];
    }

    void buildheap(int[] nums, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapifyup(nums, i, size);
        }
    }

    void heapifyup(int nums[], int parent, int size) {
        int leftchild = parent * 2 + 1;
        int rightchild = parent * 2 + 2;
        int bigger = parent;
        if (leftchild < size && nums[bigger] < nums[leftchild]) {
            bigger = leftchild;
        }
        if (rightchild < size && nums[bigger] < nums[rightchild]) {
            bigger = rightchild;
        }
        if (bigger != parent) {
            swap(nums, parent, bigger);
            heapifyup(nums, bigger, size);
        }
    }

    void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution0215 s = new Solution0215();
        int t = s.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(t);
    }
}

