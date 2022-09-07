package com.Problem.Q1500_Q1999;

public class Solution1592_Rearrange_Spaces_Between_Words {
    public String reorderSpaces(String text) {
        int n = text.length();
        if (n == 1) {
            return text;
        }
        String s = text.trim();
        String[] arrs = s.split("\\s+");
        int count = 0;
        for (String arr : arrs) {
            count += arr.length();
        }
        StringBuffer buffer = new StringBuffer();
        int size = arrs.length;
        if (size == 1) {
            buffer.append(arrs[0]);
            for (int i = 0; i < n - count; i++) {
                buffer.append(" ");
            }
            return buffer.toString();
        }
        int blank = (n - count) / (size - 1);
        for (int i = 0; i < size; i++) {
            buffer.append(arrs[i]);
            for (int j = 0; j < blank && i < size - 1; j++) {
                buffer.append(" ");
            }
        }
        int last = (n - count) % (size - 1);
        for (int i = 0; i < last; i++) {
            buffer.append(" ");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Solution1592_Rearrange_Spaces_Between_Words s = new Solution1592_Rearrange_Spaces_Between_Words();
        s.reorderSpaces("  this   is  a sentence ");
    }
}
