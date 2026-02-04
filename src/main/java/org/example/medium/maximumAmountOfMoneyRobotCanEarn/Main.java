package org.example.medium.maximumAmountOfMoneyRobotCanEarn;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] coins1 = {
                {6, -16},
                {0, -18}
        };
        System.out.println(solution.maximumAmount(coins1));
    }
}

class Solution {
    private static final int ABILITY_COUNT = 2;
    private static final int MIN_VALUE = -1_000_000;

    public int maximumAmount(int[][] coins) {
        int rows = coins.length;
        int columns = coins[0].length;
        Integer[][][] dp = new Integer[rows][columns][ABILITY_COUNT + 1];
        return findMax(rows - 1, columns - 1, coins, ABILITY_COUNT, dp);
    }

    private int findMax(int rowIndex, int columnIndex, int[][] coins, int reverseCount, Integer[][][] dp) {
        Integer minValue = defaultWay(rowIndex, columnIndex, coins, reverseCount, dp);
        if (minValue != null) return minValue;

        int currentCell = coins[rowIndex][columnIndex];
        int left;
        int up;

        if (currentCell >= 0) {
            left = currentCell + findMax(rowIndex, columnIndex - 1, coins, reverseCount, dp);
            up = currentCell + findMax(rowIndex - 1, columnIndex, coins, reverseCount, dp);
        } else {
            int leftUseAbility = (reverseCount > 0) ?
                    findMax(rowIndex, columnIndex - 1, coins, reverseCount - 1, dp)
                    : MIN_VALUE;
            int upUseAbility = (reverseCount > 0) ?
                    findMax(rowIndex - 1, columnIndex, coins, reverseCount - 1, dp)
                    : MIN_VALUE;

            int leftWithoutAbility = currentCell + findMax(rowIndex, columnIndex - 1, coins, reverseCount, dp);
            int upWithoutAbility = currentCell + findMax(rowIndex - 1, columnIndex, coins, reverseCount, dp);

            left = Math.max(leftUseAbility, leftWithoutAbility);
            up = Math.max(upUseAbility, upWithoutAbility);
        }
        int maxValue = Math.max(up, left);
        dp[rowIndex][columnIndex][reverseCount] = maxValue;
        return maxValue;
    }

    private static Integer defaultWay(int rowIndex, int columnIndex, int[][] coins, int reverseCount, Integer[][][] dp) {
        if (rowIndex < 0 || columnIndex < 0) {
            return MIN_VALUE;
        }
        if (dp[rowIndex][columnIndex][reverseCount] != null) {
            return dp[rowIndex][columnIndex][reverseCount];
        }
        if (rowIndex == 0 && columnIndex == 0) {
            int value = coins[rowIndex][columnIndex];
            if (value < 0 && reverseCount > 0) return 0;
            return value;
        }
        return null;
    }
}