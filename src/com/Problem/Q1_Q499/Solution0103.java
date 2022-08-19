package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            Deque<Integer> temp = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    temp.offerFirst(node.val);
                } else {
                    temp.offerLast(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0103 s = new Solution0103();
        StringToTreeNode st = new StringToTreeNode();
        s.zigzagLevelOrder(st.stringToTreeNode("[3,9,20,null,null,15,7]"));
    }
}
