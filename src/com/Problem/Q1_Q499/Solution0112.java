package com.Problem.Q1_Q499;

//112. Path Sum
public class Solution0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return check(root, targetSum);
    }

    boolean check(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.left == null) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = check(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            right = check(root.right, targetSum - root.val);
        }
        if (left || right) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Solution0112 a = new Solution0112();
        TreeNode root = new TreeNode(-2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(-3);
        root.left = null;
        root.right = c;
        System.out.println(a.hasPathSum(root, -2));
    }
}
