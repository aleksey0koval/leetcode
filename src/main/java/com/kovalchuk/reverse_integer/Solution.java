package com.kovalchuk.reverse_integer;

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
 */

public class Solution {
    public int reverse(int x) {
        int iter = x < 0 ? x * -1 : x;
        long result = 0;

        while (iter > 0) {
            result = result * 10 + iter % 10;
            iter = iter / 10;
        }

        if (result > Integer.MAX_VALUE) {
            return 0;
        }

        return x < 0 ? (int) result * -1 : (int) result;
    }
}
