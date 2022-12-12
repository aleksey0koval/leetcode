package com.kovalchuk.divide_two_integers;

public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long tempResult = divide(Math.abs((long) dividend), Math.abs((long) divisor));
        return tempResult > Integer.MAX_VALUE
                ? sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE
                : (int) (sign * tempResult);
    }

    private long divide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long sum = divisor;
        long mult = 1;
        while ((sum * 2) <= dividend) {
            sum += sum;
            mult += mult;
        }
        return mult + divide(dividend - sum, divisor);
    }
}
