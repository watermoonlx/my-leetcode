/**
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
package 栈.删除字符串中的所有相邻重复项_1047;

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        String s = new Solution().removeDuplicates("abbaca");
    }

    public String removeDuplicates(String S) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char topC = stack.peek();
                if (c == topC) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
