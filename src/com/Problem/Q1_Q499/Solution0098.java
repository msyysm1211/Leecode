package com.Problem.Q1_Q499;

public class Solution0098 {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean check(TreeNode node, Long lower, Long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return check(node.left, lower, Long.valueOf(node.val)) && check(node.right, Long.valueOf(node.val), upper);
    }
}
