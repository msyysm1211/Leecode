package com.Problem.Q1_Q499;

import java.util.*;

class Solution433 {
    public int minMutation(String start, String end, String[] bank) {
        int res = 0;
        if (start.equals(end)) {
            return 0;
        }
        Set<String> cnt = new HashSet<String>();
        for (String i : bank) {
            cnt.add(i);
        }
        if (!cnt.contains(end)) {
            return -1;
        }
        Set<String> used = new HashSet<String>();
        Queue<String> queue = new ArrayDeque<String>();
        used.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                for (int j = 0; j < bank.length; j++) {
                    if (!used.contains(bank[j]) && numberDiff(bank[j], s) == 1) {
                        if (bank[j].equals(end)) {
                            return res;
                        } else {
                            used.add(bank[j]);
                            queue.add(bank[j]);
                        }
                    }
                }
            }
        }
        return -1;
    }

    int numberDiff(String s1, String s2) {
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (c1[i] != c2[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Solution433 a = new Solution433();
        int t = a.minMutation("AACCGGTT",
                "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"});
        System.out.println(t);
    }
}