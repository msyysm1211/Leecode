package com.Problem.Q1500_Q1999;

public class Solution1598_Crawler_Log_Folder {
    public int minOperations(String[] logs) {
        int layer = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (layer > 0)
                    layer--;
            } else if (log.equals("./")) {
                continue;
            } else {
                layer++;
            }
        }
        return layer;
    }
}
