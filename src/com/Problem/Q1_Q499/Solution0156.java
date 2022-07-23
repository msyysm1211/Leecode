package com.Problem.Q1_Q499;

public class Solution0156 {
    TreeNode head = null;

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return null;
        dfs(root);
        return head;
    }

    TreeNode dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            head = root;
            return root;
        }
        TreeNode newroot = dfs(root.left);
        newroot.right = root;
        newroot.left = root.right;
        root.left = null;
        root.right = null;
        return newroot.right;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node3;
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        Solution0156 s = new Solution0156();
        s.upsideDownBinaryTree(node1);
    }
}
