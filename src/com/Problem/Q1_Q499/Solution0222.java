package com.Problem.Q1_Q499;

import com.sun.source.tree.Tree;

public class Solution0222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.right) + countNodes(root.left) + 1;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int left = 2 << (level - 1);
        int right = (2 << level) - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (exist(root, level, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    boolean exist(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

    public static void main(String[] args) {
        Solution0222 s = new Solution0222();
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        System.out.println(s.countNodes2(root));
    }
}
