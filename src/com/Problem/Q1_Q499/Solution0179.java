package com.Problem.Q1_Q499;

import java.lang.reflect.Array;
import java.util.*;

public class Solution0179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = "" + nums[i];
        }
        Arrays.sort(s, (a, b) ->
        {
            String s1 = a + b, s2 = b + a;
            return s2.compareTo(s1);
        });
        StringBuffer res = new StringBuffer();
        for (String s1 : s) {
            res.append(s1);
        }
        int index = 0;
        while (index < n - 1 && res.charAt(index) == '0') {
            index++;
        }
        return res.substring(index).toString();
    }

}
