package org.example.medium.lengthOfTheLongestAlphabeticalContinuousSubstring;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestContinuousSubstring("abacaba")); // 2
        System.out.println(solution.longestContinuousSubstring("abcde")); // 5
        System.out.println(solution.longestContinuousSubstring("yrpjofyzubfsiypfre")); // 2
    }
}
