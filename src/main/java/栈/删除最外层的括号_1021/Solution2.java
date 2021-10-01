package 栈.删除最外层的括号_1021;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution2 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> tempCharList = new ArrayList<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            tempCharList.add(c);
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        sb.append(this.buildBracketString(tempCharList));
                        tempCharList.clear();
                    }
                }
            }
        }
        return sb.toString();
    }

    private String buildBracketString(ArrayList<Character> tempCharList) {
        if (tempCharList == null || tempCharList.size() <= 2) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < tempCharList.size() - 1; i++) {
            sb.append(tempCharList.get(i));
        }
        return sb.toString();
    }
}
