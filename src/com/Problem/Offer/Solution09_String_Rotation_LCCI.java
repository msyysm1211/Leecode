package com.Problem.Offer;

public class Solution09_String_Rotation_LCCI {
    public boolean isFlipedString(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        if (n1 == 0 && n2 == 0) {
            return true;
        }
        boolean res = true;
        for (int i = 0; i < n1; i++) {
            res = true;
            for (int j = 0; j < n1; j++) {
                char c = s2.charAt((i + j) % n1);
                if (c != s1.charAt(j)) {
                    res = false;
                    break;
                }
            }
            if (res == true) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlipedString2(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        Solution09_String_Rotation_LCCI s = new Solution09_String_Rotation_LCCI();
        System.out.println(s.isFlipedString2("waterbottle", "erbottlewat"));
    }
}
