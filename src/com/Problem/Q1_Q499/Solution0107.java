package com.Problem.Q1_Q499;

import java.util.*;

class Solution0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Stack<List<Integer>> res = new Stack<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        int n = res.size();
        for (int i = 0; i < n; i++) {
            ans.add(res.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution0107 s = new Solution0107();
        StringToTreeNode test = new StringToTreeNode();
        System.out.println(s.levelOrderBottom(test.stringToTreeNode("[3,9,20,null,null,15,7]")));
    }
}