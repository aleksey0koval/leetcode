package com.kovalchuk.valid_parentheses;

import java.util.Map;
import java.util.Stack;

public class Solution {
    Map<Character, Character> map = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.size() == 0 || map.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
