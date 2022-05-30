package com.Problem.Q1_Q499;

import com.sun.source.tree.TreeVisitor;

import java.util.ArrayList;
import java.util.List;

// 3 2 1
public class Solution0099 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        DFS(root, list);
        TreeNode x = null;
        TreeNode pre = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                x = list.get(i + 1);
                if (pre == null) {
                    pre = list.get(i);
                }
            }
        }
        if (x != null & pre != null) {
            int temp = 0;
            temp = x.val;
            x.val = pre.val;
            pre.val = temp;
        }
    }

    void DFS(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        DFS(root.left, list);
        list.add(root);
        DFS(root.right, list);
    }

    public static void main(String args[]) {
        Solution0099 a = new Solution0099();
        TreeNode root = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(2);
        root.left = b;
        b.right = c;
        a.recoverTree(root);
    }
}
