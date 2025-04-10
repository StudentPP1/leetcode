package org.example.meduim.MinimumNumberOfWorkSessionsToFinishTheTasks;

import java.util.*;

/*
! Маємо набір задач tasks, кожна займає певний час,
! і ми можемо виконувати їх у робочих сесіях довжиною не більше sessionTime.
! Потрібно знайти мінімальну кількість таких сесій.
! Оскільки ми не знаємо, як саме розподілити задачі між сесіями, перебираємо всі можливі варіанти (backtracking).
! Але щоб не переглядати всі комбінації, ми будемо оптимізувати (жадібно заповнювати сесії + обрізати невигідні варіанти).
*/
class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        // ! сортування за зростанням
        Arrays.sort(tasks);
        int n = tasks.length;
        System.out.println("Відсортовані задачі (тільки будем брати з кінця): " + Arrays.toString(tasks));
        // ! Перебираємо кількість сесій від 1 до n (максимально може бути n сесій, якщо кожна задача окремо).
        // ! Пробуємо k=1 (одна сесія)
        // ! Якщо не виходить, пробуємо k=2, k=3, ...
        // ! Як тільки знаходимо рішення, зупиняємось (найменша кількість сесій)
        for (int k = 1; k <= n; k++) {
            System.out.println("Пробуємо k = " + k + " сесій...");
            // ! Викликаємо canPartition, яка перевіряє, чи можна розподілити задачі у k сесій.
            if (canPartition(tasks, new int[k], n - 1, sessionTime)) {
                System.out.println("✅ Вийшло з " + k + " сесіями!");
                return k;
            }
            System.out.println("❌ Не вдалося з " + k + " сесіями. Пробуємо більше...");
        }
        return n;
    }
    private boolean canPartition(int[] tasks, int[] sessions, int index, int sessionTime) {
        if (index < 0) {
            System.out.println("Усі задачі розподілено успішно!");
            return true;
        }
        // ! Алгоритм перебирає всі можливі способи розмістити задачі.
        for (int i = 0; i < sessions.length; i++) {
            // ! Для поточної задачі tasks[index] (в першій ітерації це сама велика):
            // ! Перевіряємо, чи можемо її додати в sessions[i]
            if (sessions[i] + tasks[index] <= sessionTime) {
                sessions[i] += tasks[index];
                System.out.println("Додаємо задачу " + tasks[index] + " до сесії " + (i + 1) + ": " + Arrays.toString(sessions));
                // ! Якщо так, додаємо і йдемо глибше -> canPartition(tasks, sessions, index - 1, sessionTime)
                if (canPartition(tasks, sessions, index - 1, sessionTime)) {
                    return true;
                }
                sessions[i] -= tasks[index];  // ! Відміняємо вибір (backtrack)
                System.out.println("↩ Відміняємо задачу " + tasks[index] + " із сесії " + (i + 1) + ": " + Arrays.toString(sessions));
            }
            if (sessions[i] == 0) break;  // ! Оптимізація: якщо ця сесія пуста, інші теж будуть
        }
        return false;
    }
}
