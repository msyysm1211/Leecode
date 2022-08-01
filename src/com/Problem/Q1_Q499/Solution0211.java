package com.Problem.Q1_Q499;

public class Solution0211 {
}

class WordDictionary {
    Trie2 root;

    public WordDictionary() {
        root = new Trie2();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return root.inqury(word, root.root);
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("bad");
        System.out.println(w.search(".ad"));

    }
}

class Trie2 {
    TrieNode root;

    public Trie2
            () {
        root = new TrieNode();
    }

    boolean inqury(String word, TrieNode temp) {
        if (temp == null) {
            return false;
        }
        TrieNode node = temp;
        int index = 0;
        boolean res = false;
        for (char c : word.toCharArray()) {
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    res = res || inqury(word.substring(index + 1), node.children[i]);
                }
                return res;
            } else if (node.children[c - 'a'] == null) {
                return false;
            } else {
                node = node.children[c - 'a'];
            }
            index++;

        }
        return node.isWord;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }


}
