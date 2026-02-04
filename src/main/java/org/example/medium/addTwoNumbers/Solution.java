package org.example.medium.addTwoNumbers;

class Solution {
    private int extra;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);

        if (l1.val == 0 && length1 == 1) {
            return l2;
        }

        if (l2.val == 0 && length2 == 1) {
            return l1;
        }

        ListNode longNode;
        ListNode shortNode;

        if (length1 >= length2) {
            longNode = l1;
            shortNode = l2;
        }
        else {
            longNode = l2;
            shortNode = l1;
        }

        return addTwoNode(longNode, shortNode);
    }

    private ListNode addTwoNode(ListNode longNode, ListNode shortNode) {
        ListNode sum = sumNumbers(longNode.val, shortNode.val);

        while (longNode.next != null) {
            ListNode last = findLastNode(sum);
            longNode = longNode.next;

            if (shortNode.next != null) {
                shortNode = shortNode.next;
                last.next = sumNumbers(longNode.val, shortNode.val);
            }
            else {
                if (extra != 0) {
                    last.next = sumNumbers(longNode.val, 0);
                }
                else {
                    last.next = longNode;
                    break;
                }
            }
        }

        if (extra != 0) {
            ListNode last = findLastNode(sum);
            last.next = new ListNode(extra);
        }

        return sum;
    }
    private ListNode sumNumbers(int num1, int num2) {
        int sum = num1 + num2 + extra;
        if (sum >= 10) {
            extra = sum / 10;
            sum %= 10;
        } else {
            extra = 0;
        }
        return new ListNode(sum);
    }
    private ListNode findLastNode(ListNode node) {
        ListNode last = node;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }
    private int getLength(ListNode node) {
        int count = 1;
        ListNode last = node;
        while (last.next != null) {
            last = last.next;
            count += 1;
        }
        return count;
    }
}

