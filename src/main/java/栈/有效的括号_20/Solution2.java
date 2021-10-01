package 栈.有效的括号_20;

import java.util.ArrayDeque;

public class Solution2 {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character stackTopC = stack.peek();
                boolean isPair = (c == ')' && stackTopC == '(')
                    || (c == '}' && stackTopC == '{')
                    || (c == ']' && stackTopC == '[');
                if (isPair) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }
}
