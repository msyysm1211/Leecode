package com.Problem.Q1_Q499;

public class Solution0110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(gethigh(root.left) - gethigh(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    int gethigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(gethigh(root.left), gethigh(root.right)) + 1;
    }
}
