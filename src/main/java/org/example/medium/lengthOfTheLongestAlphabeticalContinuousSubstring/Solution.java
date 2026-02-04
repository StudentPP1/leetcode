package org.example.medium.lengthOfTheLongestAlphabeticalContinuousSubstring;

class Solution {
    public int longestContinuousSubstring(String s) {
        int maxCount = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            // B (66) - A (65) = 1
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                count++;
            }
            else {
                count = 1;
            }
            if (maxCount < count) {
                maxCount = count;
            }
        }
        return maxCount;
    }

}