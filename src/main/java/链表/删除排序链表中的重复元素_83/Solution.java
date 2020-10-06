/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
package 链表.删除排序链表中的重复元素_83;

import java.util.HashSet;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 注意，这里的链表是已排序的。
        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode cur = prev.next;
        while (cur != null) {
            if (cur.val == prev.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
