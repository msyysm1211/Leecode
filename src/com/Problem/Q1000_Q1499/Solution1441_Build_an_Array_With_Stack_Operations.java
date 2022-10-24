package com.Problem.Q1000_Q1499;

import java.util.ArrayList;
import java.util.List;

public class Solution1441_Build_an_Array_With_Stack_Operations {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < target.length; i++) {
            if (index == target[i]) {
                res.add("Push");
                index++;
            } else {
                while (index != target[i]) {
                    res.add("Push");
                    res.add("Pop");
                    index++;
                }
                res.add("Push");
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1441_Build_an_Array_With_Stack_Operations s = new Solution1441_Build_an_Array_With_Stack_Operations();
        System.out.println(s.buildArray(new int[]{2, 3, 4}, 4));
    }

}
