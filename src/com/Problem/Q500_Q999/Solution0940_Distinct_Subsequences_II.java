package com.Problem.Q500_Q999;

public class Solution0940_Distinct_Subsequences_II {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int mod = (int) 1e9 + 7;
        long[] dp = new long[n + 1];
        long[] pre = new long[26];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 1]) % mod - pre[s.charAt(i - 1) - 'a'] % mod + mod) % mod;
            pre[s.charAt(i - 1) - 'a'] = dp[i - 1];
        }
        return (int) dp[n] - 1;
    }

    public static void main(String[] args) {
        Solution0940_Distinct_Subsequences_II s = new Solution0940_Distinct_Subsequences_II();
        System.out.println(s.distinctSubseqII("yezruvnatuipjeohsymapyxgfeczkevoxipckunlqjauvllfpwezhlzpbkfqazhexabomnlxkmoufneninbxxguuktvupmpfspwxiouwlfalexmluwcsbeqrzkivrphtpcoxqsueuxsalopbsgkzaibkpfmsztkwommkvgjjdvvggnvtlwrllcafhfocprnrzfoyehqhrvhpbbpxpsvomdpmksojckgkgkycoynbldkbnrlujegxotgmeyknpmpgajbgwmfftuphfzrywarqkpkfnwtzgdkdcyvwkqawwyjuskpvqomfchnlojmeltlwvqomucipcwxkgsktjxpwhujaexhejeflpctmjpuguslmzvpykbldcbxqnwgycpfccgeychkxfopixijeypzyryglutxweffyrqtkfrqlhtjweodttchnugybsmacpgperznunffrdavyqgilqlplebbkdopyyxcoamfxhpmdyrtutfxsejkwiyvdwggyhgsdpfxpznrccwdupfzlubkhppmasdbqfzttbhfismeamenyukzqoupbzxashwuvfkmkosgevcjnlpfgxgzumktsexvwhylhiupwfwyxotwnxodttsrifgzkkedurayjgxlhxjzlxikcgerptpufocymfrkyayvklsalgmtifpiczwnozmgowzchjiop"));
    }

}
