package 栈.棒球比赛_682;

import java.util.ArrayDeque;

public class Solution2 {
    public int calPoints(String[] ops) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if (op.equals("+")) {
                Integer last1 = stack.pop();
                Integer last2 = stack.pop();
                Integer cur = last1 + last2;
                stack.push(last2);
                stack.push(last1);
                stack.push(cur);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }
}
