package 栈.比较含退格的字符串_844;

import java.util.ArrayDeque;

public class Solution_844 {
    public boolean backspaceCompare(String S, String T) {
        return this.getString(S).equals(this.getString(T));
    }

    private String getString(String s) {
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

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
