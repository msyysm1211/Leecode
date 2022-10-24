package com.Problem.Q500_Q999;

public class Solution0538_Convert_BST_to_Greater_Tree {
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    int dfs(TreeNode root, int presum) {
        if (root == null) {
            return presum;
        }
        int sum = 0;
        if (root.right != null) {
            sum += dfs(root.right, presum);
        }
        sum += root.val;
        root.val = presum + sum;
        if (root.left != null) {
            sum += dfs(root.left, presum + sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution0538_Convert_BST_to_Greater_Tree s = new Solution0538_Convert_BST_to_Greater_Tree();
        StringtoTreeNode t = new StringtoTreeNode();
        System.out.println(s.convertBST(t.stringToTreeNode("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]")));
    }

}
