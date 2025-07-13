package org.example.meduim.largestSubmatrixWithRearrangements;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix1 = {
                {0,0,1},
                {1,1,1},
                {1,0,1}
        };
        System.out.println(solution.largestSubmatrix(matrix1));
        int[][] matrix2 = {
                {1,0,1,0,1}
        };
        System.out.println(solution.largestSubmatrix(matrix2));
    }
}
