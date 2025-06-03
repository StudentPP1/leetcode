package org.example.eazy.longestContinuousIncreasingSubsequence;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3, 5, 4, 7};
        System.out.println(solution.findLengthOfLCIS(nums1));
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(solution.findLengthOfLCIS(nums2));
        int[] nums3 = {1, 3, 5, 7};
        System.out.println(solution.findLengthOfLCIS(nums3));
    }
}
