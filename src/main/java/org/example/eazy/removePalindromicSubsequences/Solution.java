package org.example.eazy.removePalindromicSubsequences;

import java.util.Objects;

class Solution {
    public int removePalindromeSub(String s) {
        // ! if is not palindrome => delete all a, then delete all b => 2 steps always
        return Objects.equals(s, (new StringBuilder(s)).reverse().toString()) ? 1 : 2;
    }
}