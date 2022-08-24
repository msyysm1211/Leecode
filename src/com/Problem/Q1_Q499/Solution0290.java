package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.Map;

public class Solution0290 {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        Map<Character, String> ChartoString = new HashMap<>();
        Map<String, Character> StringtoChar = new HashMap<>();
        int n = pattern.length();
        int m = arr.length;
        if (m != n) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s1 = arr[i];
            if (!ChartoString.containsKey(c) && !StringtoChar.containsKey(s1)) {
                ChartoString.put(c, s1);
                StringtoChar.put(s1, c);
            } else {
                String target = ChartoString.get(c);
                if (target != null && !target.equals(s1)) {
                    return false;
                }
                Character c1 = StringtoChar.get(s1);
                if (c1 != null && !c1.equals(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0290 s = new Solution0290();
        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
    }

}
