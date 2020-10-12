package 贪心;

import java.util.ArrayDeque;

public class 分割平衡字符串_1221 {
    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if ((c == 'L' && stack.peek() == 'R')
                        || (c == 'R' && stack.peek() == 'L')) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        count++;
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return count;
    }
}
