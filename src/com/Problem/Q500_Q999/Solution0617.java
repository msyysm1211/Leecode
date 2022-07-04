package com.Problem.Q500_Q999;


public class Solution0617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return DFS(root1, root2);
    }

    TreeNode DFS(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return root1;
        } else if (root1 == null) {
            return root2;
        }
        TreeNode node = new TreeNode();
        node.val = root1.val + root2.val;
        node.left = DFS(root1.left, root2.left);
        node.right = DFS(root1.right, root2.right);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
