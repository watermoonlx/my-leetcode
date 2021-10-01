/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
package 链表.移除链表元素_203;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 引入一个哨兵节点作为虚拟头。
        // 这是为了简化head为null，以及链表开头一个或多个元素等于val的特殊情况的判断逻辑。
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel;
        ListNode cur = prev.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }

            cur = cur.next;
        }
        return sentinel.next;
    }
}
