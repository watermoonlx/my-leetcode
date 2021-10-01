package 链表.移除链表元素_203;

public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode cursor = sentinel;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }

        return sentinel.next;
    }

}
