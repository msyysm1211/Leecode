package com.Problem.Q500_Q999;

import java.util.ArrayList;
import java.util.List;

public class Solution0784 {
    List<String> res = new ArrayList<String>();

    public List<String> letterCasePermutation(String s) {
        DFS(s.toCharArray(), 0);
        return res;
    }

    void DFS(char[] arr, int index) {
        if (index == arr.length) {
            res.add(new String(arr.toString()));
            return;
        }
        DFS(arr, index + 1);
        if (Character.isLetter(arr[index])) {
            arr[index] ^= 1 << 5;
            DFS(arr, index + 1);
        }
    }
}
