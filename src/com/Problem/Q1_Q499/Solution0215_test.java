package com.Problem.Q1_Q499;

public class Solution0215_test {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        build(nums, size);
        for (int i = nums.length - 1; i >= nums.length + 1 - k; i--) {
            swap(nums, 0, i);
            size--;
            heapify(nums, size, 0);
        }
        return nums[0];
    }


    void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    void build(int[] nums, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(nums, size, i);
        }
    }

    void heapify(int[] nums, int size, int parent) {
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
            heapify(nums, size, bigger);
        }
    }

    public static void main(String[] args) {
        Solution0215_test s = new Solution0215_test();
        int t = s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(t);
    }
}
