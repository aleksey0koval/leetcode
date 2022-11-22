package com.kovalchuk.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final static Map<Character, Integer> map = new HashMap<>(Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    ));

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1) {
                if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                    result += map.get(s.charAt(i));
                } else {
                    result += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                    i++;
                }
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
}
