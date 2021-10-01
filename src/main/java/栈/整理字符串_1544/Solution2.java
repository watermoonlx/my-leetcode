package 栈.整理字符串_1544;

import java.util.ArrayDeque;

public class Solution2 {
    public String makeGood(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character prevC = stack.peek();
                if (c == prevC) {
                    stack.push(c);
                } else {
                    if (Character.toLowerCase(c) == Character.toLowerCase(prevC)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
