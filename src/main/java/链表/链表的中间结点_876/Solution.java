/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
package 链表.链表的中间结点_876;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode cursor1Step = head;
        ListNode cursor2Step = head;
        while (cursor2Step != null && cursor2Step.next != null) {
            cursor1Step = cursor1Step.next;
            cursor2Step = cursor2Step.next.next;
        }
        return cursor1Step;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}