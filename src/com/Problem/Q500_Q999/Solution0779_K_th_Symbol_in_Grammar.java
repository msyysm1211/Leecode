package com.Problem.Q500_Q999;

public class Solution0779_K_th_Symbol_in_Grammar {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int length = 1 << (n - 2);
        if (k <= length) {
            return kthGrammar(n - 1, k);
        } else {
            // System.out.println(k - length);
            return (kthGrammar(n - 1, k - length)) ^ 1;
        }
    }

    public int kthGrammar2(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int length = 1 << (n - 2);
        if (k <= length) {
            return kthGrammar(n - 1, k);
        } else {
            System.out.println(2 * length - k);
            return kthGrammar2(n - 1, 2 * length - k + 1);
        }
    }

    public static void main(String[] args) {
        Solution0779_K_th_Symbol_in_Grammar s = new Solution0779_K_th_Symbol_in_Grammar();
        s.kthGrammar(5, 9);
        s.kthGrammar2(3, 3);
    }

}
