package com.Problem.Q500_Q999;

import java.util.Map;

public class Solution0654Maximum_Binary_Tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    TreeNode helper(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int max = 0;
        int maxindex = start;
        for (int i = start; i < end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxindex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, maxindex);
        root.right = helper(nums, maxindex + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Solution0654Maximum_Binary_Tree s = new Solution0654Maximum_Binary_Tree();
        s.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
