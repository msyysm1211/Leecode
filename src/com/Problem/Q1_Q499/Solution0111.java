package com.Problem.Q1_Q499;

public class Solution0111 {
    public int minDepth(TreeNode root) {
        return check(root);
    }

    int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(check(root.left), check(root.right)) + 1;
        }
    }
}
