/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
package 栈.下一个更大元素_496;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        new Solution().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }

    /**
     * 我们可以忽略数组 nums1，先对将 nums2 中的每一个元素，求出其下一个更大的元素。
     * 随后对于将这些答案放入哈希映射（HashMap）中，再遍历数组 nums1，并直接找出答案。
     * 对于 nums2，我们可以使用单调栈来解决这个问题。
     *
     * 对于这种"需要看更多数据，才能解决目前问题，所以需要暂存当前数据"的问题，都应该考虑用栈来存储
     * 当前状态。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextBiggerNumMap = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            nextBiggerNumMap.put(num, -1);
            while (!stack.isEmpty() && stack.peek() < num) {
                nextBiggerNumMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextBiggerNumMap.get(nums1[i]);
        }
        return result;
    }
}
