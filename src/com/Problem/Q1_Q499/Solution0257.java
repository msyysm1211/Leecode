package com.Problem.Q1_Q499;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class Solution0257 {
    List<String> res = new ArrayList<String>();
    //StringBuffer path = new StringBuffer();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    void dfs(TreeNode node, String route) {
        if (node != null) {
            StringBuffer path = new StringBuffer(route);
            path.append(node.val);
            if (node.right == null && node.left == null) {
                res.add(path.toString());
                return;
            }
            path.append("->");
            if (node.left != null) {
                dfs(node.left, path.toString());
            }
            if (node.right != null) {
                dfs(node.right, path.toString());
            }
        }
    }

    public static void main(String[] args) {
        Solution0257 s = new Solution0257();
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root2.right = root4;
        s.binaryTreePaths(root);
    }
}
