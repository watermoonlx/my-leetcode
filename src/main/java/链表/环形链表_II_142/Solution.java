package 链表.环形链表_II_142;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode newSlow = head;
                while (slow != newSlow) {
                    slow = slow.next;
                    newSlow = newSlow.next;
                }
                return newSlow;
            }
        }

        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
