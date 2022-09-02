package com.Problem.Q1_Q499;


import com.Problem.Q1_Q499.StringToTreeNode;

public class Solution0450_Delete_Node_in_a_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val > key) {
            root.left = deleteNode(root.left, key);
        } else if (val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode newroot = root.right;
            while (newroot.left != null) {
                newroot = newroot.left;
            }
            newroot.right = deleteNode(root.right, newroot.val);
            newroot.left = root.left;
            return newroot;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution0450_Delete_Node_in_a_BST s = new Solution0450_Delete_Node_in_a_BST();
        StringToTreeNode t = new StringToTreeNode();
        s.deleteNode(t.stringToTreeNode("[5,3,6,2,4,null,7]"), 5);
    }
}
