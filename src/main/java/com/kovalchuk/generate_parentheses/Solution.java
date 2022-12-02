package com.kovalchuk.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", 0, 0, n);
        return result;
    }

    private void helper(List<String> result, String temp, int open, int close, int n) {
        if (temp.length() == n * 2) {
            result.add(temp);
            return;
        }
        if (open < n) {
            helper(result, temp + "(", open + 1, close, n);
        }
        if (close < open) {
            helper(result, temp + ")", open, close + 1, n);
        }
    }
}
