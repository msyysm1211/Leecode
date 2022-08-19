package com.Problem.Q500_Q999;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0804_Unique_Morse_Code_Words {
    String[] dic = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                buffer.append(dic[word.charAt(i) - 'a']);
            }
            set.add(buffer.toString());
        }
        return set.size();
    }
}
