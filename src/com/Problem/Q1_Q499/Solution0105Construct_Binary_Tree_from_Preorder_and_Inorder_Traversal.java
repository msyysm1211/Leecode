package com.Problem.Q1_Q499;

public class Solution0105Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    TreeNode helper(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if (prestart == preend) {
            return null;
        }
        int val = preorder[prestart];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = instart; i < inend; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }//找到中序遍历根节点位置
        int leftnum = index - instart;
        root.left = helper(preorder, inorder, prestart + 1, prestart + 1 + leftnum, instart, index);
        root.right = helper(preorder, inorder, prestart + 1 + leftnum, preend, index + 1, inend);
        return root;
    }

    public static void main(String[] args) {
        Solution0105Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal s = new Solution0105Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        System.out.println(s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

}