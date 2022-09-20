package com.Problem.Q1_Q499;

public class Solution0215_test {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length - 1;
        buildheap(nums, n);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, n);
            n--;
        }
        return nums[0];
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    void buildheap(int[] nums, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(nums, i, size);
        }
    }

    void heapify(int[] nums, int parent, int size) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int bigger = parent;
        if (left < size && nums[left] > nums[bigger]) {
            bigger = left;
        }
        if (right < size && nums[right] > nums[bigger]) {
            bigger = right;
        }
        if (bigger != parent) {
            swap(nums, bigger, parent);
            heapify(nums, parent, size);
        }
    }

    public static void main(String[] args) {
        Solution0215_test s = new Solution0215_test();
        int t = s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(t);
    }
}
