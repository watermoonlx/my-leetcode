package 链表.合并两个有序链表_21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode mergedListTail = dummy;

        ListNode l1Cursor = l1;
        ListNode l2Cursor = l2;
        while (l1Cursor != null && l2Cursor != null) {
            if (l1Cursor.val < l2Cursor.val) {
                mergedListTail.next = new ListNode(l1Cursor.val);
                l1Cursor = l1Cursor.next;
            } else {
                mergedListTail.next = new ListNode(l2Cursor.val);
                l2Cursor = l2Cursor.next;
            }
            mergedListTail = mergedListTail.next;
        }

        if (l1Cursor == null) {
            mergedListTail.next = l2Cursor;
        } else {
            mergedListTail.next = l1Cursor;
        }

        return dummy.next;
    }
}