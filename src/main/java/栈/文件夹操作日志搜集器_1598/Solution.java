package 栈.文件夹操作日志搜集器_1598;

import java.util.ArrayDeque;

public class Solution {
    public int minOperations(String[] logs) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                stack.push(log);
            }
        }
        return stack.size();
    }
}
