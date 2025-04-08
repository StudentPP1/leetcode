package org.example.meduim.onesAndZeroes;
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] — максимальна кількість рядків, які можна взяти
        // використовуючи максимум i нулів і j одиниць
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            System.out.println("Current string: " + str);
            int zeros = 0, ones = 0;

            // Рахуємо кількість нулів і одиниць в поточному рядку
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
            printDP(dp);
        }

        return dp[m][n];
    }
    private void printDP(int[][] dp) {
        int m = dp.length;
        int n = dp[0].length;

        // Виводимо заголовки стовпців
        System.out.print("    ");
        for (int j = 0; j < n; j++) {
            System.out.printf("%3d", j);
        }
        System.out.print(" <-- 1's\n");

        // Виводимо рядки
        for (int i = 0; i < m; i++) {
            System.out.printf("%3d ", i); // 0's
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", dp[i][j]);
            }
            System.out.println();
        }
        System.out.println("___________________________");
    }
}

