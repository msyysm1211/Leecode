package com.Problem.Q500_Q999;

import java.util.HashSet;
import java.util.Set;


public class Solution0720_Longest_Word_in_Dictionary {
    class trie {
        trie[] children = new trie[26];
        boolean isEnd = false;

        void insert(String s) {
            trie node = this;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new trie();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        boolean search(String word) {
            trie node = this;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null || !node.children[c - 'a'].isEnd) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node != null && node.isEnd;
        }
    }

    public String longestWord2(String[] words) {
        trie t = new trie();
        String res = "";
        for (String word : words) {
            t.insert(word);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (t.search(word)) {
                if (words[i].length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }
        return res;
    }

    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        int max = 0;
        String res = "";
        for (String s : set) {
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                String t = s.substring(0, i + 1);
                if (!set.contains(s.substring(0, i + 1))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (s.length() > max || (s.length() == max && s.compareTo(res) < 0)) {
                    max = s.length();
                    res = s;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0720_Longest_Word_in_Dictionary s = new Solution0720_Longest_Word_in_Dictionary();
        System.out.println(s.longestWord2(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

}
