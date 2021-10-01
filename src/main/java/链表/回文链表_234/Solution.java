/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 对于该题，有三种解法：
 * 1. 将链表复制到ArrayList中，然后用两个游标分别从前后开始进行遍历，并比较。这种方法最简单直接，时间、空间复杂度均为O(n)。
 * 2. 利用递归，先获取到尾部节点，然后在递归返回时和原链表中每个节点依次比较。这种方法看上去很高端，但实际上效果不好，时间、空间复杂度也是O(n)。
 * 因为调用栈中每个栈帧都会占据一定空间。
 * 3. 将链表从中间分割为两半，然后将后半部分反转，接着再比较两个链表。这种方法比较繁琐，但空间复杂度是O(1)。
 */
package 链表.回文链表_234;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean result = new Solution().isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int nodeCount = this.countNode(head);
        ListNode halfHead = this.getHalfHead(head, nodeCount);
        halfHead = this.reverseList(halfHead);

        boolean result = this.isListEquals(head, halfHead, nodeCount / 2);
        this.reverseList(halfHead);

        return result;
    }

    // 获取节点数
    private int countNode(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 将链表从中间拆分为两半，获取下半部分链表的头结点
    private ListNode getHalfHead(ListNode head, int nodeCount) {
        int halfHeadCount = nodeCount / 2 + 1;
        if (nodeCount % 2 == 1) {
            halfHeadCount += 1;
        }
        ListNode halfHead = head;
        int count = 1;
        while (count != halfHeadCount) {
            halfHead = halfHead.next;
            count++;
        }
        return halfHead;
    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
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

    private boolean isListEquals(ListNode head1, ListNode head2, int count) {
        ListNode node1 = head1;
        ListNode node2 = head2;
        int comparedCount = 0;
        while (comparedCount < count) {
            if (node1.val != node2.val) {
                return false;
            } else {
                node1 = node1.next;
                node2 = node2.next;
                comparedCount++;
            }
        }
        return true;
    }
}