package com.Problem.Q1_Q499;

public class Solution0215_2 {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        buildheap(nums, size);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            size--;
            heapify(nums, 0, size);
        }
        return nums[0];
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    void buildheap(int[] nums, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(nums, i, size);
        }
    }

    void heapify(int[] nums, int parent, int size) {
        int lchild = parent * 2 + 1;
        int rchild = parent * 2 + 2;
        int bigger = parent;
        if (lchild < size && nums[lchild] > nums[bigger]) {
            bigger = lchild;
        }
        if (rchild < size && nums[rchild] > nums[bigger]) {
            bigger = rchild;
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
