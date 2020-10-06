package 栈.棒球比赛_682;

import java.util.ArrayDeque;

public class Solution_682 {
    public int calPoints(String[] ops) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int thisRoundNum = num1 + num2;
                stack.push(num2);
                stack.push(num1);
                stack.push(thisRoundNum);
            } else if (op.equals("D")) {
                int num = stack.pop();
                int thisRoundNum = num * 2;
                stack.push(num);
                stack.push(thisRoundNum);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                int thisRoundNum = Integer.parseInt(op);
                stack.push(thisRoundNum);
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
