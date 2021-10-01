package 链表.删除排序链表中的重复元素_83;

public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cursor = head;
        while (cursor.next != null) {
            if (cursor.val == cursor.next.val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return head;
    }
}
