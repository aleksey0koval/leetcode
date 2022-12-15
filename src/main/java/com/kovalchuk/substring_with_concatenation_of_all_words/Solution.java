package com.kovalchuk.substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            int count = counts.getOrDefault(word, 0) + 1;
            counts.put(word, count);
        }
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int num = words.length;
        int len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            Map<String, Integer> copy = new HashMap<>();
            int temp = 0;
            while (temp < num) {
                String word = s.substring(i + temp * len, i + (temp + 1) * len);
                if (counts.containsKey(word)) {
                    copy.put(word, copy.getOrDefault(word, 0) + 1);
                    if (copy.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                temp++;
            }
            if (temp == num) {
                result.add(i);
            }
        }
        return result;
    }
}
