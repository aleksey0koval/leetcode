package com.kovalchuk.reverse_integer;

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
