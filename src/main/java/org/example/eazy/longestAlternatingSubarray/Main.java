package org.example.eazy.longestAlternatingSubarray;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3,2,5,4};
        int threshold1 = 5;
        System.out.println(solution.longestAlternatingSubarray(nums1, threshold1));
        int[] nums2 = {1,2};
        int threshold2 = 2;
        System.out.println(solution.longestAlternatingSubarray(nums2, threshold2));
        int[] nums3 = {2,3,4,5};
        int threshold3 = 4;
        System.out.println(solution.longestAlternatingSubarray(nums3, threshold3));
    }
}
