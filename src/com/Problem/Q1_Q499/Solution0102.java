package com.Problem.Q1_Q499;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }

    TreeNode transfer(String s) {
        int length = s.length();
        String temp = s.substring(1, length - 1);
        System.out.println(temp);
        String[] arr = temp.split(",");
        TreeNode[] arrs = new TreeNode[arr.length];
        for (int i = 0; i < arrs.length; i++) {
            if (!arr[i].equals("null")) {
                arrs[i] = new TreeNode(Integer.parseInt(arr[i]));
            } else {
                arrs[i] = null;
            }
        }
        int n = arrs.length;
        for (int i = 0; i < n; i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (left < n) {
                arrs[i].left = arrs[left];
            }
            if (right < n) {
                arrs[i].right = arrs[right];
            }
        }
        return arrs[0];
    }

    public static void main(String[] args) {
        Solution0102 s = new Solution0102();
        StringToTreeNode t = new StringToTreeNode();
        TreeNode test = t.stringToTreeNode("[3,9,20,null,null,15,7]");
        s.levelOrder(test);
    }
}