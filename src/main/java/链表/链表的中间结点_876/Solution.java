/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
package 链表.链表的中间结点_876;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        ListNode middleNode = head;
        while (node.next != null && node.next.next != null) {
            node = node.next.next;
            middleNode = middleNode.next;
        }
        if (node.next != null) {
            middleNode = middleNode.next;
        }
        return middleNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}