package 链表.相交链表_160;

public class Solution {
    /**
     * 双指针法
     * 核心要点：a + same + b = b + same + a
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        if (nodeA == null) {
            nodeA = headB;
        } else {
            nodeB = headA;
        }

        while (nodeA != null && nodeB != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        if (nodeA == null) {
            nodeA = headB;
        } else {
            nodeB = headA;
        }

        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return null;
    }
}