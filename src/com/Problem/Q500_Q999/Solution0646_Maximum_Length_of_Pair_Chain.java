package com.Problem.Q500_Q999;

import java.util.Arrays;

public class Solution0646_Maximum_Length_of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {//greedy
        int n = pairs.length;
        Arrays.sort(pairs, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                count++;
                end = pair[1];
            }
        }
        return count;
    }

    public int findLongestChain2(int[][] pairs) {//dp
        int n = pairs.length;
        Arrays.sort(pairs, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int[] dp = new int[n];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0646_Maximum_Length_of_Pair_Chain s = new Solution0646_Maximum_Length_of_Pair_Chain();
        stringToArray t = new stringToArray();
        System.out.println(s.findLongestChain2(t.stringToInt2dArray("[[7,9],[4,5],[7,9],[-7,-1],[0,10],[3,10],[3,6],[2,3]]")));
    }

}
