package org.example.hard.minimumOperationsToMakeArrayElementsZero;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries1 = {{1, 2}, {2, 4}}; // 3
        System.out.println(solution.minOperations(queries1));
        int[][] queries2 = {{2, 6}}; // 4
        System.out.println(solution.minOperations(queries2));
    }
}