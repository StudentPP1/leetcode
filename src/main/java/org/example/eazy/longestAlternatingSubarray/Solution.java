package org.example.eazy.longestAlternatingSubarray;

public class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int len = 1;
                int prev = nums[i];
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] > threshold || nums[j] % 2 == prev % 2) {
                        break;
                    }
                    len++;
                    prev = nums[j];
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
