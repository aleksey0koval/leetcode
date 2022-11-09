package com.kovalchuk.longest_palindromic_substring;

/*
Given a string s, return the longest palindromic substring in s.
A string is called a palindrome string if the reverse of that string is the same as the original string.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
*/

public class Solution {
    public String longestPalindrome(String s) {
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String palindrome = getString(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            palindrome = getString(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }

    private String getString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
