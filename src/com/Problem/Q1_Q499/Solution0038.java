package com.Problem.Q1_Q499;

public class Solution0038 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuffer buffer = new StringBuffer();

            int start = 0;
            int end = 0;
            while (end < s.length()) {
                int count = 0;
                while (end < s.length() && s.charAt(start) == s.charAt(end)) {
                    end++;
                    count++;
                }
                buffer.append(count + "");
                buffer.append(s.charAt(start) + "");
                start = end;
            }
            s = buffer.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Solution0038 s = new Solution0038();
        System.out.println(s.countAndSay(3));
    }
}
