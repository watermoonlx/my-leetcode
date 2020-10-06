/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
package 栈.有效的括号_20;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
    }

    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put('(', ')');
        bracketsMap.put('{', '}');
        bracketsMap.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (bracketsMap.containsKey(c)) {
                stack.push(c);
            } else if (bracketsMap.containsValue(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char topC = stack.pop();
                if (bracketsMap.get(topC) != c) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
