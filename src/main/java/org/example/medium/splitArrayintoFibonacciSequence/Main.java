package org.example.medium.splitArrayintoFibonacciSequence;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.splitIntoFibonacci("123456579"));
        System.out.println(solution.splitIntoFibonacci("112358130"));
        System.out.println(solution.splitIntoFibonacci("0000"));
        System.out.println(solution.splitIntoFibonacci("0123"));
        System.out.println(solution.splitIntoFibonacci("5511816597"));
        System.out.println(solution.splitIntoFibonacci("214748364721474836422147483641"));
    }
}

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        fillCombinations(num, 0, result);
        return result;
    }

    private boolean fillCombinations(String num, int start, List<Integer> current) {
        if (start == num.length()) {
            return current.size() >= 3;
        }
        for (int end = start + 1; end <= num.length(); end++) {
            String stringNumber = num.substring(start, end);
            if (stringNumber.length() > 1 && stringNumber.startsWith("0")) break;
            if (Long.parseLong(stringNumber) > Integer.MAX_VALUE) break;

            int number = Integer.parseInt(stringNumber);
            int size = current.size();

            if (size >= 2) {
                int sum = current.get(size - 1) + current.get(size - 2);
                if (number < sum) continue;
                if (number > sum) break;
            }

            current.add(number);
            if (fillCombinations(num, end, current)) return true;

            current.remove(current.size() - 1);
        }
        return false;
    }
}
