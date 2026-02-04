package org.example.medium.determineifaCellIsReachableataGivenTime;

public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy && t != 1) return true;
        if (sx == fx && sy == fy) return false;
        if (t == 0) return false;
        // ! Chebyshev distance
        return Math.max(Math.abs(sx - fx), Math.abs(sy - fy)) <= t;
    }
}
