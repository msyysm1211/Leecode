package com.Problem.Q500_Q999;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0652_Find_Duplicate_Subtrees {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    String dfs(TreeNode root) {
        if (root == null) {
            return " ";
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(root.val + "_");
        buffer.append(dfs(root.left));
        buffer.append(dfs(root.right));
        String s = buffer.toString();
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            res.add(root);
        }
        return s;
    }
}
