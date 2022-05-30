package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        return DFS2(root, 0);
    }

    /* void DFS(TreeNode node, List<TreeNode> list) {
         if (node == null) {
             return;
         }
         if (node.left == null & node.right == null) {
             list.add(node);
             String s = "";
             for (TreeNode i : list) {
                 s += String.valueOf(i.val);
             }
             sum += Integer.valueOf(s);
             list.remove(list.size() - 1);
             return;
         }
         list.add(node);
         DFS(node.left, list);
         DFS(node.right, list);
         list.remove(list.size() - 1);
     }*/
    int DFS2(TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        }
        int sum = prevSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return DFS2(node.left, prevSum) + DFS2(node.right, prevSum);
    }

    public static void main(String args[]) {
        Solution0129 a = new Solution0129();
        TreeNode root = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(2);
        root.left = b;
        root.right = c;
        a.sumNumbers(root);
    }
}
