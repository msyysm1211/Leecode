package com.Problem.Q1_Q499;

import java.util.HashMap;

public class Solution0337 {
    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        int[] res = dfs2(root);
        return Math.max(res[0], res[1]);
    }

    int[] dfs2(TreeNode root) {
        if (root == null) return new int[2];
        int[] cnt = new int[2];
        int[] left = dfs2(root.left);
        int[] right = dfs2(root.right);
        cnt[0] = left[1] + right[1] + root.val;
        cnt[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return cnt;
    }

    //    int dfs(TreeNode root, boolean flag) {
//        if (root == null) {
//            return 0;
//        }
//        int count = 0;
//        int count2 = 0;
//        if (flag == true) {
//            count += root.val;
//            count += dfs(root.right, false);
//            count += dfs(root.left, false);
//
//            count2 += dfs(root.right, true);
//            count2 += dfs(root.left, true);
//
//        } else {
//            count += dfs(root.right, true);
//            count += dfs(root.left, true);
//        }
//        return Math.max(count, count2);
//    }
    int dfs(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int count = root.val;
        if (root.left != null) {
            count += (dfs(root.left.right) + dfs(root.left.left));
        }
        if (root.right != null) {
            count += (dfs(root.right.right) + dfs(root.right.left));
        }
        int res = Math.max(count, dfs(root.left) + dfs(root.right));
        map.put(root, res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(3);
        root.left = root2;
        root2.left = root3;
        root3.left = root4;
        Solution0337 s = new Solution0337();
        int a = s.rob(root);
        System.out.println(a);
    }
}
