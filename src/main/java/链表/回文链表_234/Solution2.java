package 链表.回文链表_234;

import java.util.ArrayDeque;

public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode halfHead = this.findHalfHead(head);
        ListNode reversedHalfHead = this.reverseList(halfHead);

        ListNode cursor = head;
        ListNode reversedHalfCursor = reversedHalfHead;
        while (cursor != halfHead) {
            if (cursor.val != reversedHalfCursor.val) {
                return false;
            }
            cursor = cursor.next;
            reversedHalfCursor = reversedHalfCursor.next;
        }

        return true;
    }

    private ListNode findHalfHead(ListNode head) {
        ListNode fastCursor = head;
        ListNode slowCursor = head;
        while (fastCursor != null && fastCursor.next != null) {
            fastCursor = fastCursor.next.next;
            slowCursor = slowCursor.next;
        }
        return slowCursor;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }
}
