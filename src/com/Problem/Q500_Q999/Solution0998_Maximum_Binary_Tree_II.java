package com.Problem.Q500_Q999;

public class Solution0998_Maximum_Binary_Tree_II {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
