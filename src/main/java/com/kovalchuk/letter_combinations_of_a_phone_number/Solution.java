package com.kovalchuk.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, String> map = new HashMap<>(
            Map.of(
                    '0', "",
                    '1', "",
                    '2', "abc",
                    '3', "def",
                    '4', "ghi",
                    '5', "jkl",
                    '6', "mno",
                    '7', "pqrs",
                    '8', "tuv",
                    '9', "wxyz"
            )
    );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        solve(digits, map, result, 0, "");
        return result;
    }

    private static void solve(String digits, Map<Character, String> map, List<String> result, int index, String res) {
        if (index == digits.length()) {
            result.add(res);
            return;
        }
        String temp = map.get(digits.charAt(index));
        for (int i = 0; i < temp.length(); i++) {
            String newTemp = res + temp.charAt(i);
            solve(digits, map, result, index + 1, newTemp);
        }
    }
}
