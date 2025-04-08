package org.example.meduim.addTwoNumbers;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Solution solution = new Solution();
        ListNode temp = solution.addTwoNumbers(l1, l2);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
