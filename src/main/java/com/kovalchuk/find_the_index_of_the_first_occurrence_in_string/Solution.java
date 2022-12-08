package com.kovalchuk.find_the_index_of_the_first_occurrence_in_string;

public class Solution {
    public int strStr(String haystack, String needle) {
        int x = haystack.length() - needle.length();
        for (int i = 0; i <= x; i++) {
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }
        return -1;
    }
}
