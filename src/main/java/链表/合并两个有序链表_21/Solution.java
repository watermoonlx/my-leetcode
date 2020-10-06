/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
package 链表.合并两个有序链表_21;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);

        ListNode newListNode = sentinel;
        ListNode l1Node = l1;
        ListNode l2Node = l2;
        while (l1Node != null && l2Node != null) {
            if (l1Node.val <= l2Node.val) {
                newListNode.next = l1Node;
                l1Node = l1Node.next;
            } else {
                newListNode.next = l2Node;
                l2Node = l2Node.next;
            }
            newListNode = newListNode.next;
        }
        if (l1Node != null) {
            newListNode.next = l1Node;
        } else {
            newListNode.next = l2Node;
        }

        return sentinel.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}