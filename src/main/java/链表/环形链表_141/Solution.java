/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
package 链表.环形链表_141;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode oneStepNode = head;
        ListNode twoStepNode = head;
        while (twoStepNode != null && twoStepNode.next != null) {
            if (twoStepNode.next == oneStepNode || twoStepNode.next.next == oneStepNode) {
                return true;
            }
            oneStepNode = oneStepNode.next;
            twoStepNode = twoStepNode.next.next;
        }
        return false;
    }
}

