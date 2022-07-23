package com.Problem.Q1_Q499;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Solution0165 {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int n1 = arr1.length;
        int n2 = arr2.length;
        for (int i = 0; i < n1 || i < n2; i++) {
            int num1 = 0;
            int num2 = 0;
            if (i < n1) {
                num1 = Integer.parseInt(arr1[i]);
            }
            if (i < n2) {
                num2 = Integer.parseInt(arr2[i]);
            }
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution0165 s = new Solution0165();
        s.compareVersion("1.01", "1.001");
    }
}
