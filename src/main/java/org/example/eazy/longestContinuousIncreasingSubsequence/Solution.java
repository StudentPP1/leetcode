package org.example.eazy.longestContinuousIncreasingSubsequence;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 0;
        int currentLength = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                currentLength++;
            } else if (i > 0 && nums[i] == nums[i - 1]) {
                // If the current number is equal to the previous one, reset currentLength
                currentLength = 1;
            } else {
                currentLength = 1;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
