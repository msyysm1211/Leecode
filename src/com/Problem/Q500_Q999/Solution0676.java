package com.Problem.Q500_Q999;

public class Solution0676 {
    String[] dic;

    public Solution0676() {

    }

    public void buildDict(String[] dictionary) {
        dic = dictionary;
    }

    public boolean search(String searchWord) {
        int n = searchWord.length();
        for (String s : dic) {
            int length = s.length();
            if (length == n) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (searchWord.charAt(i) != s.charAt(i))
                        count++;
                    if (count > 2) {
                        break;
                    }
                }
                if (count == 1)
                    return true;
            }
        }
        return false;
    }
}
