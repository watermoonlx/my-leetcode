package 栈.下一个更大元素_496;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
            map.put(num, -1);
        }

        int[] output = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            output[i] = map.get(nums1[i]);
        }

        return output;
    }
}
