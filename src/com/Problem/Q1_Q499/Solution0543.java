package com.Problem.Q1_Q499;

import java.util.Map;

public class Solution0543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max - 1;
    }

    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(right, left) + 1;
    }
}
