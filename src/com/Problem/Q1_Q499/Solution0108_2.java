package com.Problem.Q1_Q499;

public class Solution0108_2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);

    }

    TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Solution0108_2 s = new Solution0108_2();
        s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
