/**
 * https://leetcode-cn.com/problems/build-an-array-with-stack-operations/
 */
package 栈.用栈操作构建数组_1441;

import java.util.ArrayList;
import java.util.List;

public class Solution_1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> actions = new ArrayList<>();
        int cursor = 0;
        for (int num = 1; cursor<target.length && num <= n; num++) {
            actions.add("Push");
            if (target[cursor] == num) {
                cursor++;
            }else {
                actions.add("Pop");
            }
        }
        return actions;
    }
}
