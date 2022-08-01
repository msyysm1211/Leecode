package com.Problem.Q500_Q999;

import java.util.List;

public class Solution0648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        trie dic = new trie();
        for (String s : dictionary) {
            dic.insert(s);
        }
        String[] buffer = sentence.split(" ");
        StringBuffer res = new StringBuffer();
        for (String s : buffer) {
            res.append(dic.query(s) + " ");
        }
        return res.toString().substring(0, res.length() - 1);
    }
}

class trie {
    trieNode root;

    public trie() {
        root = new trieNode();
    }

    void insert(String s) {
        trieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new trieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    String query(String s) {
        trieNode node = root;
        int index = 0;
        for (char c : s.toCharArray()) {
            if (node.isWord) {
                return s.substring(0, index);
            }
            if (node.children[c - 'a'] == null) {
                break;
            }
            index++;
            node = node.children[c - 'a'];
        }
        return s;
    }

}

class trieNode {
    boolean isWord;
    trieNode[] children;

    public trieNode() {
        children = new trieNode[26];
    }
}