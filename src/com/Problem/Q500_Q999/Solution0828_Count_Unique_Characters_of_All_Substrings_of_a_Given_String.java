package com.Problem.Q500_Q999;

import java.util.Arrays;

public class Solution0828_Count_Unique_Characters_of_All_Substrings_of_a_Given_String {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] count = new int[26];
        Arrays.fill(count, -1);
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'A';
            l[i] = count[index];
            count[index] = i;
        }
        Arrays.fill(count, n);
        for (int i = n - 1; i >= 0; i--) {
            int index = s.charAt(i) - 'A';
            r[i] = count[index];
            count[index] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (i - l[i]) * (r[i] - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution0828_Count_Unique_Characters_of_All_Substrings_of_a_Given_String s = new Solution0828_Count_Unique_Characters_of_All_Substrings_of_a_Given_String();
        s.uniqueLetterString("ABC");
    }
}
