package org.example.hard.minimumOperationsToMakeArrayElementsZero;

class Solution {
    public long minOperations(int[][] queries) {
        long counter = 0;
        for (int[] array : queries) {
            long min = array[0];
            long max = array[1];
            counter += calc(min, max);
        }
        return counter;
    }
    private long calc(long min, long max) {
        // ! x -> 0 need log4(x) + 1 operations

        // ! add 1 for all numbers in group
        long operations = (max - min + 1);
        // ! min/max operations count for x -> 0
        // ! (5 -> 0,  5 / 4 => 1, final operation for 1 / 4 => 0 we already added)
        long start = (long) (Math.log(min) / Math.log(4));
        long end = (long) (Math.log(max) / Math.log(4));
        long currentRange = (long) Math.pow(4, start + 1);

        while (start <= end) {
            long rangeEnd = Math.min(max, currentRange);
            long elementCount = rangeEnd - min;

            if(rangeEnd == max && start == end) {
                elementCount++;
            }

            operations += elementCount * start;
            start++;
            min = currentRange;
            currentRange *= 4;
        }

        return (operations + 1) / 2;
    }
}