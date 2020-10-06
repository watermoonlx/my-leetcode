/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
package 链表.反转链表_206;

public class Solution {

    public ListNode reverseList(ListNode head) {
        return null;
    }

    // 循环解法
    private ListNode reverseListLoop(ListNode head) {
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

    // 递归解法
    private ListNode newHead = null;

    private ListNode reverseListRec(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        reverseNextNode(head);
        head.next = null;
        return this.newHead;
    }

    private void reverseNextNode(ListNode node) {
        if (node.next == null) {
            this.newHead = node;
            return;
        }
        ListNode nextNode = node.next;
        reverseNextNode(nextNode);
        nextNode.next = node;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
