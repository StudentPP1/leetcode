package org.example.meduim.previousPermutationWithOneSwap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr1 = {3, 2, 1};
        int [] arr2 = {1, 1, 5};
        int [] arr3 = {1,9,4,6,7};
        int [] arr4 = {3,1,1,3};
        System.out.println(Arrays.toString(solution.prevPermOpt1(arr1)));
        System.out.println(Arrays.toString(solution.prevPermOpt1(arr2)));
        System.out.println(Arrays.toString(solution.prevPermOpt1(arr3)));
        System.out.println(Arrays.toString(solution.prevPermOpt1(arr4)));
    }
}
