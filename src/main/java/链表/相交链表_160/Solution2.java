package 链表.相交链表_160;

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode cursor1 = headA;
        ListNode cursor2 = headB;
        while (cursor1 != null && cursor2 != null) {
            if (cursor1 == cursor2) {
                return cursor1;
            }
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }
        if (cursor1 == null) {
            cursor1 = headB;
        } else {
            cursor2 = headA;
        }

        while (cursor1 != null && cursor2 != null) {
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }
        if (cursor1 == null) {
            cursor1 = headB;
        } else {
            cursor2 = headA;
        }

        while (cursor1 != null && cursor2 != null) {
            if (cursor1 == cursor2) {
                return cursor1;
            }
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }

        return null;
    }
}
