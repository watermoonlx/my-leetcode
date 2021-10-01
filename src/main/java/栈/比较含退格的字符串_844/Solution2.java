package 栈.比较含退格的字符串_844;

import java.util.ArrayDeque;

public class Solution2 {
    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        ArrayDeque<Character> stack1 = this.compact(s);
        ArrayDeque<Character> stack2 = this.compact(t);
        if (stack1.size() != stack2.size()) {
            return false;
        } else {
            while (!stack1.isEmpty()) {
                if (!stack1.pop().equals(stack2.pop())) {
                    return false;
                }
            }
        }

        return true;
    }

    private ArrayDeque<Character> compact(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }
}
