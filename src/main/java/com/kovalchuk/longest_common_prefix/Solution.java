package com.kovalchuk.longest_common_prefix;

import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int counter = 0;
        while (counter < first.length()) {
            if (first.charAt(counter) != last.charAt(counter)) {
                break;
            }
            counter++;
        }
        return counter == 0 ? "" : first.substring(0, counter);
    }
}
