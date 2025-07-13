package org.example.meduim.largestSubmatrixWithRearrangements;

import java.util.Arrays;

public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int maxArea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] height = new int[rows][cols];
        findHeightColumns(cols, rows, height, matrix);

        for (int row = 0; row < rows; row++) {
            int[] sortedRow = Arrays.copyOf(height[row], cols);
            insertionSort(sortedRow);
            reverse(sortedRow);
            System.out.println(Arrays.toString(sortedRow));
            for (int k = 0; k < sortedRow.length; k++) {
                int h = sortedRow[k];
                int w = k + 1;
                System.out.println(h + " *  " + w + " = " + h * w);
                maxArea = Math.max(maxArea, h * w);
            }
        }

        return maxArea;
    }
    private void findHeightColumns(int cols, int rows, int[][] height, int[][] matrix) {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (matrix[row][col] == 1) {
                    if (row == 0) {
                        height[row][col] = 1;
                    } else {
                        height[row][col] = height[row - 1][col] + 1;
                    }
                }
                else {
                    height[row][col] = 0;
                }
            }
        }
    }
    private void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int sorted = i - 1;
            while (sorted > -1 && array[sorted] > array[sorted + 1]) {
                int temp = array[sorted];
                array[sorted] = array[sorted + 1];
                array[sorted + 1] = temp;
                sorted--;
            }
        }
    }
    private void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}