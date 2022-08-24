package com.Problem.Q1500_Q1999;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Solution1545Find_Kth_Bit_in_Nth_Binary_String {
    public char findKthBit(int n, int k) {
        String s1 = "0";
        for (int i = 1; i < n; i++) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(s1);
            buffer.append(1);
            buffer.append(helper(s1));
            s1 = buffer.toString();
        }
        return s1.charAt(k - 1);
    }

    String helper(String s) {
        String reverse = new StringBuffer(s).reverse().toString();
        char[] arrs = reverse.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (char arr : arrs) {
            buffer.append((char) ('0' + '1' - arr));
        }
        return buffer.toString();
    }

    public char findKthBit2(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int middle = 1 << n - 1;
        if (middle == k) {
            return '1';
        } else if (k < middle) {
            return findKthBit2(n - 1, k);
        } else {
            return invert(findKthBit2(n - 1, 2 * middle - k));
        }
    }

    char invert(char c) {
        return (char) ('0' + '1' - c);
    }

    public static void main(String[] args) {
        Solution1545Find_Kth_Bit_in_Nth_Binary_String s = new Solution1545Find_Kth_Bit_in_Nth_Binary_String();
        System.out.println(s.findKthBit2(4, 11));
    }

}
