package com.kovalchuk.integer_to_roman;

public class Solution {
    private final static int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            while (num >= val[i]) {
                result.append(rom[i]);
                num -= val[i];
            }
        }
        return result.toString();
    }
}
