/**
 * https://leetcode-cn.com/problems/make-the-string-great/
 */
package 栈.整理字符串_1544;

import java.util.ArrayDeque;

public class Solution_1544 {
    public String makeGood(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character topC = stack.peek();
                if (Character.toUpperCase(c) == Character.toUpperCase(topC) &&
                        ((Character.isLowerCase(topC) && Character.isUpperCase(c))
                                || (Character.isUpperCase(topC) && Character.isLowerCase(c)))
                ) {
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
