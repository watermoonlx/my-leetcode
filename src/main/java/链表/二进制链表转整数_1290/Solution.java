/**
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
package 链表.二进制链表转整数_1290;

public class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode cur = head;
        while (cur != null) {
            result = result * 2 + cur.val;
            cur = cur.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
