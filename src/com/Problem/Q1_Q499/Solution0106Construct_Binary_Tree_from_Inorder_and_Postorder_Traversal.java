package com.Problem.Q1_Q499;

public class Solution0106Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    TreeNode dfs(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        if (instart == inend) {
            return null;
        }
        int root_val = postorder[postend - 1];
        TreeNode root = new TreeNode(root_val);
        int position = 0;
        for (int i = instart; i < inend; i++) {
            if (inorder[i] == root_val) {
                position = i;
                break;
            }
        }
        int leftnum = position - instart;
        root.left = dfs(inorder, postorder, instart, position, poststart, poststart + leftnum);
        root.right = dfs(inorder, postorder, position + 1, inend, leftnum + poststart, postend - 1);
        return root;
    }
}
