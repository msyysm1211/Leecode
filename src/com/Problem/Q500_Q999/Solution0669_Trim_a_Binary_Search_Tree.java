package com.Problem.Q500_Q999;

public class Solution0669_Trim_a_Binary_Search_Tree {
    int l, h;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        l = low;
        h = high;
        return dfs(root);
    }

    TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val > h) {
            return dfs(root.left);
        } else if (root.val < l) {
            return dfs(root.right);
        } else {
            root.left = dfs(root.left);
            root.right = dfs(root.right);
            return root;
        }
    }
}
