//package com.Problem.Q1500_Q1999;
//
//public class Solution1790_Check_if_One_String_Swap_Can_Make_Strings_Equal {
//    public boolean areAlmostEqual(String s1, String s2) {
//        int n = s1.length();
//        int l = -1, r = -1;
//        for (int i = 0; i < n; i++) {
//            if (s1.charAt(i) != s2.charAt(i)) {
//                if (l == -1) {
//                    l = i;
//                } else if (r == -1) {
//                    r = i;
//                } else {
//                    return false;
//                }
//            }
//        }
//        if (l == r && l == -1) {
//            return true;
//        }
//        if (l * r < 0) {
//            return false;
//        } else {
//            if (l>=0&&r>=0&&s1.charAt(l) == s2.charAt(r) && s1.charAt(r) == s2.charAt(l)) {
//                return true;
//            }
//            return false;
//        }
//    }
//}
//
//    public static void main(String[] args) {
//        Solution1790_Check_if_One_String_Swap_Can_Make_Strings_Equal s = new Solution1790_Check_if_One_String_Swap_Can_Make_Strings_Equal();
//        System.out.println(s.areAlmostEqual("attack", "defend"));
//    }
//
//}
