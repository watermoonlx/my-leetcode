package 链表.环形链表_141;

public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slowCursor = head;
        ListNode fastCursor = head;
        while (fastCursor.next != null && fastCursor.next.next != null) {
            if (fastCursor.next == slowCursor || fastCursor.next.next == slowCursor) {
                return true;
            }
            fastCursor = fastCursor.next.next;
            slowCursor = slowCursor.next;
        }

        return false;
    }
}
