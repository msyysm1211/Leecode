package com.Problem.Q500_Q999;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0763_Partition_Labels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }
        int l = 0, r = map.get(s.charAt(l));
        while (l <= r && r < n) {
            int max = 0;
            for (int i = l; i < r; i++) {
                int index = map.get(s.charAt(i));
                max = Math.max(max, index);
            }
            if (max <= r) {
                res.add(r - l + 1);
                l = r + 1;
                if (l < n)
                    r = map.get(s.charAt(l));
            } else {
                r = max;
            }
        }
        return res;
    }

    public List<Integer> partitionLabels2(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            r = Math.max(r, map.get(s.charAt(i)));
            if (r == i) {
                res.add(r - l + 1);
                l = r + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution0763_Partition_Labels s = new Solution0763_Partition_Labels();
        s.partitionLabels2("ababcbacadefegdehijhklij");
    }
}
