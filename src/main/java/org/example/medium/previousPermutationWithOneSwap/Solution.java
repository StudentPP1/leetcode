package org.example.medium.previousPermutationWithOneSwap;
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int idx = -1;
        // ! find the largest i such that A[i] > A[i + 1] (from the right side)
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i - 1] > arr[i]) {
                idx = i - 1;
                break;
            }
        }

        // ! the array already sorted, not smaller permutation
        if (idx == -1) return arr;

        // ! find the largest j such that A[j] > A[i] (idx <- start from right end of arr), then swap them
        for (int i = arr.length - 1; i > idx; i--) {
            // ! the second check to skip duplicate numbers
            if (arr[i] < arr[idx] && arr[i] != arr[i - 1]) { // ! like 3 1 1 3 -> to skip right 1
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }
        return arr;
    }
}