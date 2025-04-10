package org.example.meduim.MinimumNumberOfWorkSessionsToFinishTheTasks;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] tasks1 = new int[]{1,2,3};
        int sessionTime1 = 3; // 2
        int[] tasks2 = new int[]{3,1,3,1,1};
        int sessionTime2 = 8; // 2
        int[] tasks3 = new int[]{1,2,3,4,5};
        int sessionTime3 = 15; // 1
        int[] tasks4 = new int[]{7,4,3,8,10};
        int sessionTime4 = 12; // 3
        int[] tasks5 = new int[]{2,3,3,4,4,4,5,6,7,10};
        int sessionTime5 = 12; // 4
        System.out.println("Result: " + solution.minSessions(tasks1, sessionTime1));
        System.out.println("Result: " + solution.minSessions(tasks2, sessionTime2));
        System.out.println("Result: " + solution.minSessions(tasks3, sessionTime3));
        System.out.println("Result: " + solution.minSessions(tasks4, sessionTime4));
        System.out.println("Result: " + solution.minSessions(tasks5, sessionTime5));
    }
}
