package com.Problem.Q500_Q999;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0811_Subdomain_Visit_Count {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        String[][] arr = new String[cpdomains.length][2];
        for (int i = 0; i < cpdomains.length; i++) {
            String[] s = cpdomains[i].split(" ");
            arr[i] = s;
        }
        for (String[] strings : arr) {
            int num = Integer.valueOf(strings[0]);
            String s = strings[1];
            StringBuffer buffer = new StringBuffer();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != '.') {
                    buffer.append(s.charAt(i));
                    if (i == 0) {
                        String rev = buffer.toString();
                        map.put(rev, map.getOrDefault(rev, 0) + num);
                    }
                } else {
                    String rev = buffer.toString();
                    map.put(rev, map.getOrDefault(rev, 0) + num);
                    buffer.append('.');
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(stringIntegerEntry.getKey());
            res.add(stringIntegerEntry.getValue() + " " + buffer.reverse().toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0811_Subdomain_Visit_Count s = new Solution0811_Subdomain_Visit_Count();
        System.out.println(s.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

}
