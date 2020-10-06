/**
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
package 栈.删除最外层的括号_1021;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    public String removeOuterParentheses(String S) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayList<Character> primitive = new ArrayList<>();
        String result = "";

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            primitive.add(c);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                char[] chars = new char[primitive.size() - 2];
                for (int j = 1; j < primitive.size() - 1; j++) {
                    chars[j - 1] = primitive.get(j);
                }
                result += String.valueOf(chars);
                primitive.clear();
            }
        }

        return result;
    }
}
