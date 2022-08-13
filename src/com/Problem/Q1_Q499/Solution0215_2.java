package com.Problem.Q1_Q499;

public class Solution0215_2 {
    public int findKthLargest(int[] nums, int k) {
        buildheap(nums, nums.length);
        int size = nums.length;
        for (int i = nums.length - 1; i >= nums.length + 1 - k; i--) {
            swap(nums, 0, i);
            size--;
            heapify(nums, 0, size);
        }
        return nums[0];
    }

    void buildheap(int[] nums, int size) {
        for (int i = 0; i < size / 2 - 1; i++) {
            heapify(nums, i, size);
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[b] = nums[a];
        nums[a] = temp;
    }

    void heapify(int[] nums, int parent, int size) {
        int l = parent * 2 + 1;
        int r = parent * 2 + 2;
        int bigger = parent;
        if (l < size && nums[l] > nums[bigger]) {
            bigger = l;
        }
        if (r < size && nums[r] > nums[bigger]) {
            bigger = r;
        }
        if (bigger != parent) {
            swap(nums, bigger, parent);
            heapify(nums, bigger, size);
        }
    }


    public static void main(String[] args) {
        Solution0215 s = new Solution0215();
        int t = s.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(t);
    }
}
