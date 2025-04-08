package org.example.meduim.onesAndZeroes;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // ! найти найбольший набор где есть 5 нулей и 3 единицы
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        System.out.println(solution.findMaxForm(strs, m, n));
    }
}
