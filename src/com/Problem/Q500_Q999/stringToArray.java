package com.Problem.Q500_Q999;

import java.util.ArrayList;
import java.util.List;

public class stringToArray {
    public int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public int[][] stringToInt2dArray(String input) {
        String s = input.replace(" ", "");
        String[] arr = s.split("],");
        int n = arr.length;
        int m = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String temp = arr[i];
            temp = temp.replace("[", "");
            temp = temp.replace("]", "");
            String[] c = temp.split(",");
            int[] nums = new int[c.length];
            m = c.length;
            for (int j = 0; j < c.length; j++) {
                if (c[j] == "0") {
                    nums[j] = 0;
                } else
                    nums[j] = Integer.parseInt(c[j]);
            }
            list.add(nums);
        }
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = list.get(i)[j];
            }
        }
        return res;
    }


}
