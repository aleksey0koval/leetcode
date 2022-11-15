package com.kovalchuk.string_to_integer_atoi;

public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        int i = 0;
        int result = 0;
        int sign = 1;
        s = s.trim();
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int d = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (result > (Integer.MAX_VALUE - d) / 10) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + d;
            i++;
        }
        return result * sign;
    }
}
