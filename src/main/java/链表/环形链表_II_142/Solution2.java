package 链表.环形链表_II_142;

public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fastCursor = head;
        ListNode slowCursor = head;

        boolean hasCycle = false;
        while (fastCursor != null && fastCursor.next != null) {
            fastCursor = fastCursor.next.next;
            slowCursor = slowCursor.next;
            if (fastCursor == slowCursor) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        fastCursor = head;
        while (fastCursor != slowCursor && fastCursor.next != slowCursor) {
            fastCursor = fastCursor.next;
            slowCursor = slowCursor.next;
        }

        return slowCursor;
    }
}
